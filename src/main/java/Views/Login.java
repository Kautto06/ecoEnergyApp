package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import com.opencsv.exceptions.CsvValidationException;

import com.opencsv.exceptions.CsvValidationException;
import org.example.Main;
import org.example.User;

public class Login extends JDialog{
    private JPanel panelMain;
    private JTextField tfRut;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JLabel lbError;
    private JButton btnExit;

    public Login(JFrame parent){
        super(parent);
        setContentPane(panelMain);
        setMinimumSize(new Dimension(800,600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rut = tfRut.getText();
                String password = String.valueOf(pfPassword.getPassword());
                try {
                    if(User.VerificarUsuario("src/test/text/Users.csv",rut,password)){
                        System.out.println("Usuario verificado");
                        System.out.println("Entrando al sistema...");
                        dispose();
                        Main.sistema();
                    }
                    else{
                        System.out.println("Error de autenticacion");
                        lbError.setVisible(true);
                    }
                } catch (CsvValidationException | ParseException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        Login login = new Login(null);
    }


}
