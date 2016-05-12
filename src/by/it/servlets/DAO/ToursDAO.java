package by.it.servlets.DAO;

import by.it.servlets.DTO.Tour;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToursDAO extends DAO implements IDAO<Tour> {
    @Override
    public List<Tour> getAll(String where){
        new DAO();
        List<Tour> tours = new ArrayList<>();
        String sql = String.format("SELECT * FROM tours_d %s;", where);
        ResultSet resultSet;
        Statement statement = DAO.getStatement();
        try{
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setFk_country(resultSet.getInt("FK_country"));
                tour.setFk_type_tour(resultSet.getInt("FK_type_tour"));
                tour.setFk_transport(resultSet.getInt("FK_transport"));
                tour.setFk_type_hotel(resultSet.getInt("FK_type_hotel"));
                tour.setFk_food_complex(resultSet.getInt("FK_food_complex"));
                tour.setCost(resultSet.getInt("Cost"));
                tour.setDiscount(resultSet.getInt("Discount"));
                tours.add(tour);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tours;
    }

    @Override
    public Tour read(int id) {
        new DAO();
        List<Tour> tours = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (0 < tours.size())
            return tours.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Tour tour) {
        new DAO();
        String sql = String.format("INSERT INTO tours_d(FK_country, FK_type_tour, FK_transport, FK_type_hotel, FK_food_complex, Cost, Discount)" +
                " values(%d, %d, %d, %d, %d, %d, %d);",
                tour.getFk_country(), tour.getFk_type_tour(), tour.getFk_transport(), tour.getFk_type_hotel(), tour.getFk_food_complex(), tour.getCost(), tour.getDiscount());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean update(Tour tour) {
        new DAO();
        String sql = String.format("UPDATE tours_d SET FK_country=%d,  FK_type_tour=%d,  FK_transport=%d,  FK_type_hotel=%d,  FK_food_complex=%d,  Cost=%d, Discount=%d WHERE id=%d;",
                tour.getFk_country(), tour.getFk_type_tour(), tour.getFk_transport(), tour.getFk_type_hotel(), tour.getFk_food_complex(), tour.getCost(), tour.getDiscount(), tour.getId());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean delete(Tour tour) {
        new DAO();
        String sql = String.format("DELETE FROM tours_d WHERE id = %d;", tour.getId());
        return 0 < executeUpdate(sql);
    }
}
