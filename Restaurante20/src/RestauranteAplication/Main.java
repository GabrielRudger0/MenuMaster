package RestauranteAplication;

import restauranteDAO.ClienteDAO;
import restaurantepkg.Clientes;
import restaurantepkg.FuncoesCliente;
import restaurantepkg.Tela;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Clientes cliente = new Clientes();
        FuncoesCliente funcoesCliente = new FuncoesCliente();
        Tela iniciar = new Tela();

        //funcoesCliente.cadastrarCliente(clienteDAO, cliente);
        iniciar.iniciarTela();




    }

}
