package RestauranteAplication;

import restauranteDAO.CardapioDAO;
import restauranteDAO.ClienteDAO;
import restaurantepkg.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Clientes cliente = new Clientes();
        Tela TelaLogin = new Tela();
        TelaFazerPedido fazerPedido = new TelaFazerPedido();
        TelaMenuAdmin menuAdmin = new TelaMenuAdmin();

        menuAdmin.iniciarTelaAdmin();
        //TelaLogin.iniciarTela();
        //fazerPedido.iniciarTelaFazerPedido();

    }

}
