package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

import restauranteDAO.ClienteDAO;

public class Tela {
    private JButton login;
    private JPanel telaLogin;
    private JTextField receberLogin;
    private JTextField textField1;

    public Tela() {


        receberLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = receberLogin.getText();
                ClienteDAO clienteDAO = new ClienteDAO();
                Clientes cliente = new Clientes();

                cliente.setNomeCliente(a);
                clienteDAO.save(cliente);
            }
        });
    }
public void iniciarTela() {
    JFrame frame = new JFrame("Login");
    frame.setContentPane(new Tela().telaLogin);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}
}
