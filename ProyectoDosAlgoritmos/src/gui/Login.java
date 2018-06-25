package gui;

import LinkedBinaryTree.TreeException;
import domain.User;
import static gui.LogisticsDistribution.userId;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import lab_grafos_algoritmos.GraphException;
import tda.CrudMaintenance;
import tda.LoadFiles;
import static tda.LoadTda.userList;

/**
 * Interfaz ventana principal login.
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Logi
     */
    public Login() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/icons/truck.png")).getImage());
        
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        enterButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();
        showPasswordLabel = new javax.swing.JLabel();
        creditsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocation(new java.awt.Point(450, 200));

        jPanel1.setBackground(new java.awt.Color(153, 204, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Usuario:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Contraseña:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        userNameTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        userNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(userNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 122, -1));

        passwordTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(passwordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 122, -1));

        enterButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        enterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iniciar-la-sesion.png"))); // NOI18N
        enterButton.setText("Ingresar");
        enterButton.setBorderPainted(false);
        enterButton.setContentAreaFilled(false);
        enterButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });
        jPanel1.add(enterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        messageLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        messageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(messageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 183, 280, 18));

        showPasswordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pass.png"))); // NOI18N
        showPasswordLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showPasswordLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showPasswordLabelMouseExited(evt);
            }
        });
        jPanel1.add(showPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 33, 33));

        creditsButton.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        creditsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon.png"))); // NOI18N
        creditsButton.setBorderPainted(false);
        creditsButton.setContentAreaFilled(false);
        creditsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        creditsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(creditsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 11, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTextFieldActionPerformed

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed
        try {
            passwordTextField.setEchoChar((char) 0);
            LogisticsDistribution logisticsDistribution = new LogisticsDistribution();
            CrudMaintenance crudMaintenance = new CrudMaintenance();
            Administrator administrator = new Administrator();
            
            if (crudMaintenance.validateUser(userNameTextField.getText(), passwordTextField.getText())) {
                if (crudMaintenance.validateRole(userNameTextField.getText()) == 1) {
                    logisticsDistribution.setVisible(true);
                    this.setVisible(false);
                    for (int i = 0; i < userList.size(); i++) {
                        User user = userList.get(i);
                        if (user.getUser().equals(userNameTextField.getText())) {
                            userId = user.getIdUser();
                        }
                    }
                } else if (crudMaintenance.validateRole(userNameTextField.getText()) == 2) {
                    administrator.setVisible(true);
                    this.setVisible(false);
                }
            } else {
                messageLabel.setText("El usuario no se encuentra registrado");
            }
        } catch (TreeException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_enterButtonActionPerformed

    private void showPasswordLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordLabelMouseEntered
        passwordTextField.setEchoChar((char) 0);
    }//GEN-LAST:event_showPasswordLabelMouseEntered

    private void showPasswordLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPasswordLabelMouseExited
        passwordTextField.setEchoChar('•');
    }//GEN-LAST:event_showPasswordLabelMouseExited

    private void creditsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsButtonActionPerformed
        Credits credits = new Credits();
        credits.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_creditsButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creditsButton;
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel showPasswordLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables
}
