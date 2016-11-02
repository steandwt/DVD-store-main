
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class AddRemoveDvd extends javax.swing.JPanel {

   
    public AddRemoveDvd() {
        initComponents();
        //popluates the table on startup
        getTableContents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        dvdTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        yearReleased = new javax.swing.JTextField();
        addNewDvd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        dvdTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DVD Number", "Title", "Category", "New Release", "Available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dvdTable);

        jLabel1.setText("Title: ");

        jLabel3.setText("Category: ");

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "horror", "Sci-fi", "Drama", "Romance", "Comedy", "Action", "Cartoon" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        jLabel2.setText("Year Released:");

        yearReleased.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearReleasedActionPerformed(evt);
            }
        });

        addNewDvd.setText("Add new DVD");
        addNewDvd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewDvdActionPerformed(evt);
            }
        });

        jLabel4.setText("Search:");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jButton2.setText("Remove DVD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(title)
                            .addComponent(category, 0, 181, Short.MAX_VALUE)
                            .addComponent(yearReleased))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                        .addComponent(addNewDvd)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel4)))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewDvd))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(yearReleased, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(137, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void yearReleasedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearReleasedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearReleasedActionPerformed

    private void addNewDvdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewDvdActionPerformed

        ClientMainView k = new ClientMainView();
        
        String title = this.title.getText();
        String yearR = this.yearReleased.getText(); 
       
        
        if (title.trim().length()==0 || yearR.trim().length()==0){
        JOptionPane.showMessageDialog(null, "Please fill in all the fields");
        }else{
        
        String category = this.category.getSelectedItem().toString(); 
        int yearReleased = Integer.parseInt(yearR); 
        String year;  
        
        int yearRel = Calendar.getInstance().get(Calendar.YEAR); 
        if(yearReleased == yearRel){
        year = "true"; 
        }else{
        year = "false"; 
        }
        
        k.addNewDvd(title, category, year);
        
        this.title.setText("");
        this.yearReleased.setText("");
        getTableContents(); 
        } 
        
        
       
    }//GEN-LAST:event_addNewDvdActionPerformed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
      
       
        sorter.setRowFilter(RowFilter.regexFilter(this.search.getText(), 1));
        dvdTable.setRowSorter(sorter);
        
       
    }//GEN-LAST:event_searchKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
       ClientMainView k = new ClientMainView(); 
      
        int row = dvdTable.getSelectedRow();
        
        if(dvdTable.getRowSorter()!=null){
        row = dvdTable.getRowSorter().convertRowIndexToModel(row); 
        }else{
        row = dvdTable.getSelectedRow();
        }
        
        if(row == -1){
        JOptionPane.showMessageDialog(null, "Please select a DVD");
        }else{
                
          int dvdNumber = (Integer)dvdTable.getModel().getValueAt(row, 0); 
         
          k.removeDvd(dvdNumber);
          model.removeRow(row);
          getTableContents(); 
          }   

    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewDvd;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JTable dvdTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField search;
    private javax.swing.JTextField title;
    private javax.swing.JTextField yearReleased;
    // End of variables declaration//GEN-END:variables
    private static DefaultTableModel model;
    private static ClientMainView view; 
    private static DVD dvd; 
    

 public void getTableContents(){
    
       ClientMainView view = new ClientMainView(); 
       ArrayList<DVD> dvdList = new ArrayList<DVD>(view.dvdTable());
       //sorts the ArrayList in alphabetical order
       Collections.sort(dvdList, new Comparator<DVD>(){
         @Override
           public int compare(DVD t, DVD t1) {
               return t.getCategory().compareTo(t1.getCategory()); 
           }
           
       
       });
       
       //populates the table from the arrayList
        model = (DefaultTableModel) dvdTable.getModel();
        model.setRowCount(0);
        for(int a = 0; a<dvdList.size(); a++){
        model.addRow(new Object[]{dvdList.get(a).getDvdNumber(), dvdList.get(a).getTitle(), dvdList.get(a).getCategory(), 
        dvdList.get(a).isNewRelease(),dvdList.get(a).isAvailable()});
}
    
    
}
 

       
       
       
 }


