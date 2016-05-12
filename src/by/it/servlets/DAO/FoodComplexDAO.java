package by.it.servlets.DAO;

import by.it.servlets.DTO.FoodComplex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodComplexDAO implements IDAO<FoodComplex> {
    public static Integer getID(String food) throws SQLException {
        new DAO();
        Integer out = null;
        String sql = String.format("SELECT ID FROM food_complex_d WHERE Food_complex='%s';", food);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getInt("id");
        return out;
    }

    public static String getFoodComplex(Integer id) throws SQLException {
        new DAO();
        String out = null;
        String sql = String.format("SELECT * FROM food_complex_d WHERE ID='%d';", id);
        ResultSet resultSet = DAO.getStatement().executeQuery(sql);
        if (resultSet.next()) out = resultSet.getString("Food_complex");
        return out;
    }

    @Override
    public List<FoodComplex> getAll(String where) {
            new DAO();
            List<FoodComplex> list = new ArrayList<>();
            String sql = String.format("SELECT * FROM food_complex_d %s;", where);
            Statement statement = DAO.getStatement();
            ResultSet resultSet;
            try{
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    FoodComplex foodComplex = new FoodComplex();
                    foodComplex.setId(resultSet.getInt("id"));
                    foodComplex.setFoodComplex(resultSet.getString("Food_complex"));
                    list.add(foodComplex);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
    }

    @Override
    public FoodComplex read(int id) {
        return null;
    }

    @Override
    public boolean create(FoodComplex foodComplex) {
        return false;
    }

    @Override
    public boolean update(FoodComplex foodComplex) {
        return false;
    }

    @Override
    public boolean delete(FoodComplex foodComplex) {
        return false;
    }
}
