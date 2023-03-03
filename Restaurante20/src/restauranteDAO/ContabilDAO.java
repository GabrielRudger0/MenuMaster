package restauranteDAO;

import com.mysql.jdbc.PreparedStatement;
import restaurante.factory.ConnectionFactory;
import restaurantepkg.Cardapio;
import restaurantepkg.ContabilPKG;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContabilDAO {

    public void save(ContabilPKG contabilPKG) {

        String sql = "INSERT INTO data, descricao, receitas, despesas, saldo) VALUES(?,?,?,?,?)";

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

    public List<ContabilPKG> getRelatorio() {

        //pesquisa SELECT
        String sql = "SELECT * FROM contabil";

        List<ContabilPKG> Contabil = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstn = null;
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstn = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstn.executeQuery();


            while (rset.next()) {

                ContabilPKG contabil = new ContabilPKG();

                //pegar dados

                contabil.setData(rset.getDate("data"));
                contabil.setDescricao(rset.getString("descricao"));
                contabil.setReceitas(rset.getDouble("receitas"));
                contabil.setDespesas(rset.getDouble("despesas"));
                contabil.setSaldo(rset.getDouble("saldo"));

                Contabil.add(contabil);

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {


                if (rset != null) {
                    rset.close();
                }
                if (pstn != null) {
                    pstn.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return Contabil;

    }

}
