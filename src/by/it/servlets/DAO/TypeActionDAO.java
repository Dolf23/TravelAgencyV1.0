package by.it.servlets.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeActionDAO {
    public static Integer getID(String typeAction) throws SQLException {
        Integer out = null;
        String sql = String.format("SELECT ID FROM type_action_d WHERE Type_action='%s';", typeAction);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getTypeAction(Integer id) throws SQLException {
        String out = null;
        String sql = String.format("SELECT * FROM type_action_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Type_action");
        return out;
    }
}
