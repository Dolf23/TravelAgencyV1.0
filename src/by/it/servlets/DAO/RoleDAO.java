package by.it.servlets.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO {

    public static Integer getID(String role) throws SQLException {
        new DAO();
        Integer out = null;
        String sql = String.format("SELECT ID FROM role_d WHERE Role='%s';", role);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getRole(Integer id) throws SQLException {
        new DAO();
        String out = null;
        String sql = String.format("SELECT * FROM role_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Role");
        return out;
    }
}
