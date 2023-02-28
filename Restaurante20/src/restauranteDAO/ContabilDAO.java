package restauranteDAO;

import com.mysql.jdbc.PreparedStatement;
import restaurante.factory.ConnectionFactory;
import restaurantepkg.ContabilPKG;

import java.sql.Connection;

public class ContabilDAO {

    public void save(ContabilPKG contabilPKG) {

        String sql = "INSERT INTO contabildata, descricao, receitas, despesas, saldo) VALUES(?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setDate(1, contabilPKG.getData());
            pstm.setString(2, contabilPKG.getDescricao());
            pstm.setDouble(3, contabilPKG.getReceitas());
            pstm.setDouble(4, contabilPKG.getDespesas());
            pstm.setDouble(5, contabilPKG.getSaldo());

            //executa a query

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fechar a conexao

            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
