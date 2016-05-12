package by.it.servlets.DAO;

import by.it.servlets.DTO.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeHotelDAO implements IDAO<Hotel> {
    public static Integer getID(String typeHotel) throws SQLException {
        Integer out = null;
        String sql = String.format("SELECT ID FROM type_hotel_d WHERE Type_hotel='%s';", typeHotel);
        new DAO();
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getTypeHotel(Integer id) throws SQLException {
        String out = null;
        String sql = String.format("SELECT * FROM type_hotel_d WHERE ID='%d';", id);
        new DAO();
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Type_hotel");
        return out;
    }

    @Override
    public List<Hotel> getAll(String where) {
        new DAO();
        List<Hotel> list = new ArrayList<>();
        String sql = String.format("SELECT * FROM type_hotel_d %s;", where);
        Statement statement = DAO.getStatement();
        ResultSet resultSet;
        try{
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getInt("id"));
                hotel.setTypeHotel(resultSet.getString("Type_hotel"));
                list.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Hotel read(int id) {
        return null;
    }

    @Override
    public boolean create(Hotel hotel) {
        return false;
    }

    @Override
    public boolean update(Hotel hotel) {
        return false;
    }

    @Override
    public boolean delete(Hotel hotel) {
        return false;
    }
}
