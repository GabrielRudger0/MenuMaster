package restaurante.factory;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class    ConnectionFactory {

    //nome do usuario
    private static final String USERNAME = "root";
    //senha bdd
    private static final String PASSWORD = "";

    //url de conexao

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/restaurantebanco";

    /*
    *Conexao com banco de dados
     */

    public static Connection createConnectionToMySQL() throws ClassNotFoundException, SQLException {
        //faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.jdbc.Driver");
        //cria a conexao com banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

        return connection;

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //recuperar uma conexao com banco de dados
        Connection con  = createConnectionToMySQL();
        //testar se a conexao e nula]

        if (con!=null){
            System.out.println("Conexao obtida com sucesso");
            con.close();
        }
    }
}
