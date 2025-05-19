
package slides;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.Time;
public class slide_absenFIX extends javax.swing.JFrame {
private PreparedStatement stat;
private ResultSet rs;
Koneksi K = new Koneksi();
private DefaultTableModel model=null;
    public slide_absenFIX() {
        initComponents();
        K.connect();
        absensi();
    }

    private void absensi(){
    DefaultTableModel model = new DefaultTableModel();
model.addColumn("Nama Karyawan");
model.addColumn("Status");
model.addColumn("Waktu Masuk");
model.addColumn("Waktu Keluar");

try {
    String query = "SELECT data_karyawan.nama_karyawan, absensi.status, absensi.waktu_masuk, absensi.waktu_keluar " +
                   "FROM absensi " +
                   "JOIN akun ON absensi.id_akun = akun.id_akun " +
                   "JOIN data_karyawan ON akun.karyawan_id = data_karyawan.id_karyawan";

    this.stat = K.getCon().prepareStatement(query);
    this.rs = this.stat.executeQuery();
    if (!rs.isBeforeFirst()) {
        JOptionPane.showMessageDialog(this, "DATA ABSENSI TIDAK DI TEMUKAN");
    }
    else{
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        jTable1.repaint();
        jTable1.revalidate();
        System.out.println("halo");
    }
    

} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Gagal memuat data ke tabel!");
}

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search_icon = new javax.swing.JButton();
        searchbar_karyawan = new javax.swing.JTextField();
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

        jTable1.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 1040, 450));

        search_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture_absen/search icon.png"))); // NOI18N
        search_icon.setBorderPainted(false);
        getContentPane().add(search_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 30, 30));
        getContentPane().add(searchbar_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 330, 50));

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

        background_putih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture_absen/latarbelakang_white.png"))); // NOI18N
        getContentPane().add(background_putih, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        background_kuning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/slide1_login/background kuning.png"))); // NOI18N
        getContentPane().add(background_kuning, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1030));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(slide_absenFIX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(slide_absenFIX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(slide_absenFIX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(slide_absenFIX.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new slide_absenFIX().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel profil;
    private javax.swing.JButton search_icon;
    private javax.swing.JTextField searchbar_karyawan;
    private javax.swing.JLabel typing_dashboard;
    private javax.swing.JLabel typing_karyawan;
    private javax.swing.JLabel typing_keluar;
    private javax.swing.JLabel typing_laporan;
    private javax.swing.JLabel typing_nootif;
    private javax.swing.JLabel typing_pesanan;
    private javax.swing.JLabel typing_transaksi;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
