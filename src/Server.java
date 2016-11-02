



import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Server implements Runnable{
    
    private static Socket socket; 
    private static ServerSocket server;
    private static ObjectInputStream in; 
    private static ObjectOutputStream out; 
    private static Connection connection; 
    private static Statement stmt; 
    private static PreparedStatement prep;
    private static ArrayList<Customer> customerList; 
    private static ArrayList<DVD> dvdList; 
    //
    public static String name; 
    public static String surname; 
    public static String phoneNumber; 
    //
    public static String title; 
    public static String cat; 
    public static String year; 
    private static int dvdNumber;
    private static int number; 
    //
    private static String cusNumber; 
    private static String rentdvdNumber; 
    private static int rentalNumber; 
    private static String currentDate; 
    private static String dateReturned; 
    private static double credit  = 0; 
    private static boolean newRelease; 
    private static double price = 0; 
    private static String newmm = ""; 
    private static String newdd = ""; 
    private static String path = null; 
    
    @Override
    public void run() {
        
        //creates server socket
        try{
        server = new ServerSocket(30000);
        }catch(IOException e){
        e.printStackTrace();
        }
        
        
       
        try{
        JFileChooser chooser = new JFileChooser("Select database file");
        FileFilter filter = new FileNameExtensionFilter("database files", "db");
        chooser.setFileFilter(filter);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setDialogTitle("Open database file");
        chooser.showOpenDialog(null); 
        path = chooser.getSelectedFile().getCanonicalPath(); 
        }catch(IOException e){
        e.printStackTrace();
        }catch(NullPointerException e){
        System.exit(0);
        }
         try{
            //loads the driver
        Class.forName("org.sqlite.JDBC"); 
        //create connection and statement instanses
         connection = DriverManager.getConnection("jdbc:sqlite:"+path); 
         stmt =  connection.createStatement(); 
        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }catch(SQLException e){
        e.printStackTrace();
        }
         
         
        //wait and accept client connection
        try{
        socket = server.accept(); 
        out = new ObjectOutputStream(socket.getOutputStream()); 
        out.flush();
        in = new ObjectInputStream(socket.getInputStream()); 
        } catch(IOException e){
        e.printStackTrace();
        }
        
        
        String clientMessage; 
        try{
        while((clientMessage = (String)in.readObject()) != null){
            //runs client message through switch statement
            String command = clientMessage.substring(0, 6);
            switch(command){
                //case to get customer table contents
               case "tableC": 
                  try{
                    
                    prep = connection.prepareStatement("select * from customer");
                    ResultSet content = prep.executeQuery(); 
                    customerList = new ArrayList<Customer>();
                    while(content.next()){
                        
                    int number = content.getInt(1); 
                    String name = content.getString(2); 
                    String surname = content.getString(3); 
                    String phoneNumber = content.getString(4); 
                    double credit = content.getDouble(5); 
                    boolean canRent = content.getBoolean(6); 
                    Customer cus = new Customer(number, name, surname, phoneNumber, credit, canRent);
                    customerList.add(cus); 
                    }
                    out.writeObject(customerList);
                     }catch(SQLException e){
                     e.printStackTrace();
                    }
                       break; 
                       
                       //case to add new user to database
                case "addNew": 
                    
                        String newMessage = clientMessage.substring(6);
                       
                       
                        
                        StringTokenizer token = new StringTokenizer(newMessage, "#");
                        while(token.hasMoreElements()){
                        name = token.nextToken(); 
                        surname = token.nextToken();
                        phoneNumber = token.nextToken(); 
                                
                        }
                       
                        //generates random customer number
                        Random rand = new Random();
                        int cusNum = rand.nextInt(1000)+1;
                        try{
                        prep = connection.prepareStatement("select * from customer where custNumber = ?"); 
                        prep.setInt(1, cusNum);
                        ResultSet rs = prep.executeQuery(); 
                        while(rs.next()){
                            
                            int newNum = rand.nextInt(1000)+1;
                            cusNum = newNum; 
                            }
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                       
                        double credit = 100.0; 
                        boolean canRent = true; 
                        
                     try(PreparedStatement prep = connection.prepareStatement("insert into customer(custNumber,"
                             + " firstName, surname, "
                  + "phoneNumber, credit, canRent) values(?, ?, ?, ?, ?, ?)")){
          
                    prep.setInt(1, cusNum);
                    prep.setString(2, name);
                    prep.setString(3, surname);
                    prep.setString(4, phoneNumber);
                    prep.setDouble(5, credit);
                    prep.setBoolean(6, canRent);
                    prep.executeUpdate(); 
                    
                    try{
                    out.writeObject("New customer was added");
                    }catch(IOException e){
                    e.printStackTrace();
                    }
              
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                    
                    break; 
                    
                    //case to remove user from database
                case "remove": 
                    
                        String nameToRemove = clientMessage.substring(6);
                       
                        try(PreparedStatement prep = connection.prepareStatement("delete from customer where custNumber = ?")){
          
                            prep.setString(1, nameToRemove);
                            prep.executeUpdate(); 
                    
              
                        }catch(SQLException e){
                           e.printStackTrace();
                        }
                    
                    break; 
                    //case to get dvd table contents
                case "dvdTab": 
                    
                     try{
                    
                    prep = connection.prepareStatement("select * from dvd");
                    ResultSet content = prep.executeQuery(); 
                    dvdList = new ArrayList<DVD>();
                    while(content.next()){
                        
                    int number = content.getInt(1); 
                    String title = content.getString(2); 
                    String category = content.getString(3); 
                    boolean newRelease = content.getBoolean(4); 
                    boolean available = content.getBoolean(5); 
                    
                   DVD dvd = new DVD(number, title, getdvdCat(category), newRelease, available);
                   dvdList.add(dvd); 
                    }
                    out.writeObject(dvdList);
                    
                     }catch(SQLException e){
                     e.printStackTrace();
                    }
                    break; 
                    //case to add new dvd to dvd table 
                case "addDvd": 
                    
                     String dvdMessage = clientMessage.substring(6);
                       
                       
                        
                        StringTokenizer dvdtoken = new StringTokenizer(dvdMessage, "#");
                        while(dvdtoken.hasMoreElements()){
                        title = dvdtoken.nextToken(); 
                        cat = dvdtoken.nextToken();
                        year = dvdtoken.nextToken(); 
                                
                        }
                       
                       
                       
                        try{
                            prep = connection.prepareStatement("select MAX(dvdNumber) from dvd"); 
                            ResultSet rs = prep.executeQuery(); 
                            while(rs.next()){
                            number = rs.getInt(1)+1;
                             }
                      
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                       
                        
                        Boolean yearR = Boolean.parseBoolean(year);
                        Boolean canR = true;
                        
                        
                     try(PreparedStatement prep = connection.prepareStatement("insert into dvd(dvdNumber,"
                             + " title, category,newRelease, availableForRent) values(?, ?, ?, ?, ?)")){
          
                    prep.setInt(1, number);
                    prep.setString(2, title);
                    prep.setString(3, cat);
                    prep.setBoolean(4, yearR);
                    prep.setBoolean(5, canR);
                    prep.executeUpdate(); 
                    
                   
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                    
                     try{
                     out.writeObject("New DVD as been added");
                     }catch(IOException e){
                     e.printStackTrace();
                     }
                    break; 
                  //case to remove dvd from table
                case "remDvd": 
                    
                     String removeDvd = clientMessage.substring(6);
                      try(PreparedStatement prep = connection.prepareStatement("delete from dvd where dvdNumber = ?")){
          
                            prep.setString(1, removeDvd);
                            prep.executeUpdate(); 
                    
              
                        }catch(SQLException e){
                           e.printStackTrace();
                        }
                     
                    break;
                   //case to rent a dvd
                case "rentDv": 
                    
                    double cuscredit = 0.0;
                    double rentPrice = 0.0; 
                    
                     String rentDvd = clientMessage.substring(6);
                     StringTokenizer rentToken = new StringTokenizer(rentDvd, "#");
                        while(rentToken.hasMoreElements()){
                        cusNumber = rentToken.nextToken(); 
                        rentdvdNumber = rentToken.nextToken();
                        }
                        
                        try{
                            prep = connection.prepareStatement("select credit from customer where custNumber=?"); 
                            prep.setString(1, cusNumber);
                            ResultSet rs = prep.executeQuery(); 
                            while(rs.next()){
                            cuscredit = rs.getDouble(1);
                            }
                      
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                        
                        try{
                            prep = connection.prepareStatement("select newRelease from dvd where dvdNumber=?"); 
                            prep.setString(1, rentdvdNumber);
                            ResultSet rs = prep.executeQuery(); 
                            while(rs.next()){
                            newRelease = rs.getBoolean(1);
                            }}catch(SQLException e){
                            e.printStackTrace();
                        }
                        
                        if(newRelease == true){
                            rentPrice = 15.0; 
                            }else{
                            rentPrice = 10.0; 
                        }
                       
                            
                            if(cuscredit - rentPrice >= 0){
                            rentDvd(cusNumber,cuscredit, rentdvdNumber, rentPrice);
                            out.writeObject("yes");
                                
                            }else{
                                String message = Double.toString(cuscredit)+"#"+Double.toString(rentPrice);
                                out.writeObject("noo"+message);
                                String reply = (String) in.readObject();
                                
                                if(reply.equals("pay")){
                                
                                    rentDvd(cusNumber,rentPrice, rentdvdNumber, rentPrice);
                                    
                                }else if(reply.equals("load")){
                                
                                    rentDvd(cusNumber,(cuscredit+100.0), rentdvdNumber, rentPrice);
                                    
                                }
                                
                            
                            }
                         break; 
                         
                         //case to retrieve rentals from table
                case "rental": 
                    
                   
                    String option = clientMessage.substring(6);
                                         
                    
                     try{
                    
                         if(option.equals("NA")){
                         prep = connection.prepareStatement("select * from rental where dateReturned=?");
                          prep.setString(1, option);
                         }else{
                         prep = connection.prepareStatement("select * from rental");
                         }
                   
                    ResultSet content = prep.executeQuery(); 
                    ArrayList<Rental> rentals = new ArrayList<Rental>();
                    while(content.next()){
                        
                    int rentNumber = content.getInt(1); 
                    String dateRented = content.getString(2); 
                    String dateReturned = content.getString(3); 
                    int cusNumber = content.getInt(4); 
                    int dvdNumber = content.getInt(5); 
                    
                   Rental rental = new Rental(rentNumber, dateRented, dateReturned, cusNumber, dvdNumber);
                   rentals.add(rental); 
                    }
                    out.writeObject(rentals);
                    
                     }catch(SQLException e){
                     e.printStackTrace();
                    }
                    
                    break; 
                    
                   //case for returning a dvd
                case "retRen": 
                    
                    String rentNum = ""; 
                    String cusNumber = "";
                    String dvdNumber = ""; 
                    Rental rental = new Rental();
                    String dateRen = ""; 
                    String dateRe = "";
                    double rentCredit = 0.0; 
                     
                    
                    String returnDvd = clientMessage.substring(6);
                     StringTokenizer returnToken = new StringTokenizer(returnDvd, "#");
                        while(returnToken.hasMoreElements()){
                        rentNum = returnToken.nextToken(); 
                        cusNumber = returnToken.nextToken();
                        dvdNumber = returnToken.nextToken(); 
                        }
                    
                         try{
                            prep = connection.prepareStatement("select credit from customer where custNumber=?"); 
                            prep.setString(1, cusNumber);
                            ResultSet rs = prep.executeQuery(); 
                            while(rs.next()){
                            rentCredit = rs.getDouble(1);
                            
                             }}catch(SQLException e){
                            e.printStackTrace();
                        }
                         
                         try{
                            prep = connection.prepareStatement("select * from rental where rentalNumber=?"); 
                            prep.setString(1, rentNum);
                            ResultSet rs = prep.executeQuery(); 
                            while(rs.next()){
                            int renNum = rs.getInt(1); 
                            dateRen = rs.getString(2); 
                            int cusN = rs.getInt(4); 
                            int dvdN = rs.getInt(5); 
                             }}catch(SQLException e){
                            e.printStackTrace();
                        }
                        
                         LocalDateTime now = LocalDateTime.now();
                         String yyyy = Integer.toString(now.getYear()); 
                         String mm = Integer.toString(now.getMonthValue()); 
                         String dd = Integer.toString(now.getDayOfMonth()); 
                         
                         String returnDate = yyyy+"/"+mm+"/"+dd;
                         rental = new Rental(Integer.parseInt(rentNum), dateRen , returnDate, Integer.parseInt(cusNumber), 
                                 Integer.parseInt(dvdNumber));
                         
                         double penaltyCost = rental.getTotalPenaltyCost(); 
                        
                         if(rentCredit - penaltyCost > 0){
                         
                             try(PreparedStatement prep = connection.prepareStatement("update rental set dateReturned"
                                    + "=? where rentalNumber =?")){
                                
                    prep.setString(1, returnDate);
                    prep.setString(2, rentNum);
                    prep.executeUpdate(); 
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                         try(PreparedStatement prep = connection.prepareStatement("update customer set credit=?, canRent"
                                    + "=? where custNumber =?")){
                                
                    prep.setDouble(1, (rentCredit-penaltyCost));
                    prep.setBoolean(2, true);
                    prep.setString(3, cusNumber);
                    prep.executeUpdate(); 
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                         try(PreparedStatement prep = connection.prepareStatement("update dvd set availableForRent"
                                    + "=? where dvdNumber =?")){
                                
                    prep.setBoolean(1, true);
                    prep.setString(2, dvdNumber);
                    prep.executeUpdate(); 
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                         out.writeObject("complete");
                         }else{
                         out.writeObject("Insufficient credit to pay penalty");
                         out.writeObject(rentCredit);
                         out.writeObject(penaltyCost);
                         
                         String clientReply = (String)in.readObject(); 
                         
                         if(clientReply.equals("pay")){
                        
                    try(PreparedStatement prep = connection.prepareStatement("update customer set credit=?,"
                                    + "canRent=? where custNumber =?")){
                                
                    prep.setDouble(1,0);
                    prep.setBoolean(2, true);
                    prep.setString(3, cusNumber);
                    prep.executeUpdate(); 
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                             
                     try(PreparedStatement prep = connection.prepareStatement("update rental set dateReturned"
                                    + "=? where rentalNumber =?")){
                                
                    prep.setString(1, returnDate);
                    prep.setString(2, rentNum);
                    prep.executeUpdate(); 
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                     
                      try(PreparedStatement prep = connection.prepareStatement("update dvd set availableForRent"
                                    + "=? where dvdNumber =?")){
                                
                    prep.setBoolean(1, true);
                    prep.setString(2, dvdNumber);
                    prep.executeUpdate(); 
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                    
                         }else{
                         
                             break; 
                         
                         }           
                         }
                       break;
                       
                //case to retrieve rentals from specific date       
                case "dayRen": 
                    
                    int rentN; 
                    String dateRent; 
                    String dateRet; 
                    int cusNumb; 
                    int dvdNumb; 
                    
                    
                    String date = clientMessage.substring(6);
                    
                     ArrayList<Rental> rentals = new ArrayList<Rental>();
                    
                    
                    try{
                            prep = connection.prepareStatement("select * from rental where dateRented = ?"); 
                            prep.setString(1, date);
                            ResultSet rs = prep.executeQuery(); 
                            while(rs.next()){
                            rentN = rs.getInt(1); 
                            dateRent = rs.getString(2); 
                            dateRet = rs.getString(3); 
                            cusNumb = rs.getInt(4); 
                            dvdNumb = rs.getInt(5); 
                                
                            Rental rent = new Rental(rentN, dateRent, dateRet, cusNumb, dvdNumb);
                            rentals.add(rent); 
                            
                            }}catch(SQLException e){
                            e.printStackTrace();
                        }
                    
                    out.writeObject(rentals);
                    
                    break; 
                       
                   }
            
        
        }
        
       socket.close();
       server.close();
       out.close();
       in.close();
        
        }catch(IOException e){
        e.printStackTrace();
       }catch(ClassNotFoundException e){
       e.printStackTrace();
        }
         
    }
       
    
    //method for renting a dvd
   public static void rentDvd(String cusnum, double credit, String dvdNum, Double rentPrice){
   
       Double cred = credit; 
       String customerNumber = cusnum; 
       String dvdNumber = dvdNum; 
       Double rentPr = rentPrice; 
       
       
       try{
                            prep = connection.prepareStatement("select MAX(rentalNumber) from rental"); 
                            ResultSet rs = prep.executeQuery(); 
                            while(rs.next()){
                            rentalNumber = rs.getInt(1)+1;
                             }
                      
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                        
                         LocalDateTime now = LocalDateTime.now();
                         String yyyy = Integer.toString(now.getYear()); 
                          int mm = now.getMonthValue(); 
                          int dd = now.getDayOfMonth(); 
                          
                         if(mm < 10){
                         newmm = "0"+Integer.toString(mm); 
                         }else{
                         newmm = Integer.toString(mm); 
                         }
                         
                         if(dd < 10){
                         newdd = "0"+Integer.toString(dd); 
                         }else{
                         newdd = Integer.toString(dd); 
                         }
                         
                         String currentDate = yyyy+"/"+newmm+"/"+newdd;
                         
                         //inserts new rental into the rental table
                          try(PreparedStatement prep = connection.prepareStatement("insert into rental(rentalNumber,"
                             + " dateRented, dateReturned,custNumber, dvdNumber) values(?, ?, ?, ?, ?)")){
          
                    prep.setInt(1, rentalNumber);
                    prep.setString(2, currentDate);
                    prep.setString(3, "NA");
                    prep.setInt(4, Integer.parseInt(customerNumber));
                    prep.setInt(5, Integer.parseInt(dvdNumber));
                    prep.executeUpdate(); 
                    
                   
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                        
                          //updates customer table
                           try(PreparedStatement prep = connection.prepareStatement("update customer set credit=?, canRent=?"
                                   + "where custNumber =?")){
                               
                    prep.setDouble(1, (cred - rentPr));
                    prep.setBoolean(2, false);
                    prep.setInt(3, Integer.parseInt(customerNumber));
                    prep.executeUpdate(); 
                    
                   
                     }catch(SQLException e){
                         e.printStackTrace();
                     }
                           
                           
                           
                           //updates dvd table
                            try(PreparedStatement prep = connection.prepareStatement("update dvd set availableForRent"
                                    + "=? where dvdNumber =?")){
                                
                    prep.setBoolean(1, false);
                    prep.setInt(2, Integer.parseInt(rentdvdNumber));
                    prep.executeUpdate(); 
                     }catch(SQLException e){
                         e.printStackTrace();
                         
                   
                     }
   
   }
   
   //converts movie category for database use
   public static int getdvdCat(String cat){
   
       int i = 0; 
       
       switch(cat){
           case "horror": 
               i = 1; 
               break; 
               
           case "Sci-fi": 
               i=2; 
               break; 
               
           case "Drama": 
               i=3; 
               break; 
               
           case "Romance": 
               i=4; 
               break; 
               
           case "Comedy":
               i=5; 
               break; 
               
           case "Action": 
               i=6; 
               break; 
               
           case "Cartoon": 
               i=7; 
               break; 
               }
       return i; 
       
   }
        
    }
        
    

      

    
