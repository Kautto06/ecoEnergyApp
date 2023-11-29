/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views.Users;

/**
 *
 * @author gerar
 */
public class ModificarRolUser extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public ModificarRolUser() {
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

        jpHome = new javax.swing.JPanel();
        jpNavbar = new javax.swing.JPanel();
        btnReturn = new javax.swing.JButton();
        btnUserInfo = new javax.swing.JButton();
        lbIcon = new javax.swing.JLabel();
        lbMessage = new javax.swing.JLabel();
        tfRol = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpHome.setBackground(new java.awt.Color(255, 255, 255));

        jpNavbar.setBackground(new java.awt.Color(0, 255, 102));

        btnReturn.setBackground(new java.awt.Color(0, 255, 102));
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/flecha.png"))); // NOI18N
        btnReturn.setBorder(null);
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        btnUserInfo.setBackground(new java.awt.Color(0, 255, 102));
        btnUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario.png"))); // NOI18N
        btnUserInfo.setBorder(null);
        btnUserInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpNavbarLayout = new javax.swing.GroupLayout(jpNavbar);
        jpNavbar.setLayout(jpNavbarLayout);
        jpNavbarLayout.setHorizontalGroup(
            jpNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavbarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUserInfo)
                    .addComponent(btnReturn))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jpNavbarLayout.setVerticalGroup(
            jpNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUserInfo)
                .addGap(16, 16, 16))
        );

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eco-energy.png"))); // NOI18N

        lbMessage.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(0, 0, 0));
        lbMessage.setText("Ingrese el nuevo rol del usuario (CEO,ADMIN,USER): ");

        tfRol.setBackground(new java.awt.Color(255, 255, 255));
        tfRol.setForeground(new java.awt.Color(0, 0, 0));
        tfRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRolActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Confirmar");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpHomeLayout = new javax.swing.GroupLayout(jpHome);
        jpHome.setLayout(jpHomeLayout);
        jpHomeLayout.setHorizontalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addComponent(jpNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHomeLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(lbIcon))
                    .addGroup(jpHomeLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfRol, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMessage)))
                    .addGroup(jpHomeLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62))
        );
        jpHomeLayout.setVerticalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNavbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfRol, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUserInfoActionPerformed

    private void tfRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRolActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarRolUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarRolUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarRolUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarRolUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarRolUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnUserInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jpHome;
    private javax.swing.JPanel jpNavbar;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JTextField tfRol;
    // End of variables declaration//GEN-END:variables
}
