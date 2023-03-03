package restaurantepkg;

import br.com.correios.Endereco;
import restauranteDAO.ClienteDAO;

import javax.swing.*;
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
    private JTextField textField1;
    private JTextField inserirBairro;

    public TelaRegistro() {


        ClienteDAO clienteDAO = new ClienteDAO();
        Clientes cliente = new Clientes();

        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (registroECorreto(cliente) != false) {
                    clienteDAO.save(cliente);
                    JOptionPane.showMessageDialog(null, "Registro Concluído!", "Registro", JOptionPane.INFORMATION_MESSAGE);

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
                System.out.println(inserirNome.getText());
            }
        });
        inserirCep.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                cliente.setCepCliente(inserirCep.getText());
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
            public void focusGained(FocusEvent e) {

                super.focusGained(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                InserirRua.setText(enderecoapi.getLogradouro());

            }
        });
        InserirEstado.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                InserirEstado.setText(enderecoapi.getUf());

            }
        });


        InserirCidade.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {

                super.focusGained(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                InserirCidade.setText(enderecoapi.getCidade());
            }
        });


        inserirBairro.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep(inserirCep.getText());
                inserirBairro.setText(enderecoapi.getBairro());

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
