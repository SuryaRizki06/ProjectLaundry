
package slides;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class slide_absenkaryawan extends javax.swing.JFrame {
private PreparedStatement stat;
private ResultSet rs;
private final DefaultTableModel model=null;
 Koneksi K = new Koneksi();
    public slide_absenkaryawan() {
        initComponents();
        K.connect();
      absensi();
      
    }
private void absensi() {
    try {
        String sql = "SELECT data_karyawan.nama_karyawan AS nama, " +
                     "absensi.waktu_masuk AS masuk, " +
                     "absensi.waktu_keluar AS keluar, " +
                     "data_karyawan.job_desk AS job, " +
                     "absensi.status AS Kehadiran " +
                     "FROM absensi " +
                     "JOIN akun ON absensi.id_akun = akun.id_akun " +
                     "JOIN data_karyawan ON akun.karyawan_id = data_karyawan.id_karyawan";
        this.stat = K.getCon().prepareStatement(sql);
        this.rs = this.stat.executeQuery();

        if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(this, "Tidak ada data yang ditemukan");
            return;
        }

        // Buat model tabel baru
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Jobdesk");
        model.addColumn("Kehadiran");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Jam Masuk");
        model.addColumn("Tanggal Keluar");
        model.addColumn("Jam Keluar");

        java.text.SimpleDateFormat tanggalFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat jamFormat = new java.text.SimpleDateFormat("HH:mm:ss");

        while (rs.next()) {
            String nama = rs.getString("nama");
            String job = rs.getString("job");
            String kehadiran = rs.getString("Kehadiran");

            java.sql.Timestamp masuk = rs.getTimestamp("masuk");
            java.sql.Timestamp keluar = rs.getTimestamp("keluar");

            String tanggalMasuk = masuk != null ? tanggalFormat.format(masuk) : "-";
            String jamMasuk = masuk != null ? jamFormat.format(masuk) : "-";
            String tanggalKeluar = keluar != null ? tanggalFormat.format(keluar) : "-";
            String jamKeluar = keluar != null ? jamFormat.format(keluar) : "-";

            // isi semua kolom sesuai urutan
            model.addRow(new Object[]{nama, job, kehadiran, tanggalMasuk, jamMasuk, tanggalKeluar, jamKeluar});
        }

        absensi.setModel(model);

        absensi.repaint();
        absensi.revalidate();
        System.out.println("Data berhasil ditampilkan");
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menampilkan data.");
    }
}


