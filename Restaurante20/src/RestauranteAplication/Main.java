package RestauranteAplication;

import restaurantepkg.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ExecutaTelas executaTelas = new ExecutaTelas();
        CriaDespesas aplicarDespesas = new CriaDespesas();

        //aplicarDespesas.criaDespesas();

        executaTelas.iniciarTelaLogin();

        //executaTelas.iniciarTelaAvaliacoes();

        //executaTelas.iniciarTelaFazerPedido();

        //executaTelas.iniciarTelaAdmin();

        //executaTelas.iniciarTelaRegistro();

    }
}
