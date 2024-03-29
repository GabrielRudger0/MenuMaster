package restauranteDAO;

import com.mysql.jdbc.PreparedStatement;
import restaurante.factory.ConnectionFactory;
import restaurantePKG.PedidoPKG;

import java.sql.Connection;

public class PedidoDAO {
    //Pega o Id do cliente logado para registrar nos pedidos;
    public static String idClienteAtual;
    //
    public void save(PedidoPKG pedidoPkg){

        String sql = "INSERT INTO pedidos(idcliente,itenspedidos,observacao,quantidade,avaliacao5star,avaliacaoobs) VALUES(?,?,?,?,?,?)";

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
            pstm.setString(5,pedidoPkg.getAvaliacao5Star());
            pstm.setString(6,pedidoPkg.getAvaliacaoFinal());

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
