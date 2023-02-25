package restauranteDAO;

import com.mysql.jdbc.PreparedStatement;
import restaurante.factory.ConnectionFactory;
import restaurantepkg.Clientes;
import restaurantepkg.PedidoPkg;

import java.sql.Connection;

public class PedidoDAO {

    public void save(PedidoPkg pedidoPkg){

        String sql = "INSERT INTO pedidos(itenspedidos,observacao,quantidade) VALUES(?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, pedidoPkg.getItenspedidos());
            pstm.setString(2, pedidoPkg.getObservacao());
            pstm.setString(3, pedidoPkg.getQuantidade());

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
