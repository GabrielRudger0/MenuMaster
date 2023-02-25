package RestauranteAplication;

import restauranteDAO.CardapioDAO;
import restauranteDAO.ClienteDAO;
import restaurantepkg.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Clientes cliente = new Clientes();
        Tela iniciar = new Tela();
        TelaCardapio telaCardapio = new TelaCardapio();
        TelaFazerPedido fazerPedido = new TelaFazerPedido();


        //iniciar.iniciarTela();
        //telaCardapio.iniciarTelaCriarCardapio();
        fazerPedido.iniciarTelaFazerPedido();

    }

}
