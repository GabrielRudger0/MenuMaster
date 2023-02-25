package RestauranteAplication;

import restauranteDAO.ClienteDAO;
import restaurantepkg.Clientes;
import restaurantepkg.Tela;
import restaurantepkg.TelaCardapio;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Clientes cliente = new Clientes();
        Tela iniciar = new Tela();
        TelaCardapio telaCardapio = new TelaCardapio();


        iniciar.iniciarTela();
        telaCardapio.iniciarTelaCriarCardapio();


    }

}
