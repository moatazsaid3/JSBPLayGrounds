
import java.sql.*;

public class PostgresDataBase{
    private final static String url = "jdbc:postgresql://localhost/playgrounds";
    private final static String user = "postgres";
    private final static String password = "#Postgres@MS123";
    void PostgresDataBase(){

    }

    static public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    static ResultSet selectAll(String tableName){
        final String selectFromTable = "select * from " + tableName + ";";
        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectFromTable)
        ){
            return  rs;
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    static ResultSet selectByID(String tableName, int id){
        final String selectFromTableByID = "select * from +"+tableName+" where id = "+ id +";";


        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectFromTableByID)
        ){
            return  rs;
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}



