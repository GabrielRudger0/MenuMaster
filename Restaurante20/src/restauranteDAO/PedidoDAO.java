package restauranteDAO;

import com.mysql.jdbc.PreparedStatement;
import restaurante.factory.ConnectionFactory;
import restaurantepkg.Clientes;
import restaurantepkg.PedidoPkg;

import java.sql.Connection;
import java.util.List;

public class PedidoDAO {
    public static String idClienteAtual;

    public void save(PedidoPkg pedidoPkg){

        String sql = "INSERT INTO pedidos(idcliente,itenspedidos,observacao,quantidade) VALUES(?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, idClienteAtual);
            pstm.setString(2, pedidoPkg.getItenspedidos());
            pstm.setString(3, pedidoPkg.getObservacao());
            pstm.setString(4, pedidoPkg.getQuantidade());

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
