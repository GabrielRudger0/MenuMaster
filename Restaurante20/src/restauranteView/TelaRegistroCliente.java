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

public class TelaRegistroCliente {
    public JPanel telaRegistroCliente;
    public static boolean entrandoComoAdmRegistro = false;
    public static boolean apiValidaCEP = false;
    private JTextField inserirNome, inserirCep, inserirComplemento, inserirNumero, inserirRua,
            inserirCidade, inserirBairro, inserirEstado, inserirEmail, inserirTelefone, insiraSenha;
    private JButton registrarButton, voltarButton;
    private static String enderecoFormatado;


    public TelaRegistroCliente() {

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
                        enderecoFormatado = enderecoapi.getLogradouro() + ", " + inserirNumero.getText() + ", " + enderecoapi.getUf() + ", " + enderecoapi.getBairro() +
                                ", " + enderecoapi.getCidade();
                    } else {
                        enderecoFormatado = enderecoapi.getLogradouro() + ", " + inserirNumero.getText() + ", " + inserirComplemento.getText() + ", " +
                                enderecoapi.getUf() + ", " + enderecoapi.getBairro() + ", " + enderecoapi.getCidade();
                    }
                    cliente.setEnderecoCliente(enderecoFormatado);
                    clienteDAO.save(cliente);
                    JOptionPane.showMessageDialog(null, "Registro Concluído!", "Registro", JOptionPane.INFORMATION_MESSAGE);
                    ExecutaTelas.frameTelaRegistroCliente.dispose();
                    executaTelas.iniciarTelaRegistro();
                }
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExecutaTelas executaTelas = new ExecutaTelas();
                ExecutaTelas.frameTelaRegistroCliente.dispose();
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
        inserirRua.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                enderecoapi.setLogradouro(inserirRua.getText());
            }
        });
        inserirCidade.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                enderecoapi.setBairro(inserirCidade.getText());
            }
        });
        inserirBairro.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                enderecoapi.setCidade(inserirBairro.getText());
            }
        });
        inserirEstado.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                enderecoapi.setUf(inserirEstado.getText());
            }
        });

        inserirNumero.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                inserirNumero.setText(inserirNumero.getText());
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
                        inserirRua.setText(enderecoapi.getLogradouro());
                        inserirCidade.setText(enderecoapi.getBairro());
                        inserirBairro.setText(enderecoapi.getCidade());
                        inserirEstado.setText(enderecoapi.getUf());
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
