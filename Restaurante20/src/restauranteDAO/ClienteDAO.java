package restauranteDAO;

import com.mysql.jdbc.PreparedStatement;
import restaurante.factory.ConnectionFactory;
import restaurantepkg.Clientes;

import java.sql.Connection;
import java.sql.SQLException;

public class ClienteDAO {

    public void save(Clientes clientes){

        String sql = "INSERT INTO cadastro_cliente(nome_cliente,cep_cliente,email_cliente,tel_cliente, senha_cliente) VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, clientes.getNomeCliente());
            pstm.setString(2, clientes.getCepCliente());
            pstm.setString(3, clientes.getEmailCliente());
            pstm.setString(4, clientes.getTelefoneCliente());
            pstm.setString(5, clientes.getSenha_cliente());

            //executa a query

            pstm.execute();

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //fechar a conexao

            try {
                if (pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
        }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
