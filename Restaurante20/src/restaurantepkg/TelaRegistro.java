package restaurantepkg;

import br.com.correios.Endereco;
import restauranteDAO.ClienteDAO;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaRegistro {
    public JPanel panel1;
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
        Clientes cliente = new Clientes();


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
                executaTelas.iniciarTelaAdmin();
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
                cliente.setEmailCliente(inserirEmail.getText());
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
        inserirComplemento.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                System.out.println(inserirComplemento.getText());
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                inserirComplemento.setText(inserirComplemento.getText());

            }
        });

        inserirCep.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                cliente.setCepCliente(inserirCep.getText());
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                InserirRua.setText(enderecoapi.getLogradouro());
                inserirBairro.setText(enderecoapi.getBairro());
                InserirCidade.setText(enderecoapi.getCidade());
                InserirEstado.setText(enderecoapi.getUf());
            }
        });
    }
    public boolean registroECorreto(Clientes cliente) {

        String textoTela = "Informações não preenchidas!\n";
        boolean verificaRegistro = true;

        if (cliente.getNomeCliente() == null) {
            textoTela += "Nome do Cliente;\n";
            verificaRegistro = false;
        }
        if (cliente.getCepCliente() == null) {
            textoTela += "CEP do Cliente;\n";
            verificaRegistro = false;
        }
        if (cliente.getEmailCliente() == null) {
            textoTela += "Email do Cliente;\n";
            verificaRegistro = false;
        }
        if (cliente.getTelefoneCliente() == null) {
            textoTela += "Telefone do Cliente;\n";
            verificaRegistro = false;
        }
        if (verificaRegistro == false) {
            JOptionPane.showMessageDialog(null,textoTela,"Registro",JOptionPane.ERROR_MESSAGE);
        }
        return verificaRegistro;
    }
}
