
package bagian;
import java .sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {
private PreparedStatement stat;
private ResultSet rs;
 Koneksi K = new Koneksi();
 
 class Flogin{
     int iduser;
     String username,password;
     
     public Flogin(){
     this.iduser=0;
     this.username=txtusername.getText();
     this.password=txtpassword.getText();
 }
 }
    public login() {
        initComponents();
        K.connect();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        btnlogin = new javax.swing.JButton();
        btnregister = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusername.setBorder(null);
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 320, 60));

        txtpassword.setBorder(null);
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 320, 60));

        btnlogin.setBackground(new java.awt.Color(0, 204, 0));
        btnlogin.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        btnlogin.setText("login");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 610, 130, 60));

        btnregister.setBackground(new java.awt.Color(0, 204, 0));
        btnregister.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        btnregister.setText("registrasi");
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 610, 130, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo hlmn login (1) (1).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, -1, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/logo laudry.png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 460, 640));

        jLabel1.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, -1, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Backgrounf Login (1).jpg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // bismillah iso
        Flogin f = new Flogin();
        try {
            this.stat= K.getCon().prepareStatement("select * from akun where "
                    + "username= '"+f.username+"' and password='"+f.password+"'");
            this.rs= this.stat.executeQuery();
            
            if(rs.next()){
                if (txtusername.getText().equals(rs.getString("username"))&&
                    txtpassword.getText().equals("password"));
                {
                    menu d = new menu();
                    d.setVisible(true);
                    dispose();
                    
                }
            }else{
                JOptionPane.showMessageDialog(null," username atau password salah");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
  
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
     register reg = new register();
     reg.setVisible(true);
   
    }//GEN-LAST:event_btnregisterActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnregister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
