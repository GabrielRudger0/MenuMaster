package restauranteView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import restauranteDAO.AdminDAO;
import restauranteDAO.ClienteDAO;
import restauranteDAO.PedidoDAO;
import restaurantePKG.AdminPKG;
import restaurantePKG.ClientesPKG;
import restauranteAplication.ExecutaTelas;

public class TelaLogin {
    public JPanel telaLogin;
    private String emailDigitadoUsuario, senhaDigitadoUsuario;

    //Index do cliente é usado para validar a senha após o email der como TRUE
    private int indexCliente;

    private boolean aceitaEmail = false, aceitaSenha = false;
    private static boolean eAdmin = false;
    private JTextField receberLogin, receberSenha;
    private JButton botaoLogin, botaoSair, cadastroButton;


    public TelaLogin() {
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ClienteDAO clienteDAO = new ClienteDAO();
                ClientesPKG cliente = new ClientesPKG();

                cliente = clienteDAO.getClientes().get(indexCliente);

                //Bloco verifica se ambas as credenciais são validas e libera ou barra o usuário
                if (aceitaEmail == true && aceitaSenha == true) {
                    if (eAdmin == true) {
                        eAdmin = false;
                        aceitaEmail = false;
                        aceitaSenha = false;

                        ExecutaTelas.frameTelaLogin.dispose();
                        executaTelas.iniciarTelaAdmin();

                    } else {
                        eAdmin = false;
                        aceitaEmail = false;
                        aceitaSenha = false;

                        PedidoDAO.idClienteAtual = cliente.getIdCliente();
                        TelaCardapio.nomeUsuarioAtual = cliente.getNomeCliente();
                        ExecutaTelas.frameTelaLogin.dispose();
                        executaTelas.iniciarTelaFazerPedido();
                    }


                } else {
                    JOptionPane.showMessageDialog(null,"Erro no login: Verifique as credenciais digitadas.",
                            "Erro no Login",JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        receberLogin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

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
                        ClientesPKG cliente = new ClientesPKG();
                        cliente = clienteDAO.getClientes().get(i);

                        if (emailDigitadoUsuario.equals(cliente.getEmailCliente())) {
                            aceitaEmail = true;
                            indexCliente = i;
                        }
                    }
                }
            }
        });
        receberSenha.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);

                ClienteDAO clienteDAO = new ClienteDAO();
                ClientesPKG cliente = new ClientesPKG();
                AdminPKG admin = new AdminPKG();
                AdminDAO adminDAO = new AdminDAO();
                admin = adminDAO.getAdminPKG().get(0);

                senhaDigitadoUsuario = receberSenha.getText();

                //Bloco verifica se o email digitado é de uma conta admin
                // depois verifica se a senha digitada é correspondente
                if (eAdmin == true) {
                    if (senhaDigitadoUsuario.equals(admin.getSenhaAdm())) {
                        aceitaSenha = true;
                    }
                } else {
                    //Bloco verifica se a senha digitada é correspondente a conta do banco
                    cliente = clienteDAO.getClientes().get(indexCliente);
                    String senhaDoBanco = cliente.getSenha_cliente();

                    if (senhaDigitadoUsuario.equals(senhaDoBanco)) {
                        aceitaSenha = true;
                    }

                }
            }
        });
        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas.frameTelaLogin.dispose();
                ExecutaTelas executaTelas = new ExecutaTelas();
                executaTelas.iniciarTelaRegistro();
            }
        });
    }

}
