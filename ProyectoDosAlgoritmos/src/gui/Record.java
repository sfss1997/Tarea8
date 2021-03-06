
package gui;

import chartGenerator.BarChart3D;
import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.DistributionOrder;
import domain.Product;
import domain.TableAdministrator;
import domain.User;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import static tda.LoadTda.batchMap;
import static tda.LoadTda.categoryMap;
import static tda.LoadTda.cellarGraph;
import static tda.LoadTda.distributionOrderList;
import static tda.LoadTda.userList;

/**
 * Interfaz Historial de pedidos y gráficos.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class Record extends javax.swing.JFrame {

    TableRowSorter tableRowSorterCategory;
    TableRowSorter tableRowSorterBatch;
    TableRowSorter tableRowSorterUser;
    private ArrayList<TableAdministrator> tableList = new ArrayList<>();
    
    public Record() throws ParseException {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icons/truck.png")).getImage());
         BarChart3D barChart3D = new BarChart3D();
        try {
            barChart3D.BarChart(chartPanel);
        } catch (IOException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ConfirmExit confirmExit = new ConfirmExit();
                confirmExit.setVisible(true);
            }
        });
    } 
    
    /**
     * Llena la tabla de productos entregados según un rango de fechas.
     * @throws ParseException 
     */
    private void fillTable() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 0; i < distributionOrderList.size(); i++) {
            DistributionOrder distributionOrder = distributionOrderList.get(i);
            if (dateFormat.parse(distributionOrder.getOrderDate()).after(jXDatePicker1.getDate())
                    && dateFormat.parse(distributionOrder.getOrderDate()).before(jXDatePicker2.getDate())) {
                for (int j = 0; j < distributionOrder.getProductList().size(); j++) {
                    Product product = distributionOrder.getProductList().get(j);
                    TableAdministrator tableAdministrator = new TableAdministrator();
                    tableAdministrator.setProductName(product.getName());

                    for (int k = 0; k < cellarGraph.list().size(); k++) {
                        Cellar cellar = (Cellar) cellarGraph.list().get(k);
                        if (cellar.getIdCellar() == distributionOrder.getIdDestinyCellar()) {
                            tableAdministrator.setCellarName(cellar.getName());
                        }
                    }
                
                Iterator iterator = categoryMap.keySet().iterator();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    Category category = categoryMap.get(key);
                    if(category.getIdCategory() == product.getIdCategory()) {
                        tableAdministrator.setCategoryName(category.getName());
                    }
                }
                
                Iterator iterator2 = batchMap.keySet().iterator();
                while (iterator2.hasNext()) {
                    Integer key = (Integer) iterator2.next();
                    Batch batch = batchMap.get(key);
                    if(batch.getIdBatch() == product.getIdBatch()) {
                            tableAdministrator.setBatchCode(batch.getBatchCode());
                        }
                    }

                    for (int a = 0; a < userList.size(); a++) {
                        User user = userList.get(a);
                        if (user.getIdUser() == distributionOrder.getIdOperator()) {
                            tableAdministrator.setOperatorName(user.getName());
                        }
                    }

                    tableList.add(tableAdministrator);
                }
            }
        }
        
       String[][] array = new String[tableList.size()][5];
        for (int i = 0; i < tableList.size(); i++) {
            array[i][0] = tableList.get(i).getProductName();
            array[i][1] = tableList.get(i).getCellarName();
            array[i][2] = tableList.get(i).getCategoryName();
            array[i][3] = tableList.get(i).getBatchCode();
            array[i][4] = tableList.get(i).getOperatorName();
            
        }
        table.setModel(new javax.swing.table.DefaultTableModel(array, new String[]{"Producto", "Bodega", "Categoría", "Lote", "Operador"}));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        chartPanel = new javax.swing.JPanel();
        returnMaintenanceButton = new javax.swing.JButton();
        categoryTextField = new javax.swing.JTextField();
        batchTextField = new javax.swing.JTextField();
        userTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jXDatePicker2 = new org.jdesktop.swingx.JXDatePicker();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Historial de productos");

        jPanel1.setBackground(new java.awt.Color(153, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Producto", "Bodega", "Categoría", "Lote", "Operador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 521, 233));

        javax.swing.GroupLayout chartPanelLayout = new javax.swing.GroupLayout(chartPanel);
        chartPanel.setLayout(chartPanelLayout);
        chartPanelLayout.setHorizontalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        chartPanelLayout.setVerticalGroup(
            chartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jPanel1.add(chartPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 80, -1, -1));

        returnMaintenanceButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        returnMaintenanceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salir-con-boton-en-esquema.png"))); // NOI18N
        returnMaintenanceButton.setText("Salir");
        returnMaintenanceButton.setBorderPainted(false);
        returnMaintenanceButton.setContentAreaFilled(false);
        returnMaintenanceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnMaintenanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnMaintenanceButtonActionPerformed(evt);
            }
        });
        jPanel1.add(returnMaintenanceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 500, -1, -1));

        categoryTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                categoryTextFieldKeyTyped(evt);
            }
        });
        jPanel1.add(categoryTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 72, -1));

        batchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                batchTextFieldKeyTyped(evt);
            }
        });
        jPanel1.add(batchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 65, -1));

        userTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userTextFieldKeyTyped(evt);
            }
        });
        jPanel1.add(userTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 78, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/crecimiento.png"))); // NOI18N
        jLabel1.setText("Historial de productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 37, 246, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lupa-para-buscar.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lupa-para-buscar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lupa-para-buscar.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tareas.png"))); // NOI18N
        jLabel5.setText("Lista de productos entregados");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 25, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setText("Rango de fechas");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));
        jPanel1.add(jXDatePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 140, -1));
        jPanel1.add(jXDatePicker2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 140, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("De:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("a:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        searchButton.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/lupa-para-buscar.png"))); // NOI18N
        searchButton.setText("Buscar");
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnMaintenanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnMaintenanceButtonActionPerformed
        Administrator administrator = new Administrator();
        administrator.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_returnMaintenanceButtonActionPerformed

    private void categoryTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryTextFieldKeyTyped
        categoryTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent event) {
                tableRowSorterCategory.setRowFilter(RowFilter.regexFilter("(?i)"+categoryTextField.getText(), 2));
            }
        });
        tableRowSorterCategory = new TableRowSorter(table.getModel());
        table.setRowSorter(tableRowSorterCategory);
    }//GEN-LAST:event_categoryTextFieldKeyTyped

    private void batchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_batchTextFieldKeyTyped
        batchTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent event) {
                tableRowSorterBatch.setRowFilter(RowFilter.regexFilter("(?i)"+batchTextField.getText(), 3));
            }
        });
        tableRowSorterBatch = new TableRowSorter(table.getModel());
        table.setRowSorter(tableRowSorterBatch);
    }//GEN-LAST:event_batchTextFieldKeyTyped

    private void userTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTextFieldKeyTyped
        userTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent event) {
                tableRowSorterUser.setRowFilter(RowFilter.regexFilter("(?i)"+userTextField.getText(), 4));
            }
        });
        tableRowSorterUser = new TableRowSorter(table.getModel());
        table.setRowSorter(tableRowSorterUser);
    }//GEN-LAST:event_userTextFieldKeyTyped

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        tableList.clear();
        try {
            fillTable();
        } catch (ParseException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Record.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Record().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField batchTextField;
    private javax.swing.JTextField categoryTextField;
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker2;
    private javax.swing.JButton returnMaintenanceButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable table;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
