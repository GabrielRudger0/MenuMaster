package RestauranteAplication;

import restaurante.factory.ViaCEP;
import restauranteDAO.ClienteDAO;
import restaurantepkg.*;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static JFrame mainTelaLogin = new JFrame("Login");



    public static void main(String[] args) throws IOException {

        ViaCEP viacep = new ViaCEP("89050570");
        viacep.buscar();
        System.out.println(viacep.getLogradouro()); // imprime "Praça da Sé"
        System.out.println(viacep.getBairro()); // imprime "Sé"
        System.out.println(viacep.getLocalidade()); // imprime "São Paulo"
        System.out.println(viacep.getUf()); // imprime "SP"


        //  ClienteDAO clienteDAO = new ClienteDAO();
       // Clientes cliente = new Clientes();
       // Tela telaLogin = new Tela();
       // TelaFazerPedido fazerPedido = new TelaFazerPedido();
        //TelaMenuAdmin menuAdmin = new TelaMenuAdmin();
        TelaAvaliacao telaAvaliacao = new TelaAvaliacao();

        telaAvaliacao.iniciarTelaAvaliacoes();

        //menuAdmin.iniciarTelaAdmin();
        //fazerPedido.iniciarTelaFazerPedido();

        //inicarTelaLogin();
        //iniciarTelaRegistro();

    }
   public static void inicarTelaLogin() {
        mainTelaLogin.setContentPane(new Tela().telaLogin);
        mainTelaLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainTelaLogin.pack();
        mainTelaLogin.setVisible(true);

    }


}
