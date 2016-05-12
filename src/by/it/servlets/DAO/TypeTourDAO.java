package by.it.servlets.DAO;

import by.it.servlets.DTO.TypeTour;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeTourDAO implements IDAO<TypeTour> {
    public static Integer getID(String typeTour) throws SQLException {
        new DAO();
        Integer out = null;
        String sql = String.format("SELECT ID FROM type_tour_d WHERE Type_tour='%s';", typeTour);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getTypeTour(Integer id) throws SQLException {
        new DAO();
        String out = null;
        String sql = String.format("SELECT * FROM type_tour_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Type_tour");
        return out;
    }

    @Override
    public List<TypeTour> getAll(String where) {
        List<TypeTour> list = new ArrayList<>();
        String sql = String.format("SELECT * FROM type_tour_d %s;", where);
        new DAO();
        Statement statement = DAO.getStatement();
        ResultSet resultSet;
        try{
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                TypeTour typeTour = new TypeTour();
                typeTour.setId(resultSet.getInt("id"));
                typeTour.setTypeTour(resultSet.getString("Type_tour"));
                list.add(typeTour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public TypeTour read(int id) {
        return null;
    }

    @Override
    public boolean create(TypeTour typeTour) {
        return false;
    }

    @Override
    public boolean update(TypeTour typeTour) {
        return false;
    }

    @Override
    public boolean delete(TypeTour typeTour) {
        return false;
    }
}
