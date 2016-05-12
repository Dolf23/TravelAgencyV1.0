package by.it.servlets.DAO;

import by.it.servlets.DTO.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO extends DAO implements IDAO<User> {
    @Override
    public List<User> getAll(String where){
        new DAO();
        List<User> users = new ArrayList<>();
        String sql = String.format("SELECT * FROM users_d %s;", where);
        Statement statement = DAO.getStatement();
        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("Name"));
                user.setSurname(resultSet.getString("Surname"));
                user.setEmail(resultSet.getString("Email"));
                user.setLogin(resultSet.getString("Login"));
                user.setPassword(resultSet.getString("Password"));
                user.setFk_Role(resultSet.getInt("FK_Role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User read(int id) {
        new DAO();
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if(0 < users.size())
            return users.get(0);
        else
            return null;
    }

    @Override
    public boolean create(User user) {
        new DAO();
        String sql = String.format("insert INTO users_d(Name, Surname, Email, Login, Password, FK_Role)" +
                " values('%s', '%s', '%s', '%s', '%s', %d);",
                user.getName(), user.getSurname(), user.getEmail(), user.getLogin(), user.getPassword(), user.getFk_Role());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean update(User user) {
        new DAO();
        String sql = String.format("UPDATE users_d SET Name='%s',  Surname='%s',  Email='%s',  Login='%s',  Password='%s',  FK_Role=%d WHERE id=%d",
                user.getName(), user.getSurname(), user.getEmail(), user.getLogin(), user.getPassword(), user.getFk_Role(), user.getId());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean delete(User user) {
        new DAO();
        String sql = String.format("DELETE FROM users_d WHERE id = %d;", user.getId());
        return 0 < executeUpdate(sql);
    }
}
