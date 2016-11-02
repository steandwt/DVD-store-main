
import static java.awt.SystemColor.text;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class RentDvdPanel extends javax.swing.JPanel {

   
    public RentDvdPanel() {
        initComponents();
        
        
        populateTables(); 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DvdRentTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        CusRentTable = new javax.swing.JTable();
        category = new javax.swing.JComboBox<>();
        rent = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        DvdRentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(DvdRentTable);

        CusRentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Number", "Name", "Surname", "Telephone Number", "Credit", "canRent"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(CusRentTable);

        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "horror", "Sci-fi", "Drama", "Romance", "Comedy", "Action", "Cartoon" }));
        category.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categoryItemStateChanged(evt);
            }
        });
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });

        rent.setText("Rent");
        rent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentActionPerformed(evt);
            }
        });

        jLabel1.setText("Filter by category:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(rent, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(rent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
       
        
        
    }//GEN-LAST:event_categoryActionPerformed

    private void categoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categoryItemStateChanged
       
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(dvdmodel);
       
        sorter.setRowFilter(RowFilter.regexFilter(this.category.getSelectedItem().toString()));
        DvdRentTable.setRowSorter(sorter);
        
    }//GEN-LAST:event_categoryItemStateChanged

    private void rentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentActionPerformed
       
        ClientMainView view = new ClientMainView();
        
        int dvdRow = DvdRentTable.getSelectedRow();
        int cusRow = CusRentTable.getSelectedRow(); 
        if(DvdRentTable.getRowSorter()!=null){
        dvdRow = DvdRentTable.getRowSorter().convertRowIndexToModel(dvdRow); 
        }else{
        dvdRow = DvdRentTable.getSelectedRow();
        }
        
        if(cusRow == -1 || dvdRow == -1){
        JOptionPane.showMessageDialog(null, "Please select a customer and a movie");
        }else{
        
        String cusNumber = CusRentTable.getModel().getValueAt(cusRow, 0).toString(); 
        String dvdNumber = DvdRentTable.getModel().getValueAt(dvdRow, 0).toString(); 
        
        Boolean cusAvailable = Boolean.parseBoolean(CusRentTable.getModel().getValueAt(cusRow, 5).toString()); 
        Boolean dvdAvailable = Boolean.parseBoolean(DvdRentTable.getModel().getValueAt(dvdRow, 4).toString());
        if(cusAvailable == false ||dvdAvailable == false){
        JOptionPane.showMessageDialog(null, "Please select a valid customer and movie");
        }else{
        view.rentDVD(cusNumber, dvdNumber);
        cusmodel.setRowCount(0);
        dvdmodel.setRowCount(0);
        populateTables(); 
        }
        
       
        
        } 
    }//GEN-LAST:event_rentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CusRentTable;
    private javax.swing.JTable DvdRentTable;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton rent;
    // End of variables declaration//GEN-END:variables
    private static ArrayList<Customer> customerList; 
    private static ArrayList<DVD> dvdList; 
    
    private static DefaultTableModel cusmodel;
    private static DefaultTableModel dvdmodel;
    
    
    public void populateTables(){
        ClientMainView view = new ClientMainView(); 
        
         //populate customer table
        customerList = new ArrayList<Customer>(view.customerTable()); 
        cusmodel = (DefaultTableModel) CusRentTable.getModel();
        cusmodel.setRowCount(0);
        for(int a = 0; a<customerList.size(); a++){
        cusmodel.addRow(new Object[]{customerList.get(a).getCustNumber(), customerList.get(a).getName(),customerList.get(a).getSurname(), 
        customerList.get(a).getPhoneNum(), customerList.get(a).getCredit(), customerList.get(a).canRent()});
        } 
        
         //populate dvd table
        dvdList = new ArrayList<DVD>(view.dvdTable());
        dvdmodel = (DefaultTableModel) DvdRentTable.getModel();
        dvdmodel.setRowCount(0);
        for(int a = 0; a<dvdList.size(); a++){
        dvdmodel.addRow(new Object[]{dvdList.get(a).getDvdNumber(), dvdList.get(a).getTitle(), dvdList.get(a).getCategory(), 
        dvdList.get(a).isNewRelease(), dvdList.get(a).isAvailable()});
        } 
    }
}
