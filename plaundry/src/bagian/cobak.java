
package bagian;
import java .sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class cobak extends javax.swing.JFrame {
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
    public cobak() {
        initComponents();
        K.connect();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusername = new javax.swing.JTextField();
        txtpassword = new javax.swing.JPasswordField();
        BG = new javax.swing.JLabel();
        btnlogin = new javax.swing.JButton();
        btnregister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 320, 60));
        getContentPane().add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 320, 60));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/login.png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 800));

        btnlogin.setForeground(new java.awt.Color(255, 255, 255));
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        getContentPane().add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 330, 70));

        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 720, -1, -1));

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
              
                {
                    menu me = new menu();
                    me.setVisible(true);
                    
                    
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
                new cobak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton btnlogin;
    private javax.swing.JButton btnregister;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
