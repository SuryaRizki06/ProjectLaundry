package bagian;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    private String url = "jdbc:mysql://localhost/loundry";
    private String username = "root";
    private String password = "";
    private Connection con;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi berhasil");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
            
        }
    }

    public Connection getCon() {
        return con;
    }
}
