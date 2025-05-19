package slides;
import java .sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;

public class signin_app_bisa extends javax.swing.JFrame {
private PreparedStatement stat;
private ResultSet rs;
 Koneksi K = new Koneksi();
    public signin_app_bisa() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        K.connect();
        ambil_data();
    ambil_id();
    }
    
private void ambil_data(){
   
    //ambil data nama karyawan
    try {
           String sql = "SELECT nama_karyawan FROM data_karyawan";
        stat = K.getCon().prepareStatement(sql);
        rs = stat.executeQuery();

       
DefaultComboBoxModel<String> data = new DefaultComboBoxModel<>();
            while (rs.next()) {  
                String nama_karywanString = rs.getString("nama_karyawan");
                data.addElement(nama_karywanString);
               
        }
       pilih_karyawan.setModel(data);  
    } catch (Exception e) {
   e.printStackTrace(); }
    
// ambil data job  
    try {
        String sql1 = "SELECT nama_role FROM role";
        stat = K.getCon().prepareStatement(sql1);
        rs = stat.executeQuery();
        
        DefaultComboBoxModel <String> job = new DefaultComboBoxModel<>();
        while (rs.next()) {            
          String job_karyawan = rs.getString("nama_role");
            job.addElement(job_karyawan);
        }
        piliih_job.setModel(job);
        
    } catch (Exception e) {
   e.printStackTrace();
    }
    
 
    
}

//deklasi penyimpanan id
int id_karyawan;
int id_akun;
int id_role;

public void ambil_id(){
    
    //ambil id karyawan
    try {
        String code = "SELECT id_karyawan FROM data_karyawan"
                + " WHERE nama_karyawan= ? ";
        stat = K.getCon().prepareStatement(code);
        stat.setString(1, pilih_karyawan.getSelectedItem().toString());
        rs = stat.executeQuery();
        if (rs.next()) {
            id_karyawan = rs.getInt("id_karyawan");
     
            
        }
           
        
    } catch (Exception e) {
        e.printStackTrace();
    }    
     
     
      //ambil id job
    try {
          String code = "SELECT id_role FROM role"
                + " WHERE nama_role= ? ";
        stat = K.getCon().prepareStatement(code);
        stat.setString(1, piliih_job.getSelectedItem().toString());
        rs = stat.executeQuery();
        if (rs.next()) {
             id_role = rs.getInt("id_role");
            System.out.println(id_role +"cd");
            
        }
    } catch (Exception e) {
    }
    
     
   
    
}

public void simpan(){
  // cek apakah ada yang kosong
      if (nama.getText().isEmpty() || passw2.getText().isEmpty() || rfid.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Harap lengkapi semua data!", "Warning", JOptionPane.WARNING_MESSAGE);
    return;
}
      
      //cek konfirmasi password
      if (!passw2.equals(passw1)) {
        JOptionPane.showMessageDialog(this, "Password dan konfirmasi password tidak sama!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
      
      

    // Cek panjang minimal
    if (passw2.getText().length() < 8) {
        JOptionPane.showMessageDialog(this, "Password harus minimal 8 karakter!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Cek harus mengandung huruf besar, huruf kecil, angka dan simbol
    if (!passw2.getText().matches(".*[A-Z].*") ||
        !passw2.getText().matches(".*[a-z].*") ||
        !passw2.getText().matches(".*\\d.*") ||
        !passw2.getText().matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
        JOptionPane.showMessageDialog(this, "Password harus mengandung huruf besar, huruf kecil, angka, dan simbol!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

// Menanyakan konfirmasi apakah data benar
    int pilihan = JOptionPane.showConfirmDialog(this, "Apakah data yang Anda masukkan sudah benar?\nUsername: " + nama + "\nRFID: " + rfid, "Konfirmasi Data", JOptionPane.YES_NO_OPTION);

    if (pilihan == JOptionPane.YES_OPTION) {
    
     try {
            String sql3 = "INSERT INTO akun (karyawan_id, username, password, rfid) VALUES (?, ?, ?, ?)";
            PreparedStatement stat = K.getCon().prepareStatement(sql3);
           
            stat.setInt(1, id_karyawan); // id_karyawan sebagai parameter pertama
            stat.setString(2, nama.getText()); // Pastikan kamu sudah punya username
            stat.setString(3, passw2.getText()); // Pastikan kamu sudah punya password
            stat.setString(4, rfid.getText()); // Pastikan kamu sudah punya rfid
            
            int rowsAffected = stat.executeUpdate(); // Mengeksekusi query
            if (rowsAffected > 0) {
                System.out.println("Data akun berhasil disimpan!");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Mencetak error jika terjadi
        }
    
      
     
      try {
           String code = "SELECT id_akun FROM akun"
                + " WHERE username= ? ";
        stat = K.getCon().prepareStatement(code);
        stat.setString(1, nama.getText());
        rs = stat.executeQuery();
        if (rs.next()) {
             id_akun = rs.getInt("id_akun");
             System.out.println(id_akun + "ef");
         
            
        }
    } catch (Exception e) {
    }
    
     
     
     
     
     
    try {
        String sql4 = "INSERT INTO user_role(id_akun, id_role) VALUES (?,?)";
    PreparedStatement hasil = K.getCon().prepareStatement(sql4);
    hasil.setInt(1, id_akun);
    hasil.setInt(2, id_role);
    hasil.executeUpdate();

        System.out.println("tersimpan");
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    
    }
 
   JOptionPane.showMessageDialog(this, "Akun berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
    
    
    
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logo_soclean = new javax.swing.JLabel();
        membuatpw = new javax.swing.JLabel();
        passw2 = new javax.swing.JTextField();
        type2 = new javax.swing.JLabel();
        piliih_job = new javax.swing.JComboBox<>();
        pilih_karyawan = new javax.swing.JComboBox<>();
        rfid = new javax.swing.JTextField();
        passw1 = new javax.swing.JTextField();
        type = new javax.swing.JLabel();
        icon_dua = new javax.swing.JLabel();
        daftar = new javax.swing.JButton();
        nama = new javax.swing.JTextField();
        icon_satu = new javax.swing.JLabel();
        daftarakun = new javax.swing.JLabel();
        bubble = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        logo_soclean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide1_login/logo soclean.png"))); // NOI18N

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

        piliih_job.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        piliih_job.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                piliih_jobItemStateChanged(evt);
            }
        });
        getContentPane().add(piliih_job, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 510, 50));

        pilih_karyawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pilih_karyawan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pilih_karyawanItemStateChanged(evt);
            }
        });
        getContentPane().add(pilih_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 570, 510, 50));

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
        daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarActionPerformed(evt);
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

        bubble.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide1_login/bubble.png"))); // NOI18N
        getContentPane().add(bubble, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, -60, 1580, 920));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture_absen/background_login_signin.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 0, 1920, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void daftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarMouseClicked
        simpan();
    }//GEN-LAST:event_daftarMouseClicked

    private void daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daftarActionPerformed

    private void pilih_karyawanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pilih_karyawanItemStateChanged
     ambil_id();
    }//GEN-LAST:event_pilih_karyawanItemStateChanged

    private void piliih_jobItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_piliih_jobItemStateChanged
      ambil_id();
    }//GEN-LAST:event_piliih_jobItemStateChanged

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signin_app_bisa().setVisible(true);
            }
        });
    }

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
    private javax.swing.JComboBox<String> pilih_karyawan;
    private javax.swing.JComboBox<String> piliih_job;
    private javax.swing.JTextField rfid;
    private javax.swing.JLabel type;
    private javax.swing.JLabel type2;
    // End of variables declaration//GEN-END:variables
}
