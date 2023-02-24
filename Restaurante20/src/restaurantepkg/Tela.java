package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import restauranteDAO.ClienteDAO;

public class Tela {
    private JButton login;
    private JPanel telaLogin;
    private JTextField receberLogin;
    private JPasswordField senhaLogin;
    private JButton botaoRegistro;
    private JButton botaoLogin;

    public String telefone;

    public JFrame frame = new JFrame("Login");


    public Tela() {



        receberLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 telefone = receberLogin.getText();
            }
        });
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        botaoRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRegistro telaRegistro = new TelaRegistro();
                telaRegistro.iniciarTelaRegistro();
            }
        });

    }
public void iniciarTela() {

    frame.setContentPane(new Tela().telaLogin);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);




}


}
