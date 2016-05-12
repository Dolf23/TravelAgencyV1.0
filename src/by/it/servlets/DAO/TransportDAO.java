package by.it.servlets.DAO;

import by.it.servlets.DTO.Transport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransportDAO implements IDAO<Transport> {
    public static Integer getID(String transport) throws SQLException {
        new DAO();
        Integer out = null;
        String sql = String.format("SELECT ID FROM transport_d WHERE Transport='%s';", transport);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getTransport(Integer id) throws SQLException {
        new DAO();
        String out = null;
        String sql = String.format("SELECT * FROM transport_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Transport");
        return out;
    }

    @Override
    public List<Transport> getAll(String where) {
        new DAO();
        List<Transport> list = new ArrayList<>();
        String sql = String.format("SELECT * FROM transport_d %s;", where);
        Statement statement = DAO.getStatement();
        ResultSet resultSet;
        try{
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Transport transport = new Transport();
                transport.setId(resultSet.getInt("id"));
                transport.setTransport(resultSet.getString("Transport"));
                list.add(transport);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Transport read(int id) {
        return null;
    }

    @Override
    public boolean create(Transport transport) {
        return false;
    }

    @Override
    public boolean update(Transport transport) {
        return false;
    }

    @Override
    public boolean delete(Transport transport) {
        return false;
    }
}
