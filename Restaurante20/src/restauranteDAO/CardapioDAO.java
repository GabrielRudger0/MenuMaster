package restauranteDAO;

import com.mysql.jdbc.PreparedStatement;
import restaurante.factory.ConnectionFactory;
import restaurantepkg.Cardapio;
import restaurantepkg.Clientes;
import restaurantepkg.PedidoPkg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardapioDAO {

    public void save(Cardapio cardapio){

        String sql = "INSERT INTO cardapio(nome_prato, preco, categoria, disponibilidade, restricoes, ingredientes, idproduto) VALUES(?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //cria conexao com banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cardapio.getNome_prato());
            pstm.setFloat(2, cardapio.getPreco());
            pstm.setString(3, cardapio.getCategoria());
            pstm.setString(4, cardapio.getDisponibilidade());
            pstm.setString(5, cardapio.getRestricoes());
            pstm.setString(6, cardapio.getIngredientes());
            pstm.setInt(7, cardapio.getIdproduto());
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



    public List<Cardapio> getCardapio() {

        String sql = "SELECT * FROM cardapio";

        List<Cardapio> cardapio5 = new ArrayList<Cardapio>();

        Connection conn = null;
        PreparedStatement pstn = null;
        //pesquisa SELECT

        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstn = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstn.executeQuery();


            while (rset.next()) {
                Cardapio cardapio = new Cardapio();

                //pegar dados
                cardapio.setIdproduto(rset.getInt("idproduto"));
                cardapio.setCategoria(rset.getString("categoria"));
                cardapio.setPreco(rset.getInt("preco"));
                cardapio.setDisponibilidade(rset.getString("disponibilidade"));
                cardapio.setIngredientes(rset.getString("ingredientes"));
                cardapio.setRestricoes(rset.getString("restricoes"));
                cardapio.setNome_prato(rset.getString("nome_prato"));
                cardapio.setCategoria(rset.getString("categoria"));

                cardapio5.add(cardapio);
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


            return cardapio5;


        }

    }