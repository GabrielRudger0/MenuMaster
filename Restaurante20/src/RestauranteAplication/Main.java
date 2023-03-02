package RestauranteAplication;

import restaurantepkg.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ExecutaTelas executaTelas = new ExecutaTelas();

        System.out.println(br.com.correios.ClienteWs.getEnderecoPorCep("89050570"));
       // System.out.println(br.com.correios.ClienteWs.getMapPorCep("70002900"));


        //executaTelas.iniciarTelaLogin();
        //executaTelas.iniciarTelaFazerPedido();
        //executaTelas.iniciarTelaAdmin();
    }
}
