/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;



/**
 *
 * @author gerar
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpLogin = new javax.swing.JPanel();
        jpBanner = new javax.swing.JPanel();
        lbMessage = new javax.swing.JLabel();
        lbMessage1 = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        lbRut = new javax.swing.JLabel();
        tfRut = new javax.swing.JTextField();
        lbPassword = new javax.swing.JLabel();
        tfPassword = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lbMessage2 = new javax.swing.JLabel();
        btnRegisterHere = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jpLogin.setBackground(new java.awt.Color(255, 255, 255));

        jpBanner.setBackground(new java.awt.Color(0, 255, 102));

        lbMessage.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(0, 0, 0));
        lbMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage.setText("Bienvenido a");

        lbMessage1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMessage1.setForeground(new java.awt.Color(0, 0, 0));
        lbMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMessage1.setText("EcoEnergyApp");

        javax.swing.GroupLayout jpBannerLayout = new javax.swing.GroupLayout(jpBanner);
        jpBanner.setLayout(jpBannerLayout);
        jpBannerLayout.setHorizontalGroup(
            jpBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBannerLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBannerLayout.setVerticalGroup(
            jpBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBannerLayout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(lbMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessage1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eco-energy.png"))); // NOI18N

        lbRut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbRut.setForeground(new java.awt.Color(0, 0, 0));
        lbRut.setText("RUT");

        tfRut.setBackground(new java.awt.Color(255, 255, 255));
        tfRut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRutActionPerformed(evt);
            }
        });

        lbPassword.setBackground(new java.awt.Color(255, 255, 255));
        lbPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbPassword.setForeground(new java.awt.Color(0, 0, 0));
        lbPassword.setText("Contraseña");

        tfPassword.setBackground(new java.awt.Color(255, 255, 255));
        tfPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tfPassword.setForeground(new java.awt.Color(0, 0, 0));
        tfPassword.setToolTipText("");
        tfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPasswordActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 0));
        btnLogin.setText("Iniciar Sesion");
        btnLogin.setActionCommand("");
        btnLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 0, 0));
        btnExit.setText("Salir");
        btnExit.setActionCommand("");
        btnExit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lbMessage2.setBackground(new java.awt.Color(255, 255, 255));
        lbMessage2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbMessage2.setForeground(new java.awt.Color(0, 0, 0));
        lbMessage2.setText("No tienes cuenta?");

        btnRegisterHere.setBackground(new java.awt.Color(255, 255, 255));
        btnRegisterHere.setForeground(new java.awt.Color(51, 102, 255));
        btnRegisterHere.setText("Registrate aqui");
        btnRegisterHere.setActionCommand("");
        btnRegisterHere.setBorder(null);
        btnRegisterHere.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegisterHere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterHereActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addComponent(jpBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpLoginLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(lbIcon))
                            .addGroup(jpLoginLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbRut, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfRut)
                                    .addComponent(lbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfPassword)
                                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                        .addComponent(lbMessage2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnRegisterHere, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbRut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRut, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbMessage2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegisterHere)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRutActionPerformed

    private void tfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPasswordActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnRegisterHereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterHereActionPerformed
        this.dispose();
        Registro register = new Registro();
        register.setVisible(true);
    }//GEN-LAST:event_btnRegisterHereActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        this.dispose();
        Home menu= new Home();
        menu.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

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
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegisterHere;
    private javax.swing.JPanel jpBanner;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbMessage1;
    private javax.swing.JLabel lbMessage2;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbRut;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfRut;
    // End of variables declaration//GEN-END:variables
}
