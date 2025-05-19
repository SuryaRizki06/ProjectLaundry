import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.sql.*;
import slides.Koneksi;

public class Nota {

    public static void main(String[] args) {
        String idCari = "4"; // Ganti dengan ID karyawan yang ingin ditampilkan
        new Nota().tampilkanNota(idCari);
    }

    public void tampilkanNota(String idKaryawan) {
        Koneksi konek = new Koneksi();
        konek.connect();

        try {
            Connection con = konek.getCon();

            String query = "SELECT * FROM data_karyawan WHERE id_karyawan = ?";
            PreparedStatement stat = con.prepareStatement(query);
            stat.setString(1, idKaryawan);
            ResultSet rs = stat.executeQuery();

            if (rs.next()) {
                String nama = rs.getString("nama_karyawan");
                String jabatan = rs.getString("job_desk");

                JFrame frame = new JFrame("Nota");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panel = new JPanel(new GridBagLayout());
                panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);
                gbc.anchor = GridBagConstraints.WEST;

                // Title
                JLabel labelTitle = new JLabel("NOTA KARYAWAN");
                labelTitle.setFont(new Font("Arial", Font.BOLD, 24));
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                panel.add(labelTitle, gbc);

                gbc.gridwidth = 1;
                gbc.anchor = GridBagConstraints.WEST;

                // Nama label dan value
                gbc.gridy++;
                gbc.gridx = 0;
                panel.add(new JLabel("Nama:"), gbc);
                gbc.gridx = 1;
                panel.add(new JLabel(nama), gbc);

                // ID label dan value
                gbc.gridy++;
                gbc.gridx = 0;
                panel.add(new JLabel("ID:"), gbc);
                gbc.gridx = 1;
                panel.add(new JLabel(idKaryawan), gbc);

                // Jabatan label dan value
                gbc.gridy++;
                gbc.gridx = 0;
                panel.add(new JLabel("Jabatan:"), gbc);
                gbc.gridx = 1;
                panel.add(new JLabel(jabatan), gbc);

                // Barcode Image
                gbc.gridy++;
                gbc.gridx = 0;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.CENTER;
                try {
                    BufferedImage barcodeImage = ImageIO.read(new File("barcode_" + idKaryawan + ".png"));
                    // Optional: resize image agar pas
                    Image scaled = barcodeImage.getScaledInstance(300, 100, Image.SCALE_SMOOTH);
                    JLabel labelBarcode = new JLabel(new ImageIcon(scaled));
                    panel.add(labelBarcode, gbc);
                } catch (Exception e) {
                    panel.add(new JLabel("Barcode tidak ditemukan"), gbc);
                }

                // Terima kasih
                gbc.gridy++;
                JLabel labelThanks = new JLabel("Terima kasih!");
                labelThanks.setFont(new Font("Arial", Font.ITALIC, 16));
                panel.add(labelThanks, gbc);

                frame.add(panel);
                frame.pack(); // ukuran frame menyesuaikan isi
                frame.setLocationRelativeTo(null); // posisi di tengah layar
                frame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Data karyawan dengan ID " + idKaryawan + " tidak ditemukan.");
            }

            rs.close();
            stat.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
