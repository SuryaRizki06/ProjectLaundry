import java.sql.*;
import java.nio.file.*;
import java.io.File;
import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import slides.Koneksi;

public class barcode {

    public static void main(String[] args) {
        Koneksi K = new Koneksi(); // Buat objek koneksi
K.connect();
        try {
            String query = "SELECT id_karyawan FROM data_karyawan ";
            PreparedStatement stat = K.getCon().prepareStatement(query);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                String idKaryawan = rs.getString("id_karyawan");

                // Buat barcode dari id_karyawan
                BitMatrix matrix = new MultiFormatWriter().encode(idKaryawan, BarcodeFormat.CODE_128, 300, 100);
                Path path = new File("barcode_" + idKaryawan + ".png").toPath();
                MatrixToImageWriter.writeToPath(matrix, "PNG", path);

                System.out.println("Barcode untuk " + idKaryawan + " berhasil dibuat.");
            }

            rs.close();
            stat.close();
            K.getCon().close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
