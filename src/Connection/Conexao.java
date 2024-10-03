package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String user = "root";
    private static final String password = "1234";

    private static Connection conn;

    public static Connection getConexao(){

        try{
        if(conn==null){
                conn = DriverManager.getConnection(url, user, password);
                // TODO: handle exception
                return conn;
            } else{
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }
    

}