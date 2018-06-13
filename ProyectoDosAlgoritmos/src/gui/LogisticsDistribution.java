
package gui;

/**
 * Interfaz módulo logística de distribución.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class LogisticsDistribution extends javax.swing.JPanel {

    /**
     * Creates new form LogisticsDistribution
     */
    public LogisticsDistribution() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        productsList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cellarList = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        returnLoginButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(153, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/furgoneta-de-reparto.png"))); // NOI18N
        jLabel1.setText("Logística de distribución");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/carrito.png"))); // NOI18N
        jLabel2.setText("Productos");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Monto", "Peso", "Categoría"
            }
        ));
        jScrollPane1.setViewportView(productsTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 320, 110));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mapas-y-banderas.png"))); // NOI18N
        jLabel3.setText("Ubicación");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/almacen.png"))); // NOI18N
        jLabel4.setText("Bodegas");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 66, 12, 474));

        productsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productsList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(productsList);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 109, 143));

        jLabel5.setText("***IMAGEN PRODUCTO***");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 152, 66));

        cellarList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        cellarList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(cellarList);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 107, 148));

        jLabel6.setText("***IMAGEN BODEGA***");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, -1, 76));

        confirmButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        confirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/compra-confirmada.png"))); // NOI18N
        confirmButton.setText("Confirmar");
        confirmButton.setBorderPainted(false);
        confirmButton.setContentAreaFilled(false);
        confirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });
        add(confirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, -1, -1));

        returnLoginButton.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        returnLoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salir-con-boton-en-esquema.png"))); // NOI18N
        returnLoginButton.setText("Salir");
        returnLoginButton.setBorderPainted(false);
        returnLoginButton.setContentAreaFilled(false);
        returnLoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        returnLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnLoginButtonActionPerformed(evt);
            }
        });
        add(returnLoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 490, -1, -1));
        add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 340, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void returnLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnLoginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_returnLoginButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> cellarList;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> productsList;
    private javax.swing.JTable productsTable;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton returnLoginButton;
    // End of variables declaration//GEN-END:variables
}