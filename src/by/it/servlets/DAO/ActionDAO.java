package by.it.servlets.DAO;

import by.it.servlets.DTO.Action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ActionDAO extends DAO implements IDAO<Action> {
    @Override
    public List<Action> getAll(String where) {
        new DAO();
        List<Action> actions = new ArrayList<>();
        String sql = String.format("SELECT * FROM Action_d %s;", where);
        Statement statement = DAO.getStatement();
        ResultSet resultSet;
        try{
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Action action = new Action();
                action.setId(resultSet.getInt("id"));
                action.setFk_action(resultSet.getInt("FK_action"));
                action.setFk_user(resultSet.getInt("FK_user"));
                action.setFk_tour(resultSet.getInt("FK_tour"));
                actions.add(action);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actions;
    }

    @Override
    public Action read(int id) {
        new DAO();
        List<Action> actions = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (0 < actions.size())
            return actions.get(0);
        else
            return null;
    }

    @Override
    public boolean create(Action action) {
        new DAO();
        String sql = String.format("INSERT INTO action_d(FK_action, FK_user, FK_tour) " +
                "VALUES (%d, %d, %d);",
                action.getFk_action(), action.getFk_user(), action.getFk_tour());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean update(Action action) {
        new DAO();
        String sql = String.format("UPDATE action_d SET FK_action=%d,  FK_user=%d,  FK_tour=%d WHERE id=%d",
                action.getFk_action(), action.getFk_user(), action.getFk_tour(), action.getId());
        return 0 < executeUpdate(sql);
    }

    @Override
    public boolean delete(Action action) {
        new DAO();
        String sql = String.format("DELETE FROM action_d WHERE id = %d;", action.getId());
        return 0 < executeUpdate(sql);
    }
}
