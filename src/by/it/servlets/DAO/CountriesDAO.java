package by.it.servlets.DAO;


import by.it.servlets.DTO.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountriesDAO implements IDAO<Country> {
    public static Integer getID(String country) throws SQLException {
        new DAO();
        Integer out = null;
        String sql = String.format("SELECT ID FROM countries_d WHERE Country='%s';", country);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");

        return out;
    }

    public static String getCountry(Integer id) throws SQLException {
        new DAO();
        String out = null;
        String sql = String.format("SELECT * FROM countries_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Country");
        return out;
    }

    @Override
    public List<Country> getAll(String where) {
        new DAO();
        List<Country> list = new ArrayList<>();
        String sql = String.format("SELECT * FROM countries_d %s;", where);
        Statement statement = DAO.getStatement();
        ResultSet resultSet;
        try{
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Country country = new Country();
                country.setId(resultSet.getInt("id"));
                country.setCountry(resultSet.getString("country"));
                list.add(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Country read(int id) {
        return null;
    }

    @Override
    public boolean create(Country country) {
        return false;
    }

    @Override
    public boolean update(Country country) {
        return false;
    }

    @Override
    public boolean delete(Country country) {
        return false;
    }
}
