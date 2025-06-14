import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.math.BigInteger;

public class WheatProblemGUI extends JFrame {
    public WheatProblemGUI() {
        setTitle("Satranç Tahtası Buğday Problemi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JButton button = new JButton("Hesapla");
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);

        button.addActionListener(e -> {
            String[] columns = {"Kare", "Buğday Tanesi"};
            Object[][] data = new Object[64][2];
            BigInteger grain = BigInteger.ONE;
            BigInteger total = BigInteger.ZERO;

            for (int i = 0; i < 64; i++) {
                data[i][0] = i + 1;
                data[i][1] = grain.toString();
                total = total.add(grain);
                grain = grain.multiply(BigInteger.valueOf(2));
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            table.setModel(model);

            // Toplamı tablo altına ekle
            JOptionPane.showMessageDialog(this, "Toplam Buğday Tanesi: " + total.toString());
        });

        setLayout(new BorderLayout());
        add(button, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WheatProblemGUI().setVisible(true);
        });
    }
}