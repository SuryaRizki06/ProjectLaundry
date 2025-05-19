
package slides;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class tes extends javax.swing.JFrame {
private PreparedStatement stat;
private ResultSet rs;
Koneksi K= new Koneksi();
  

    public tes() {
        initComponents();
        K.connect();
    }
   
     public void catatAbsensi(String idAkun, boolean isLogin) {
    try {
        String sql;
        PreparedStatement pst;
        
        if (isLogin) {
            // Cek apakah user sudah absen masuk hari ini
            sql = "SELECT id_absensi FROM absensi WHERE id_akun = ? AND DATE(waktu_masuk) = CURDATE()";
            pst = K.getCon().prepareStatement(sql);
            pst.setString(1, idAkun);
            ResultSet rs = pst.executeQuery();

            if (!rs.next()) {
                // Jika belum absen, catat absen masuk
                sql = "INSERT INTO absensi (id_akun, waktu_masuk, ) VALUES (?, NOW())";
                pst = K.getCon().prepareStatement(sql);
                pst.setString(1, idAkun);
                pst.executeUpdate();
                System.out.println("Absensi masuk berhasil dicatat.");
            }
        } else {
            // Cek apakah user sudah absen masuk dan belum absen keluar hari ini
            sql = "SELECT id_absensi FROM absensi WHERE id_akun = ? AND DATE(waktu_masuk) = CURDATE() AND waktu_keluar IS NULL";
            pst = K.getCon().prepareStatement(sql);
            pst.setString(1, idAkun);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Jika sudah absen masuk tapi belum absen keluar, update waktu keluar
                sql = "UPDATE absensi SET waktu_keluar = NOW(), status_kehadiran WHERE id_absensi = ?";
                pst = K.getCon().prepareStatement(sql);
                pst.setInt(1, rs.getInt("id_absensi"));
                pst.executeUpdate();
                System.out.println("Absensi keluar berhasil dicatat.");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error saat mencatat absensi: " + e.getMessage());
    }
}       
public void logout() {
    String input = user_txt.getText().trim(); // Bisa RFID atau Username

    if (input.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Masukkan RFID atau Username untuk logout!");
        return;
    }

    try {
        // Cek apakah input adalah RFID atau username
        String sql = "SELECT id_akun FROM akun WHERE rfid = ? OR username = ?";
        PreparedStatement pst = K.getCon().prepareStatement(sql);
        pst.setString(1, input);
        pst.setString(2, input);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String idAkun = rs.getString("id_akun");

            // Catat absensi keluar
            catatAbsensi(idAkun, false);

            JOptionPane.showMessageDialog(null, "Logout berhasil. Absensi keluar tercatat.");
            
            // Kembali ke halaman login
            slide1_login B= new slide1_login();
            B.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Akun tidak ditemukan, logout gagal!");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error saat logout: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        user_txt = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        user_txt.setText("username");

        jTextField1.setText("password");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1)
                    .addComponent(user_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(user_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
logout();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(tes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField user_txt;
    // End of variables declaration//GEN-END:variables
}
