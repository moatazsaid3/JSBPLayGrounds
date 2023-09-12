package DAL;

import java.sql.*;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.UUID;

import models.Instructor;

public abstract class PostgresDataBase{
    private final static String url = "jdbc:postgresql://localhost/center_management";
    private final static String user = "postgres";
    private final static String password = "#Postgres@MS123";


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

    static <T,d> T selectByID(String tableName, d id) {
        String selectFromTableByID ="";
        if(id.getClass().getSimpleName().equals("String")){
              selectFromTableByID = "select * from " + tableName + " where id = '" + id.toString() + "';";

        }else{
              selectFromTableByID = "select * from " + tableName + " where id = " + id.toString() + ";";
        }
        System.out.println(id.getClass());

        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectFromTableByID)
        ){
            Class c = Class.forName(tableName);
            Constructor constructor = c.getConstructor(ResultSet.class);

            return  (T)constructor.newInstance(rs);
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    static <T> ArrayList<T> selectAll(String tableName) throws ClassNotFoundException, NoSuchMethodException {

        final String selectAllFromTable = "select * from " + tableName + ";";

        Class c = Class.forName(tableName);
        Constructor constructor = c.getConstructor(ResultSet.class);



        //System.out.println(selectFromTable);
        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(selectAllFromTable);
        ){
            ArrayList<T> objects =new ArrayList<>();

            objects.add((T) constructor.newInstance(rs));
            while (rs.next()) {
                objects.add((T) constructor.newInstance(rs));
            }
           return  objects;
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    static <T> void deleteById(String tableName, T id) throws ClassNotFoundException, NoSuchMethodException {
        String deleteFromTableByID ="";
        if(id.getClass().getSimpleName().equals("String")){
            deleteFromTableByID = "delete from " + tableName + " where id = '" + id.toString() + "';";

        }else{
            deleteFromTableByID = "delete from " + tableName + " where id = " + id.toString() + ";";
        }


        try (
                Connection connection = connect();
                Statement statement = connection.createStatement();
        ){
            statement.executeUpdate(deleteFromTableByID);
        } catch ( Exception ex) {
            ex.printStackTrace();
        }
    }
}



