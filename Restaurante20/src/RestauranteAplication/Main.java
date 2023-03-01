package RestauranteAplication;

import restaurante.factory.ViaCEP;
import restauranteDAO.ClienteDAO;
import restaurantepkg.*;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ExecutaTelas executaTelas = new ExecutaTelas();


        ViaCEP viacep = new ViaCEP("89050570");
        viacep.buscar();
        System.out.println(viacep.getLogradouro()); // imprime "Praça da Sé"
        System.out.println(viacep.getBairro()); // imprime "Sé"
        System.out.println(viacep.getLocalidade()); // imprime "São Paulo"
        System.out.println(viacep.getUf()); // imprime "SP"

        executaTelas.iniciarTelaLogin();
    }
}
