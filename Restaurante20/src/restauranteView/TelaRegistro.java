package restauranteView;

import br.com.correios.Endereco;
import restauranteDAO.ClienteDAO;
import restaurantePKG.ClientesPKG;
import restauranteAplication.ExecutaTelas;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaRegistro {
    public JPanel panel1;

    public static boolean entrandoComoAdmRegistro = false;

    public static boolean apiValidaCEP = false;

    private JTextField inserirNome;

    private JTextField inserirCep;

    private JTextField inserirEmail;

    private JButton registrarButton;

    private JButton voltarButton;

    private JTextField inserirTelefone;

    private JTextField insiraSenha;

    private JTextField InserirRua;

    private JTextField InserirNumero;

    private JTextField InserirEstado;

    private JTextField InserirCidade;

    private JTextField inserirComplemento;

    private JTextField inserirBairro;

    private static String enderecoFormatado;


    public TelaRegistro() {

        ExecutaTelas executaTelas = new ExecutaTelas();
        ClienteDAO clienteDAO = new ClienteDAO();
        ClientesPKG cliente = new ClientesPKG();

        cliente.setNomeCliente("");
        cliente.setEmailCliente("");
        cliente.setTelefoneCliente("");
        cliente.setSenha_cliente("");


        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (registroECorreto(cliente) != false) {
                    Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());

                    if (inserirComplemento.getText().equals("")) {
                        enderecoFormatado = enderecoapi.getLogradouro() + ", " + InserirNumero.getText() + ", " + enderecoapi.getUf() + ", " + enderecoapi.getBairro() +
                                ", " + enderecoapi.getCidade();
                    } else {
                        enderecoFormatado = enderecoapi.getLogradouro() + ", " + InserirNumero.getText() + ", " + inserirComplemento.getText() + ", " +
                                enderecoapi.getUf() + ", " + enderecoapi.getBairro() + ", " + enderecoapi.getCidade();
                    }
                    cliente.setEnderecoCliente(enderecoFormatado);
                    clienteDAO.save(cliente);
                    JOptionPane.showMessageDialog(null, "Registro Concluído!", "Registro", JOptionPane.INFORMATION_MESSAGE);
                    ExecutaTelas.frameTelaRegistro.dispose();
                    executaTelas.iniciarTelaRegistro();
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ExecutaTelas.frameTelaRegistro.dispose();
                if (entrandoComoAdmRegistro == false) {
                    executaTelas.iniciarTelaLogin();
                } else {
                    entrandoComoAdmRegistro = false;
                    executaTelas.iniciarTelaAdmin();
                }

            }
        });

        inserirNome.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                cliente.setNomeCliente(inserirNome.getText());

            }
        });

        inserirEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                System.out.println(clienteDAO.getClientes().size());
                for (int i = 0; i <= clienteDAO.getClientes().size() - 1; i++) {
                    if (clienteDAO.getClientes().get(i).getEmailCliente().equals(inserirEmail.getText())) {
                        JOptionPane.showMessageDialog(null,"Email já cadastrado no sistema!","Registro",JOptionPane.WARNING_MESSAGE);
                        inserirEmail.setText("");
                    } else {
                        cliente.setEmailCliente(inserirEmail.getText());
                    }
                }

            }
        });
        inserirTelefone.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                cliente.setTelefoneCliente(inserirTelefone.getText());
            }
        });
        insiraSenha.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                cliente.setSenha_cliente(insiraSenha.getText());
            }
        });
        InserirRua.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                enderecoapi.setLogradouro(InserirRua.getText());
            }
        });
        inserirBairro.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                enderecoapi.setBairro(inserirBairro.getText());
            }
        });
        InserirCidade.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                enderecoapi.setCidade(InserirCidade.getText());
            }
        });
        InserirEstado.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                enderecoapi.setUf(InserirEstado.getText());
            }
        });

        InserirNumero.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                InserirNumero.setText(InserirNumero.getText());
            }
        });
        inserirComplemento.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                inserirComplemento.setText(inserirComplemento.getText());

            }
        });

        inserirCep.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                    cliente.setCepCliente(inserirCep.getText());
                    apiValidaCEP = false;
                    if (inserirCep.getText().length() == 8) {
                        try {
                            Thread.sleep(100); // pausa a thread por 1 segundo
                        } catch (InterruptedException a) {
                            // lida com a exceção, se ocorrer
                            a.printStackTrace();
                        }

                        Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                        InserirRua.setText(enderecoapi.getLogradouro());
                        inserirBairro.setText(enderecoapi.getBairro());
                        InserirCidade.setText(enderecoapi.getCidade());
                        InserirEstado.setText(enderecoapi.getUf());
                        apiValidaCEP = true;
                    }
            }
        });
    }
    private boolean registroECorreto(ClientesPKG cliente) {

        String textoTela = "Informações não preenchidas!\n";
        boolean verificaRegistro = true;

        if (cliente.getNomeCliente().equals("")) {
            textoTela += "Nome do Cliente;\n";
            verificaRegistro = false;
        }
        if (cliente.getCepCliente() == null || apiValidaCEP == false) {
            textoTela += "CEP do Cliente Inválido;\n";
            verificaRegistro = false;
        }
        if (cliente.getEmailCliente().equals("")) {
            textoTela += "Email do Cliente;\n";
            verificaRegistro = false;
        }
        if (cliente.getTelefoneCliente().equals("") || invalidaTelefone(cliente.getTelefoneCliente()) == true) {
            textoTela += "Telefone do Cliente;\n";
            verificaRegistro = false;
        }
        if (cliente.getSenha_cliente().equals("")) {
            textoTela += "Senha da Conta;\n";
            verificaRegistro = false;
        }
        if (verificaRegistro == false) {
            JOptionPane.showMessageDialog(null,textoTela,"Registro",JOptionPane.ERROR_MESSAGE);
        }
        return verificaRegistro;
    }
    private boolean invalidaTelefone(String telefoneDigitado) {
        String telefone = telefoneDigitado;
        boolean invalida = false;

        if (telefone.length() < 10 || telefone.length() > 11) {
            invalida = true;
        }
        for (int i = 0; i < telefone.length(); i++) {
            if (Character.isLetter(telefone.charAt(i))) {
                invalida = true;
                break;
            }
        }
        return invalida;
    }
}
