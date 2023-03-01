package restaurantepkg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import RestauranteAplication.Main;
import restauranteDAO.AdminDAO;
import restauranteDAO.ClienteDAO;

public class Tela {
    public JPanel telaLogin;
    private String emailDigitadoUsuario;
    private String senhaDigitadoUsuario;
    private int posicaoArrayCliente;
    private boolean aceitaEmail = false;
    private boolean aceitaSenha = false;
    private static boolean eAdmin = false;
    private JTextField receberLogin;
    private JButton botaoLogin;
    private JButton botaoSair;
    private JTextField receberSenha;

    public Tela() {


        receberLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDAO clienteDAO = new ClienteDAO();
                AdminPKG admin = new AdminPKG();
                AdminDAO adminDAO = new AdminDAO();
                admin = adminDAO.getAdminPKG().get(0);

                emailDigitadoUsuario = receberLogin.getText();

                //Bloco de if que verifica se o email digitado pertence a
                // uma conta presente no banco de dados de ADMIN
                if (emailDigitadoUsuario.equals(admin.getUsuarioAdm())) {
                    aceitaEmail = true;
                    eAdmin = true;

                } else {
                    //Verifica se o email digitado pertence a
                    // uma conta presente no banco de dados
                    for (int i = 0; i < clienteDAO.getClientes().size(); i++) {
                        Clientes cliente = new Clientes();
                        cliente = clienteDAO.getClientes().get(i);

                        if (emailDigitadoUsuario.equals(cliente.getEmailCliente())) {
                            aceitaEmail = true;
                            posicaoArrayCliente = i;
                        }
                    }
                }
            }
        });

        receberSenha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Clientes cliente = new Clientes();
                AdminPKG admin = new AdminPKG();
                AdminDAO adminDAO = new AdminDAO();
                admin = adminDAO.getAdminPKG().get(0);

                senhaDigitadoUsuario = receberSenha.getText();

                //Bloco verifica se o email digitado é de uma conta admin
                // depois verifica se a senha digitada é correspondente
                if (eAdmin == true) {
                    System.out.println("senha do banco: " + admin.getSenhaAdm());
                    if (senhaDigitadoUsuario.equals(admin.getSenhaAdm())) {
                        aceitaSenha = true;
                        System.out.println("aceita senha: " + aceitaSenha);
                    }
                } else {
                    //Bloco verifica se a senha digitada é correspondente a conta do banco
                    cliente = clienteDAO.getClientes().get(posicaoArrayCliente);
                    String senhaDoBanco = cliente.getSenha_cliente();

                    if (senhaDigitadoUsuario.equals(senhaDoBanco)) {
                        aceitaSenha = true;
                    }

                }

            }
        });

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ClienteDAO clienteDAO = new ClienteDAO();
                Clientes cliente = new Clientes();

                cliente = clienteDAO.getClientes().get(posicaoArrayCliente);

                //Bloco verifica se ambas as credenciais são validas e libera ou barra o usuário
                if (aceitaEmail == true && aceitaSenha == true) {
                    if (eAdmin == true) {
                        JOptionPane.showMessageDialog(null,"Login Admin efetuado com sucesso!",
                                "Login",JOptionPane.INFORMATION_MESSAGE);

                        eAdmin = false;
                        aceitaEmail = false;
                        aceitaSenha = false;
                        ExecutaTelas.frameTelaLogin.dispose();
                        executaTelas.iniciarTelaAdmin();

                    } else {
                        JOptionPane.showMessageDialog(null,"Login efetuado com sucesso!\nBem-Vindo, " + cliente.getNomeCliente() + ".",
                                "Login",JOptionPane.INFORMATION_MESSAGE);

                        eAdmin = false;
                        aceitaEmail = false;
                        aceitaSenha = false;
                        ExecutaTelas.frameTelaLogin.dispose();
                        executaTelas.iniciarTelaFazerPedido();
                    }


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
