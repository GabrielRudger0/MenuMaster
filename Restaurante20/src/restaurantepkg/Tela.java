package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import RestauranteAplication.Main;

public class Tela {
    private JButton login;
    public JPanel telaLogin;
    private JTextField receberLogin;
    private JPasswordField senhaLogin;
    public JButton botaoRegistro;
    private JButton botaoLogin;

    public Tela() {


        receberLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

}
