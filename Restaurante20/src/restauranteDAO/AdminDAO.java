package restauranteDAO;

import com.mysql.jdbc.PreparedStatement;
import restaurante.factory.ConnectionFactory;
import restaurantePKG.AdminPKG;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public List<AdminPKG> getAdminPKG() {

        String sql = "SELECT * FROM vrp_admin";

        List<AdminPKG> adminInfos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstn = null;
        //pesquisa SELECT
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySQL();

            pstn = (PreparedStatement) conn.prepareStatement(sql);

            rset = pstn.executeQuery();


            while (rset.next()) {
                AdminPKG adminpega = new AdminPKG();

                //pegar dados
                adminpega.setUsuarioAdm(rset.getString("usuario"));
                adminpega.setSenhaAdm(rset.getString("senha"));


                adminInfos.add(adminpega);
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


        return adminInfos;


    }
}
