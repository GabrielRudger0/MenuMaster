package RestauranteAplication;

import restauranteDAO.ClienteDAO;
import restaurantepkg.*;

import javax.swing.*;

public class Main {

    public static JFrame mainTelaLogin = new JFrame("Login");

    public static void main(String[] args) {

        ClienteDAO clienteDAO = new ClienteDAO();
        Clientes cliente = new Clientes();
        Tela telaLogin = new Tela();
        TelaFazerPedido fazerPedido = new TelaFazerPedido();
        TelaMenuAdmin menuAdmin = new TelaMenuAdmin();

        //menuAdmin.iniciarTelaAdmin();
        //fazerPedido.iniciarTelaFazerPedido();

        inicarTelaLogin();
        //iniciarTelaRegistro();

    }
   public static void inicarTelaLogin() {
        mainTelaLogin.setContentPane(new Tela().telaLogin);
        mainTelaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainTelaLogin.pack();
        mainTelaLogin.setVisible(true);

    }


}
