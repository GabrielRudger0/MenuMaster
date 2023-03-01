package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import RestauranteAplication.Main;
import restauranteDAO.ClienteDAO;

public class Tela {
    public JPanel telaLogin;
    private String emailDigitadoUsuario;
    private String senhaDigitadoUsuario;
    private int posicaoArrayCliente;
    private boolean aceitaEmail = false;
    private boolean aceitaSenha = false;
    private JButton login;
    private JTextField receberLogin;
    private JPasswordField senhaLogin;
    public JButton botaoRegistro;
    private JButton botaoLogin;
    private JButton botaoSair;

    public Tela() {

        receberLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDAO clienteDAO = new ClienteDAO();
                emailDigitadoUsuario = receberLogin.getText();

                for (int i = 0; i < clienteDAO.getClientes().size(); i++) {
                    Clientes cliente = new Clientes();
                    cliente = clienteDAO.getClientes().get(i);
                    if (emailDigitadoUsuario.equals(cliente.getEmailCliente())) {
                        aceitaEmail = true;
                        posicaoArrayCliente = i;
                    }
                }

            }
        });

        senhaLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Clientes cliente = new Clientes();
                System.out.println(posicaoArrayCliente);
                cliente = clienteDAO.getClientes().get(posicaoArrayCliente);
                senhaDigitadoUsuario = senhaLogin.getText();
                String senhaDoBanco = cliente.getSenha_cliente();
                System.out.println("ee: "+ senhaDoBanco);
                if (senhaDigitadoUsuario.equals(senhaDoBanco)) {
                    aceitaSenha = true;
                    System.out.println(aceitaSenha);
                }
            }
        });

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Clientes cliente = new Clientes();
                cliente = clienteDAO.getClientes().get(posicaoArrayCliente);

                if (aceitaEmail == true && aceitaSenha == true) {
                    JOptionPane.showMessageDialog(null,"Login efetuado com sucesso!\nBem-Vindo, " + cliente.getNomeCliente() + ".",
                            "Login",JOptionPane.INFORMATION_MESSAGE);

                    ExecutaTelas executaTelas = new ExecutaTelas();
                    ExecutaTelas.frameTelaLogin.dispose();
                    executaTelas.iniciarTelaFazerPedido();

                } else {
                    JOptionPane.showMessageDialog(null,"Erro no login: Verifique as credenciais digitadas.",
                            "Login",JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
