package by.it.servlets.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Xampp {

    //стандартные настройки XAMPP
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        //стандартный порт 3306
        final String URL3306 = "jdbc:mysql://127.0.0.1:3306/it_academy"
        /*добавим UTF-8*/ + "?useUnicode=true&characterEncoding=UTF-8";
        /*хотя достаточно было бы и так    +"?characterEncoding=UTF-8"; */
        return getConnection(URL3306, USER, PASSWORD);
    }

    //все стандартно, но нестандартный порт
    public static Connection getConnection(int port) throws SQLException {
        //стандартный порт 3306
        final String URL = "jdbc:mysql://127.0.0.1:" + port + "/it_academy"
        /*добавим UTF-8*/ + "?useUnicode=true&characterEncoding=UTF-8";
        return getConnection(URL, USER, PASSWORD);
    }

    //все свое собственное, используйте для своей базы
    public static Connection getConnection(String URL, String USER, String PASSWORD) throws SQLException {
        return DriverManager.getConnection (URL, USER, PASSWORD);
    }

}
