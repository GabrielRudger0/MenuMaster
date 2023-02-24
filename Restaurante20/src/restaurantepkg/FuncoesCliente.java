package restaurantepkg;

import restauranteDAO.ClienteDAO;

import javax.swing.*;

public class FuncoesCliente {

    public void cadastrarCliente(ClienteDAO clienteDAO, Clientes cliente) {

        String nome = JOptionPane.showInputDialog("Nome: ");
        String cep = JOptionPane.showInputDialog("CEP: ");
        String email = JOptionPane.showInputDialog("Email: ");

        cliente.setNomeCliente(nome);
        cliente.setCepCliente(cep);
        cliente.setEmailCliente(email);

        clienteDAO.save(cliente);

    }
}
