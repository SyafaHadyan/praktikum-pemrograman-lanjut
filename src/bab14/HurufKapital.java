import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HurufKapital extends JFrame {
    private JTextField inputTextField;
    private JTextField outputTextField;
    private JButton convertButton;
    private JPanel mainPanel;
    private FlowLayout layout;

    public HurufKapital() {
        setTitle("Kapitalisasi Teks");
        setSize(320, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        layout = new FlowLayout(FlowLayout.CENTER);
        mainPanel = new JPanel(layout);
        inputTextField = new JTextField("masukkan teks", 24);
        outputTextField = new JTextField(24);
        convertButton = new JButton("Ubah Menjadi Huruf Kapital");

        outputTextField.setEditable(false);
        layout.setVgap(10);
        layout.setHgap(5);

        mainPanel.add(inputTextField);
        mainPanel.add(outputTextField);
        mainPanel.add(convertButton);

        add(mainPanel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputTextField.getText();
                String uppercaseText = inputText.toUpperCase();
                outputTextField.setText(uppercaseText);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HurufKapital().setVisible(true);
            }
        });
    }
}
