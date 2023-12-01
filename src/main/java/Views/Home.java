/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Views.Homes.MenuHomes;
import Views.Users.MenuUsers;
import Views.Electricity.MenuCompany;

import Models.User;
import Controllers.UserController;
import javax.swing.JOptionPane;

/**
 *
 * @author gerar
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    
    private String rutLogeado;
    
    public Home() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    public void setRutLogeado(String rut){
        this.rutLogeado=rut;
    }
    
    public String getRutLogeado(){
        return this.rutLogeado;
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
        lbMessage = new javax.swing.JLabel();
        btnUserInfo = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnElectricityCompany = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        lbHomes = new javax.swing.JLabel();
        lbElectricityCompany = new javax.swing.JLabel();
        lbUser = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpHome.setBackground(new java.awt.Color(255, 255, 255));

        jpNavbar.setBackground(new java.awt.Color(0, 255, 102));

        lbMessage.setBackground(new java.awt.Color(255, 255, 255));
        lbMessage.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbMessage.setForeground(new java.awt.Color(0, 0, 0));
        lbMessage.setText("EcoEnergyApp");

        btnUserInfo.setBackground(new java.awt.Color(0, 255, 102));
        btnUserInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario.png"))); // NOI18N
        btnUserInfo.setBorder(null);
        btnUserInfo.setContentAreaFilled(false);
        btnUserInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserInfo.setFocusPainted(false);
        btnUserInfo.setFocusable(false);
        btnUserInfo.setRequestFocusEnabled(false);
        btnUserInfo.setRolloverEnabled(false);
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
                .addGap(255, 255, 255)
                .addComponent(lbMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUserInfo)
                .addGap(16, 16, 16))
        );
        jpNavbarLayout.setVerticalGroup(
            jpNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNavbarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbMessage)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jpNavbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnUserInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/casa.png"))); // NOI18N
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnElectricityCompany.setBackground(new java.awt.Color(255, 255, 255));
        btnElectricityCompany.setIcon(new javax.swing.ImageIcon(getClass().getResource("/torre.png"))); // NOI18N
        btnElectricityCompany.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnElectricityCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElectricityCompanyActionPerformed(evt);
            }
        });

        btnUser.setBackground(new java.awt.Color(255, 255, 255));
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/grupo.png"))); // NOI18N
        btnUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        lbHomes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbHomes.setForeground(new java.awt.Color(0, 0, 0));
        lbHomes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHomes.setText("Domicilios");
        lbHomes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbElectricityCompany.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbElectricityCompany.setForeground(new java.awt.Color(0, 0, 0));
        lbElectricityCompany.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbElectricityCompany.setText("Compañias Electricidad");
        lbElectricityCompany.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbUser.setForeground(new java.awt.Color(0, 0, 0));
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUser.setText("Usuarios");
        lbUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpHomeLayout = new javax.swing.GroupLayout(jpHome);
        jpHome.setLayout(jpHomeLayout);
        jpHomeLayout.setHorizontalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpNavbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHomeLayout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbHomes, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHomeLayout.createSequentialGroup()
                        .addComponent(btnElectricityCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addComponent(lbElectricityCompany, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(80, 80, 80))
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpHomeLayout.setVerticalGroup(
            jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpHomeLayout.createSequentialGroup()
                .addComponent(jpNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpHomeLayout.createSequentialGroup()
                        .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHomes)
                            .addComponent(lbUser)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpHomeLayout.createSequentialGroup()
                        .addComponent(btnElectricityCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbElectricityCompany)))
                .addGap(56, 56, 56)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
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

    private void btnUserInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserInfoActionPerformed
        this.dispose();
        Perfil miPerfil= new Perfil();
        miPerfil.setRutLogeado(this.rutLogeado);
        miPerfil.setVisible(true);
    }//GEN-LAST:event_btnUserInfoActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.dispose();
        MenuHomes mh = new MenuHomes();
        mh.setIdUser(rutLogeado);
        mh.setVisible(true);
        
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnElectricityCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElectricityCompanyActionPerformed
        this.dispose();
        MenuCompany mc = new MenuCompany();
        mc.setVisible(true);
        mc.setRut(rutLogeado);
    }//GEN-LAST:event_btnElectricityCompanyActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        UserController controlador = new UserController();
        User verificar = controlador.obtenerUsuarioPorRut(rutLogeado);
        
        if(!verificar.getRol().toUpperCase().equals("CEO") && !verificar.getRol().toUpperCase().equals("ADMIN")){
            JOptionPane.showMessageDialog(this, "No tienes acceso para entrar a esta seccion");
        }else{
            this.dispose();
            MenuUsers mu = new MenuUsers();
            mu.setRutLogeado(this.rutLogeado);
            mu.setVisible(true);
        }
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElectricityCompany;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton btnUserInfo;
    private javax.swing.JPanel jpHome;
    private javax.swing.JPanel jpNavbar;
    private javax.swing.JLabel lbElectricityCompany;
    private javax.swing.JLabel lbHomes;
    private javax.swing.JLabel lbMessage;
    private javax.swing.JLabel lbUser;
    // End of variables declaration//GEN-END:variables
}
