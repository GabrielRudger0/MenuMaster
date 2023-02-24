package RestauranteAplication;

import restauranteDAO.ClienteDAO;
import restaurantepkg.Clientes;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        Clientes cliente = new Clientes();
        cliente.setNomeCliente("Murilo Cordova");
        cliente.setCepCliente("89050570");
        cliente.setEmailCliente("muriloocordova@gmail.com");

        clienteDAO.save(cliente);



    }
}
