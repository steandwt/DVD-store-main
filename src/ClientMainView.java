
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


public class ClientMainView extends javax.swing.JFrame {
    
    private static ObjectOutputStream out; 
    private static ObjectInputStream in; 
    private static Socket socket;   
    
    public ClientMainView() {
       
        initComponents();
        
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowListener(){
            
            @Override
            public void windowClosed(WindowEvent we) {
            }

            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we){
                try{
                out.writeObject(null);
                }catch(IOException e){
                
                }
                System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }

            
        });
       }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ddd.png"))); // NOI18N

        jMenu1.setText("Store");

        jMenu3.setText("Customers");

        jMenuItem2.setText("Add/remove");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenu1.add(jMenu3);

        jMenu4.setText("DVD");

        jMenuItem3.setText("Add/Remove");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem1.setText("Rent");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenuItem4.setText("Return");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenu1.add(jMenu4);

        jMenu2.setText("Reports");

        jMenuItem5.setText("All Rentals");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Outstanding Rentals");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Daily Rentals");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenu1.add(jMenu2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       
        AddRemoveDvd p = new AddRemoveDvd(); 
        p.setVisible(true);
        p.setSize(this.getWidth(), this.getHeight());

        this.getContentPane().removeAll();
        this.add(p);
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        AddRemoveCustomer p = new AddRemoveCustomer(); 
        p.setVisible(true);
        p.setSize(this.getWidth(), this.getHeight());

        this.getContentPane().removeAll();
        this.add(p);
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        AllRentals p = new AllRentals(); 
        p.setVisible(true);
        p.setSize(this.getWidth(), this.getHeight());

        this.getContentPane().removeAll();
        this.add(p);
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        
         Outstanding p = new Outstanding(); 
        p.setVisible(true);
        p.setSize(this.getWidth(), this.getHeight());

        this.getContentPane().removeAll();
        this.add(p);
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        RentDvdPanel p = new RentDvdPanel(); 
        p.setVisible(true);
        p.setSize(this.getWidth(), this.getHeight());

        this.getContentPane().removeAll();
        this.add(p);
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        
        ReturnDvd p = new ReturnDvd(); 
        p.setVisible(true);
        p.setSize(this.getWidth(), this.getHeight());

        this.getContentPane().removeAll();
        this.add(p);
        this.revalidate();
        this.repaint();
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        
        DayRentals p = new DayRentals(); 
        p.setVisible(true);
        p.setSize(this.getWidth(), this.getHeight());

        this.getContentPane().removeAll();
        this.add(p);
        this.revalidate();
        this.repaint();
        
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
       
        
        
    }//GEN-LAST:event_formWindowStateChanged

   
    public static void main(String args[]) {
       
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientMainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
       
        
        //creates new Server thread
        (new Thread(new Server())).start();
        //Sleeps the main tread for 1 second to get the server running
         try{
        Thread.sleep(1000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
       //connect to server and open streams
        try{
        socket = new Socket("localhost", 30000); 
        out = new ObjectOutputStream(socket.getOutputStream()); 
        out.flush();
        in = new ObjectInputStream(socket.getInputStream()); 
        
        }catch(IOException e){
            e.printStackTrace();
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientMainView().setVisible(true);
            }
        });
        
        
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
    private static ArrayList<Customer> customerList; 
    private static ArrayList<DVD> dvdList; 
    private static ArrayList<Rental> rentals; 
    private ArrayList<DVD> available; 
    Customer customer; 

    //Requests all customers in database in an arraylist format
    public ArrayList customerTable(){
    customerList = new ArrayList<Customer>();
     try{
    out.writeObject("tableC");
    out.flush();
    customerList = (ArrayList) in.readObject(); 
    }catch(IOException e){
    e.printStackTrace();
    }catch(ClassNotFoundException e){
    e.printStackTrace();
    }
   return customerList; 
}
    
    //requests all DVD's in the database
    public ArrayList dvdTable(){
    dvdList = new ArrayList<DVD>();
    try{
    out.writeObject("dvdTab");
    out.flush();
    dvdList = (ArrayList) in.readObject(); 
    }catch(IOException e){
    e.printStackTrace();
    }catch(ClassNotFoundException e){
    e.printStackTrace();
    }
    
    
    return dvdList; 
    }
    
    //sends request to server to add new customer 
    public void addNewCustomer(String name, String surname, String phoneNumber){
        
        String message = name+"#"+surname+"#"+phoneNumber; 
        
        String command = "addNew";
        try{
        out.writeObject(command+message);
        out.flush();
        String reply = (String)in.readObject();
        JOptionPane.showMessageDialog(null, reply);
        }catch(IOException e){
        e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
      
} 
    //sends request to server to add new dvd
    public void addNewDvd(String title, String cat, String year){
    
        String message = title+"#"+cat+"#"+year; 
        String command = "addDvd"; 
        
         try{
        out.writeObject(command+message);
        out.flush();
        }catch(IOException e){
        e.printStackTrace();
        }
         try{
        String reply = (String) in.readObject(); 
        JOptionPane.showMessageDialog(null, reply);
         }catch(IOException e){
         }catch(ClassNotFoundException e){
         
         }
        
    }
    
    //sends request to server to remove customer
    public void removeCustomer(int i){
    try{
        
        String number = Integer.toString(i); 
        String command = "remove"; 
        out.writeObject(command+number);
        out.flush();
    }catch(IOException e){
    e.printStackTrace();
    }
    }
    
    //sends request to server to remove dvd
    public void removeDvd(int i){
    
        String command = "remDvd"; 
        String number = Integer.toString(i);
        try{
        out.writeObject(command+number);
        out.flush();
        }catch(IOException e){
        e.printStackTrace();
        }
        
    }
    
    //sends request to server to rent a dvd
    public void rentDVD(String cusNumber, String dvdNumber){
        
        String message = ""; 
        Double credit = 0.0; 
        Double price = 0.0;
        
        String rent = cusNumber+"#"+dvdNumber; 
        String command = "rentDv"; 
        try{
        out.writeObject(command+rent);
        message = (String) in.readObject();
        
        String details = message.substring(3); 
        String submessage = message.substring(0, 3);
        if(submessage.equals("yes")){
        JOptionPane.showMessageDialog(null, "Customer has successfully rented the DVD");
        }else if(submessage.equals("noo")){
            
             StringTokenizer rentToken = new StringTokenizer(details, "#");
                        while(rentToken.hasMoreElements()){
                         credit = Double.parseDouble(rentToken.nextToken()); 
                         price = Double.parseDouble(rentToken.nextToken());
                        }
                        
                        String amountDue = Double.toString(price-credit);
                        
            
        String[] buttons = { "Pay amount due","Load R100 credits", "Cancel" };
        int rc = JOptionPane.showOptionDialog(null,"Customer credit: "+credit+"\n Price: "+price+"\n Amount due: "+amountDue , "Insuficient credit",
        JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[2]);
        if(rc == 0){
        out.writeObject("pay");
        }else if(rc == 1){
        out.writeObject("load");
        }
        }
        }catch(IOException e){
        e.printStackTrace();
        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }
        
        
    }
    
    //sends request to server to retrieve all outstanding rentals
    public ArrayList rentals(String s){
    
    rentals = new ArrayList<Rental>();
     try{
    out.writeObject("rental"+s);
    out.flush();
    rentals = (ArrayList) in.readObject(); 
    }catch(IOException e){
    e.printStackTrace();
    }catch(ClassNotFoundException e){
    e.printStackTrace();
    }
   return rentals; 
}
   
    
    //sends request to server to return a rental 
    public void returnRentl(String rentalNumber, String cusNum, String dvdNum){
    
        String command = "retRen"; 
        String message = rentalNumber+"#"+cusNum+"#"+dvdNum; 
        
        try{
        out.writeObject(command+message);
        out.flush();
        String reply = (String)in.readObject();
        if(reply.equals("complete")){
         
        JOptionPane.showMessageDialog(null, "DVD successfully returned");
        }else{
        double rentCred = (Double)in.readObject(); 
        double penalty = (Double)in.readObject(); 
        
        //Custom JOptionPane
        String[] buttons = { "Pay amount due", "Cancel" };
        int rc = JOptionPane.showOptionDialog(null, reply+"\n Credit amount: "+rentCred+"\n Penalty cost: "+penalty
        +"\n Amount payable: "+(penalty-rentCred), "Insuficient credit",
        JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[1]);
        
        
      if(rc == 0){
      //pay aamount due
      out.writeObject("pay");
      
      }else{
      out.writeObject("");
      }
       
        }
        }catch(IOException e){
        e.printStackTrace();
        }catch(ClassNotFoundException e){
        e.printStackTrace();
        }
    
    
    }
    
    //sends request to server to retrieve daily rentals
    public ArrayList getDailyRentals(String date){
    
        rentals = new ArrayList<Rental>();
        
        String command = "dayRen"; 
    try{
    out.writeObject(command+date);
    rentals = (ArrayList)in.readObject(); 
    }catch(IOException e){
    e.printStackTrace();
    }catch(ClassNotFoundException e){
    e.printStackTrace();
    }
    return rentals; 
    }
    
    
   
//closes all sockets and streams
public void closeStreams(){
try{
in.close();
out.close();
socket.close();
System.exit(0); 
}catch(IOException e){
e.printStackTrace();
}
}



}
