package by.it.servlets.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    private static Connection connection;
    private static Statement statement;
    private static DAO dao;

    public DAO() {
        try {
            connection = Xampp.getConnection(2016);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Statement getStatement() {
        return statement;
    }

    public static DAO getDAO() {
        if (dao == null) {
            dao = new DAO();
        }
        return dao;
    }

    public static void closeDAO() {
        try {
            connection.close();
            dao = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int executeUpdate(String sql){
        int result = -1;
        try {
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
