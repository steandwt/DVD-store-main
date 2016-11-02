
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stean
 */
public class DayRentals extends javax.swing.JPanel {

   
    public DayRentals() {
        initComponents();
        
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dailyRentals = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        jLabel1.setText("Select date:");

        dailyRentals.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rental Number", "Date Rented", "Date Returned", "Customer Number", "DVD Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dailyRentals);

        jButton1.setText("Save Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(364, 364, 364))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(90, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
       
        
       ClientMainView view = new ClientMainView();
       
       Date d = date.getDate(); 
       DateFormat f = new SimpleDateFormat("yyyy/MM/dd");
       String dd = f.format(d); 
       populateTable(dd);
        
    }//GEN-LAST:event_dateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
          String path; 
        Date d1 = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        String date = dateFormat.format(d1); 
        String fileName = "\\"+"(Day Rentals)"+date+".txt"; 
        
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showSaveDialog(this); 
        
        try{
            
            
            
        path = chooser.getSelectedFile().getCanonicalPath(); 
       
       
        FileWriter fw = new FileWriter(path+fileName); 
        out = new BufferedWriter(fw); 
        out.write(String.format("%-20s", "Rantal Number")+String.format("%-20s", "Date Rented")+String.format("%-20s", "Date Returned")
        +String.format("%-20s", "Customer Number")+String.format("%-20s", "DVD Number"));
        out.newLine();
        out.write("--------------------------------------------------------------------------------------------------");
        out.newLine();
        for(int i = 0; i<dailyRentals.getRowCount(); i++){
        out.newLine();
        for(int j = 0; j<5; j++){
        String jy = String.format("%-20s", dailyRentals.getValueAt(i, j).toString()); 
        out.write(jy);
        }    
        
        
        }
        
        
        out.close();
        }catch(IOException e){
        }catch(NullPointerException e){
        
        }
        
       
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dailyRentals;
    private org.jdesktop.swingx.JXDatePicker date;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
     private static DefaultTableModel model;
     private static BufferedWriter out = null;
public void populateTable(String date){

           
    
       ClientMainView view = new ClientMainView(); 
       ArrayList<Rental> rentals = new ArrayList<Rental>(view.getDailyRentals(date));
       
           
           
          
         
      
      
       //populates the table from the arrayList
        model = (DefaultTableModel) dailyRentals.getModel();
        model.setRowCount(0);
        for(int a = 0; a<rentals.size(); a++){
        model.addRow(new Object[]{rentals.get(a).getRentalNumber(), rentals.get(a).getDateRented(), 
        rentals.get(a).getDateReturned(), rentals.get(a).getCusNumber(), rentals.get(a).dvdNumber()});
}

                

           }
}
