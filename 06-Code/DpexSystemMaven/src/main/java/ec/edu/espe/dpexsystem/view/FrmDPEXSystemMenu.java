package ec.edu.espe.dpexsystem.view;

import static java.lang.System.exit;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Sagnay
 */
public class FrmDPEXSystemMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmDPEXSystemMenu
     */
    public FrmDPEXSystemMenu() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuDpex = new javax.swing.JMenu();
        itmLogout = new javax.swing.JMenuItem();
        itmExit = new javax.swing.JMenuItem();
        mnuElectoralPackage = new javax.swing.JMenu();
        itmRegisterPackage = new javax.swing.JMenuItem();
        itmViewPackage = new javax.swing.JMenuItem();
        mnuCountry = new javax.swing.JMenu();
        itmRegisterCountry = new javax.swing.JMenuItem();
        itmViewCountries = new javax.swing.JMenuItem();
        itmShipping = new javax.swing.JMenu();
        itmShippingPackage = new javax.swing.JMenuItem();
        itmRecount = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 217, 227));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("CNE");

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel2.setText("DPEX System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(178, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel2)
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jMenuBar1.setForeground(new java.awt.Color(0, 0, 51));
        jMenuBar1.setOpaque(true);

        mnuDpex.setText("DPEX System");

        itmLogout.setText("Cerrar Sesión");
        itmLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmLogoutActionPerformed(evt);
            }
        });
        mnuDpex.add(itmLogout);

        itmExit.setText("Salir");
        itmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmExitActionPerformed(evt);
            }
        });
        mnuDpex.add(itmExit);

        jMenuBar1.add(mnuDpex);

        mnuElectoralPackage.setText("Paquetes Electorales");
        mnuElectoralPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuElectoralPackageActionPerformed(evt);
            }
        });

        itmRegisterPackage.setText("Registrar");
        itmRegisterPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegisterPackageActionPerformed(evt);
            }
        });
        mnuElectoralPackage.add(itmRegisterPackage);

        itmViewPackage.setText("Ver Paquetes");
        mnuElectoralPackage.add(itmViewPackage);

        jMenuBar1.add(mnuElectoralPackage);

        mnuCountry.setText("País");

        itmRegisterCountry.setText("Registrar");
        itmRegisterCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRegisterCountryActionPerformed(evt);
            }
        });
        mnuCountry.add(itmRegisterCountry);

        itmViewCountries.setText("Ver Paises");
        itmViewCountries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmViewCountriesActionPerformed(evt);
            }
        });
        mnuCountry.add(itmViewCountries);

        jMenuBar1.add(mnuCountry);

        itmShipping.setText("Administrador");

        itmShippingPackage.setText("Envio de Paquetes");
        itmShippingPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmShippingPackageActionPerformed(evt);
            }
        });
        itmShipping.add(itmShippingPackage);

        itmRecount.setText("Reconteo de Paquetes");
        itmRecount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmRecountActionPerformed(evt);
            }
        });
        itmShipping.add(itmRecount);

        jMenuBar1.add(itmShipping);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itmRegisterPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegisterPackageActionPerformed
        FrmElectoralPackage frmElectoralPackage = new FrmElectoralPackage();
        this.setVisible(false);
        frmElectoralPackage.setVisible(true);
    }//GEN-LAST:event_itmRegisterPackageActionPerformed

    private void itmRegisterCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRegisterCountryActionPerformed
        FrmCountry frmCountry = new FrmCountry();
        this.setVisible(false);
        frmCountry.setVisible(true);
    }//GEN-LAST:event_itmRegisterCountryActionPerformed

    private void itmLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmLogoutActionPerformed
        int selection;
        selection = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro?");
        if(selection == JOptionPane.YES_OPTION){
            FrmLogin frmLogin = new FrmLogin();
            this.setVisible(false);
            frmLogin.setVisible(true);
        }

    }//GEN-LAST:event_itmLogoutActionPerformed

    private void mnuElectoralPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuElectoralPackageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuElectoralPackageActionPerformed

    private void itmViewCountriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmViewCountriesActionPerformed
        FrmViewCountry frmViewCountries = new FrmViewCountry();
        this.setVisible(false);
        frmViewCountries.setVisible(true);
    }//GEN-LAST:event_itmViewCountriesActionPerformed

    private void itmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmExitActionPerformed
        exit(0);
    }//GEN-LAST:event_itmExitActionPerformed

    private void itmShippingPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmShippingPackageActionPerformed
        FrmShipping frmShipping = new FrmShipping();
        this.setVisible(false);
        frmShipping.setVisible(true);
    }//GEN-LAST:event_itmShippingPackageActionPerformed

    private void itmRecountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmRecountActionPerformed
        FrmRecount frmRecount = new FrmRecount();
        this.setVisible(false);
        frmRecount.setVisible(true);
    }//GEN-LAST:event_itmRecountActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDPEXSystemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDPEXSystemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDPEXSystemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDPEXSystemMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDPEXSystemMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmExit;
    private javax.swing.JMenuItem itmLogout;
    private javax.swing.JMenuItem itmRecount;
    private javax.swing.JMenuItem itmRegisterCountry;
    private javax.swing.JMenuItem itmRegisterPackage;
    private javax.swing.JMenu itmShipping;
    private javax.swing.JMenuItem itmShippingPackage;
    private javax.swing.JMenuItem itmViewCountries;
    private javax.swing.JMenuItem itmViewPackage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu mnuCountry;
    private javax.swing.JMenu mnuDpex;
    private javax.swing.JMenu mnuElectoralPackage;
    // End of variables declaration//GEN-END:variables
}
