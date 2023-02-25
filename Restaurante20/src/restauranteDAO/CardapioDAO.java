package restauranteDAO;

import com.mysql.jdbc.PreparedStatement;
import restaurante.factory.ConnectionFactory;
import restaurantepkg.Cardapio;
import restaurantepkg.Clientes;

import java.sql.Connection;
import java.sql.SQLException;
public class CardapioDAO {

    public void save(Cardapio cardapio){

        String sql = "INSERT INTO cardapio(nome_prato, preco, categoria, disponibilidade, restricoes, ingredientes) VALUES(?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cardapio.getNome_prato());
            pstm.setFloat(2, cardapio.getPreco());
            pstm.setString(3, cardapio.getCategoria());
            pstm.setBoolean(4, cardapio.isDisponibilidade());
            pstm.setString(5, cardapio.getRestricoes());
            pstm.setString(6, cardapio.getIngredientes());

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
