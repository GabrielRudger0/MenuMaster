package RestauranteAplication;

import br.com.correios.ClienteWs;
import br.com.correios.Endereco;
import restaurantepkg.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ExecutaTelas executaTelas = new ExecutaTelas();

        //executaTelas.iniciarTelaLogin();

        //executaTelas.iniciarTelaAvaliacoes();

        //executaTelas.iniciarTelaFazerPedido();

        executaTelas.iniciarTelaAdmin();

        //executaTelas.iniciarTelaRegistro();

    }
}
