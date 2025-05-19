
package slides;
import java .sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;

public class tesawur extends javax.swing.JFrame {
private PreparedStatement stat;
private ResultSet rs;
 Koneksi K = new Koneksi();
 
 
 
    public tesawur() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        K.connect();
        ambil_data();
    }
    

        
    public class ItemCombo {
    private int id;
    private String nama;

    public ItemCombo(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return nama; // Ini yang akan tampil di combo box
    }
}

    
private void ambil_data() {
    try {
        String sql = "SELECT id_karyawan, nama_karyawan FROM data_karyawan";
        PreparedStatement stat1 = K.getCon().prepareStatement(sql);
        ResultSet rs1 = stat1.executeQuery();

        DefaultComboBoxModel<ItemCombo> data = new DefaultComboBoxModel<>();
        while (rs1.next()) {
            int id = rs1.getInt("id_karyawan");
            String nama = rs1.getString("nama_karyawan");
            data.addElement(new ItemCombo(id, nama));
        }
        pilih_karyawan.setModel(data);
    } catch (Exception e) {
        e.printStackTrace();
    }

    try {
        String sql2 = "SELECT id_role, nama_role FROM role";
        PreparedStatement stat2 = K.getCon().prepareStatement(sql2);
        ResultSet rs2 = stat2.executeQuery();

        DefaultComboBoxModel<ItemCombo> job = new DefaultComboBoxModel<>();
        while (rs2.next()) {
            int id = rs2.getInt("id_role");
            String nama = rs2.getString("nama_role");
            job.addElement(new ItemCombo(id, nama));
        }
        piliih_job.setModel(job);
      //  piliih_job.setModel(job);
    } catch (Exception e) {
        e.printStackTrace();
    }
}



    private void simpan(){
       
        //simpan akun
        try {
            String sql = "INSERT INTO akun ( ";
        } catch (Exception e) {
        }
 
    }
    
    
    @SuppressWarnings("unchecke")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        membuatpw = new javax.swing.JLabel();
        passw2 = new javax.swing.JTextField();
        type2 = new javax.swing.JLabel();
        rfid = new javax.swing.JTextField();
        passw1 = new javax.swing.JTextField();
        type = new javax.swing.JLabel();
        icon_dua = new javax.swing.JLabel();
        daftar = new javax.swing.JButton();
        nama = new javax.swing.JTextField();
        icon_satu = new javax.swing.JLabel();
        daftarakun = new javax.swing.JLabel();
        logo_soclean = new javax.swing.JLabel();
        bubble = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        membuatpw.setFont(new java.awt.Font("Segoe UI Black", 1, 40)); // NOI18N
        membuatpw.setForeground(new java.awt.Color(255, 255, 255));
        membuatpw.setText("Membuat Kata Sandi");
        getContentPane().add(membuatpw, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 350, 480, 60));

        passw2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        passw2.setForeground(new java.awt.Color(0, 102, 102));
        passw2.setText("Kata Sandi");
        getContentPane().add(passw2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 460, 500, 50));

        type2.setForeground(new java.awt.Color(255, 255, 255));
        type2.setText("Kata sandi harus berisi 8 huruf kecil dan kapital, angka dan juga simbol (!@#$%^&*,.?)");
        getContentPane().add(type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1035, 520, 540, -1));

        rfid.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        rfid.setForeground(new java.awt.Color(0, 102, 102));
        rfid.setText("tap rfid di sini");
        getContentPane().add(rfid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 720, 510, 50));

        passw1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        passw1.setForeground(new java.awt.Color(0, 102, 102));
        passw1.setText("Konfirmasi Kata Sandi");
        getContentPane().add(passw1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 550, 500, 50));

        type.setForeground(new java.awt.Color(255, 255, 255));
        type.setText("Pastikan Anda memasukkan kata sandi yang tepat!");
        getContentPane().add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 610, 340, -1));

        icon_dua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture_absen/no.2 signup.png"))); // NOI18N
        getContentPane().add(icon_dua, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 280, 100, 100));

        daftar.setBackground(new java.awt.Color(239, 196, 9));
        daftar.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        daftar.setText("Daftar");
        daftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daftarMouseClicked(evt);
            }
        });
        getContentPane().add(daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 730, 210, 40));

        nama.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        nama.setForeground(new java.awt.Color(0, 102, 102));
        nama.setText("username");
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 490, 510, 50));

        icon_satu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture_absen/no.1 signup.png"))); // NOI18N
        getContentPane().add(icon_satu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 90, 100));

        daftarakun.setFont(new java.awt.Font("Segoe UI Black", 1, 40)); // NOI18N
        daftarakun.setForeground(new java.awt.Color(0, 102, 102));
        daftarakun.setText("Daftar Akun SoClean Laundry");
        getContentPane().add(daftarakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        logo_soclean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide1_login/logo soclean.png"))); // NOI18N
        getContentPane().add(logo_soclean, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 60, -1, -1));

        bubble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide1_login/bubble.png"))); // NOI18N
        getContentPane().add(bubble, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -60, 1580, 920));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture_absen/background_login_signin.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 0, 1920, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void daftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarMouseClicked
        simpan();
    }//GEN-LAST:event_daftarMouseClicked

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
            java.util.logging.Logger.getLogger(signin_app_bisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signin_app_bisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signin_app_bisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signin_app_bisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signin_app_bisa().setVisible(true);
            }
        });
    }

   private javax.swing.JComboBox<ItemCombo> pilih_karyawan;
    private javax.swing.JComboBox<ItemCombo> piliih_job;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel bubble;
    private javax.swing.JButton daftar;
    private javax.swing.JLabel daftarakun;
    private javax.swing.JLabel icon_dua;
    private javax.swing.JLabel icon_satu;
    private javax.swing.JLabel logo_soclean;
    private javax.swing.JLabel membuatpw;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField passw1;
    private javax.swing.JTextField passw2;
    private javax.swing.JTextField rfid;
    private javax.swing.JLabel type;
    private javax.swing.JLabel type2;
    // End of variables declaration//GEN-END:variables
}