private void cari(String keyword) {
    try {
        String sql = "SELECT data_karyawan.nama_karyawan AS nama, " +
                     "absensi.waktu_masuk AS masuk, " +
                     "absensi.waktu_keluar AS keluar, " +
                     "data_karyawan.job_desk AS job, " +
                     "absensi.status AS Kehadiran " +
                     "FROM absensi " +
                     "JOIN akun ON absensi.id_akun = akun.id_akun " +
                     "JOIN data_karyawan ON akun.karyawan_id = data_karyawan.id_karyawan " +
                     "WHERE data_karyawan.nama_karyawan LIKE ? " +
                     "OR data_karyawan.job_desk LIKE ? " +
                     "OR absensi.status LIKE ?";

        this.stat = K.getCon().prepareStatement(sql);
        String searchKeyword = "%" + keyword + "%";
        this.stat.setString(1, searchKeyword);
        this.stat.setString(2, searchKeyword);
        this.stat.setString(3, searchKeyword);

        this.rs = this.stat.executeQuery();

        if (!rs.isBeforeFirst()) {
            JOptionPane.showMessageDialog(this, "Tidak ada data yang ditemukan untuk kata kunci: " + keyword);
            return;
        }

        DefaultTableModel cari = new DefaultTableModel();
        cari.addColumn("Nama");
        cari.addColumn("Jobdesk");
        cari.addColumn("Kehadiran");
        cari.addColumn("Tanggal Masuk");
        cari.addColumn("Jam Masuk");
        cari.addColumn("Tanggal Keluar");
        cari.addColumn("Jam Keluar");

        java.text.SimpleDateFormat tanggalFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat jamFormat = new java.text.SimpleDateFormat("HH:mm:ss");

        while (rs.next()) {
            String nama = rs.getString("nama");
            String job = rs.getString("job");
            String kehadiran = rs.getString("Kehadiran");

            java.sql.Timestamp masuk = rs.getTimestamp("masuk");
            java.sql.Timestamp keluar = rs.getTimestamp("keluar");

            String tanggalMasuk = masuk != null ? tanggalFormat.format(masuk) : "-";
            String jamMasuk = masuk != null ? jamFormat.format(masuk) : "-";
            String tanggalKeluar = keluar != null ? tanggalFormat.format(keluar) : "-";
            String jamKeluar = keluar != null ? jamFormat.format(keluar) : "-";

            cari.addRow(new Object[]{nama, job, kehadiran, tanggalMasuk, jamMasuk, tanggalKeluar, jamKeluar});
        }

        absensi.setModel(cari);

        absensi.repaint();
        absensi.revalidate();
        System.out.println("Data hasil pencarian berhasil ditampilkan");

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat mencari data.");
    }
}





    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        absensi = new javax.swing.JTable();
        jumlah_terlambat = new javax.swing.JLabel();
        jumlah_ontime = new javax.swing.JLabel();
        typing_terlambat = new javax.swing.JLabel();
        typing_ontime = new javax.swing.JLabel();
        search_icon = new javax.swing.JButton();
        searchbar_karyawan = new javax.swing.JTextField();
        terlambat_icon = new javax.swing.JLabel();
        On_time_icon = new javax.swing.JLabel();
        typing_keluar = new javax.swing.JLabel();
        typing_nootif = new javax.swing.JLabel();
        typing_karyawan = new javax.swing.JLabel();
        typing_laporan = new javax.swing.JLabel();
        typing_transaksi = new javax.swing.JLabel();
        typing_pesanan = new javax.swing.JLabel();
        typing_dashboard = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        profil = new javax.swing.JLabel();
        icon_laporan = new javax.swing.JLabel();
        icon_karyawan = new javax.swing.JLabel();
        icon_notifikasi = new javax.swing.JLabel();
        icon_keluar = new javax.swing.JLabel();
        icon_transaksi = new javax.swing.JLabel();
        icon_pesanan = new javax.swing.JLabel();
        icon_dashboard = new javax.swing.JLabel();
        dashboard = new javax.swing.JLabel();
        background_putih = new javax.swing.JLabel();
        background_kuning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        absensi.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        absensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Jobdesk", "Jam Masuk", "Jam Pulang"
            }
        ));
        jScrollPane1.setViewportView(absensi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 1040, 360));

        jumlah_terlambat.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        jumlah_terlambat.setForeground(new java.awt.Color(250, 9, 2));
        jumlah_terlambat.setText("2");
        getContentPane().add(jumlah_terlambat, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 20, 30));

        jumlah_ontime.setFont(new java.awt.Font("Consolas", 1, 30)); // NOI18N
        jumlah_ontime.setForeground(new java.awt.Color(0, 151, 178));
        jumlah_ontime.setText("7");
        getContentPane().add(jumlah_ontime, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 20, 30));

        typing_terlambat.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        typing_terlambat.setForeground(new java.awt.Color(115, 115, 115));
        typing_terlambat.setText("Terlambat");
        getContentPane().add(typing_terlambat, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, -1, 30));

        typing_ontime.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        typing_ontime.setForeground(new java.awt.Color(115, 115, 115));
        typing_ontime.setText("On Time");
        getContentPane().add(typing_ontime, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, 30));

        search_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture_absen/search icon.png"))); // NOI18N
        search_icon.setBorderPainted(false);
        search_icon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_iconMouseClicked(evt);
            }
        });
        search_icon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_iconActionPerformed(evt);
            }
        });
        getContentPane().add(search_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 330, 30, 30));

        searchbar_karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbar_karyawanActionPerformed(evt);
            }
        });
        getContentPane().add(searchbar_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 320, 330, 50));

        terlambat_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture_absen/terlambat icon.png"))); // NOI18N
        getContentPane().add(terlambat_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, -1, -1));

        On_time_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture_absen/logo on time.png"))); // NOI18N
        getContentPane().add(On_time_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        typing_keluar.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        typing_keluar.setForeground(new java.awt.Color(242, 242, 242));
        typing_keluar.setText("Keluar");
        getContentPane().add(typing_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 740, -1, 30));

        typing_nootif.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        typing_nootif.setForeground(new java.awt.Color(242, 242, 242));
        typing_nootif.setText("Notifikasi");
        getContentPane().add(typing_nootif, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 650, -1, 40));

        typing_karyawan.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        typing_karyawan.setForeground(new java.awt.Color(242, 242, 242));
        typing_karyawan.setText("Karyawan");
        getContentPane().add(typing_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, -1, 30));

        typing_laporan.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        typing_laporan.setForeground(new java.awt.Color(242, 242, 242));
        typing_laporan.setText("Laporan");
        getContentPane().add(typing_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, -1, 30));

        typing_transaksi.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        typing_transaksi.setForeground(new java.awt.Color(242, 242, 242));
        typing_transaksi.setText("Transaksi");
        getContentPane().add(typing_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, -1, 30));

        typing_pesanan.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        typing_pesanan.setForeground(new java.awt.Color(242, 242, 242));
        typing_pesanan.setText("Pesanan");
        getContentPane().add(typing_pesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, 30));

        typing_dashboard.setFont(new java.awt.Font("Consolas", 1, 22)); // NOI18N
        typing_dashboard.setForeground(new java.awt.Color(242, 242, 242));
        typing_dashboard.setText("Dashboard");
        getContentPane().add(typing_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 252, -1, 30));

        welcome.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        welcome.setForeground(new java.awt.Color(242, 242, 242));
        welcome.setText("Welcome, Elsa");
        getContentPane().add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide3_dashboard/profil.png"))); // NOI18N
        getContentPane().add(profil, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        icon_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide3_dashboard/icon_laporan.png"))); // NOI18N
        getContentPane().add(icon_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -150, -1, -1));

        icon_karyawan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide3_dashboard/icon_karyawan.png"))); // NOI18N
        getContentPane().add(icon_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -160, -1, -1));

        icon_notifikasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide3_dashboard/icon_notif.png"))); // NOI18N
        getContentPane().add(icon_notifikasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -170, -1, -1));

        icon_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide3_dashboard/icon_keluar.png"))); // NOI18N
        getContentPane().add(icon_keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -180, -1, -1));

        icon_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide3_dashboard/icon_transaksi.png"))); // NOI18N
        getContentPane().add(icon_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -140, -1, -1));

        icon_pesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide3_dashboard/icon_pesanan.png"))); // NOI18N
        icon_pesanan.setText("jLabel2");
        getContentPane().add(icon_pesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -140, -1, -1));

        icon_dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide3_dashboard/icon_dashboard.png"))); // NOI18N
        icon_dashboard.setText("jLabel2");
        getContentPane().add(icon_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -140, -1, -1));

        dashboard.setFont(new java.awt.Font("Segoe UI Black", 1, 48)); // NOI18N
        dashboard.setForeground(new java.awt.Color(0, 102, 102));
        dashboard.setText("Kehadiran");
        getContentPane().add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 530, 60));

        background_putih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide3_dashboard/background putih.png"))); // NOI18N
        getContentPane().add(background_putih, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        background_kuning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide1_login/background kuning.png"))); // NOI18N
        getContentPane().add(background_kuning, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1030));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_iconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_iconActionPerformed
       cari(searchbar_karyawan.getText());
    }//GEN-LAST:event_search_iconActionPerformed

    private void searchbar_karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbar_karyawanActionPerformed
           cari(searchbar_karyawan.getText());
    }//GEN-LAST:event_searchbar_karyawanActionPerformed

    private void search_iconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_iconMouseClicked
       //  cari(searchbar_karyawan.getText());
    }//GEN-LAST:event_search_iconMouseClicked


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
            java.util.logging.Logger.getLogger(slide_absenkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(slide_absenkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(slide_absenkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(slide_absenkaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new slide_absenkaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel On_time_icon;
    private javax.swing.JTable absensi;
    private javax.swing.JLabel background_kuning;
    private javax.swing.JLabel background_putih;
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel icon_dashboard;
    private javax.swing.JLabel icon_karyawan;
    private javax.swing.JLabel icon_keluar;
    private javax.swing.JLabel icon_laporan;
    private javax.swing.JLabel icon_notifikasi;
    private javax.swing.JLabel icon_pesanan;
    private javax.swing.JLabel icon_transaksi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jumlah_ontime;
    private javax.swing.JLabel jumlah_terlambat;
    private javax.swing.JLabel profil;
    private javax.swing.JButton search_icon;
    private javax.swing.JTextField searchbar_karyawan;
    private javax.swing.JLabel terlambat_icon;
    private javax.swing.JLabel typing_dashboard;
    private javax.swing.JLabel typing_karyawan;
    private javax.swing.JLabel typing_keluar;
    private javax.swing.JLabel typing_laporan;
    private javax.swing.JLabel typing_nootif;
    private javax.swing.JLabel typing_ontime;
    private javax.swing.JLabel typing_pesanan;
    private javax.swing.JLabel typing_terlambat;
    private javax.swing.JLabel typing_transaksi;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
