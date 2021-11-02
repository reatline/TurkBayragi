import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {
    private JTextField yukseklik;
    private JTextField uzunluk;
    private JButton olusturButton;
    private JPanel jpanel;
    static JFrame loginJFrame;

    public Login() {
        olusturButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jframe = new JFrame("Türk Bayrağı");
                TurkBayragi turkBayragi = new TurkBayragi();
                if (Double.parseDouble(uzunluk.getText()) / Double.parseDouble(yukseklik.getText()) == 1.5){
                    loginJFrame.setVisible(false);
                    jframe.setSize(Integer.parseInt(uzunluk.getText()),Integer.parseInt(yukseklik.getText()));
                    jframe.setVisible(true);
                    jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    jframe.add(turkBayragi);

                }
                else
                    JOptionPane.showMessageDialog(null, "Bayrak Yüksekliği bayrak genişliğinin 1.5 katı olmalıdır.");

            }
        });
    }

    public static void main(String[] args) {
       Login login = new Login();
        loginJFrame = new JFrame("Bayrak Ölçüsü Belirleme Ekranı");
        loginJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginJFrame.setVisible(true);
        loginJFrame.setSize(800,500);
        loginJFrame.add(login.jpanel);

    }
}
