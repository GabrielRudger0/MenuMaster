package RestauranteAplication;

import br.com.correios.ClienteWs;
import br.com.correios.Endereco;
import restaurantepkg.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Endereco enderecoapi = br.com.correios.ClienteWs.getEnderecoPorCep("89055470");
        ExecutaTelas executaTelas = new ExecutaTelas();
        System.out.println(br.com.correios.ClienteWs.getEnderecoPorCep("89055470"));
       // System.out.println(br.com.correios.ClienteWs.getMapPorCep("70002900"));

        System.out.println(enderecoapi.getCidade());
        System.out.println(enderecoapi.getLogradouro());

        System.out.println("AHHFADHFADHFIADHFIPADHFIOPADHFIOPDHOPFAD");

        //executaTelas.iniciarTelaLogin();

        //executaTelas.iniciarTelaAvaliacoes();

        //executaTelas.iniciarTelaFazerPedido();

        executaTelas.iniciarTelaAdmin();

        //executaTelas.iniciarTelaRegistro();

        System.out.println("forcecoomit");
    }
}
