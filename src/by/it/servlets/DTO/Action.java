package by.it.servlets.DTO;

import by.it.servlets.DAO.ToursDAO;
import by.it.servlets.DAO.TypeActionDAO;
import by.it.servlets.DAO.UsersDAO;

import java.sql.SQLException;

public class Action {
    private int id;
    private int fk_action;
    private int fk_user;
    private int fk_tour;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getFk_action() {
        return fk_action;
    }
    public void setFk_action(int fk_action) {
        this.fk_action = fk_action;
    }

    public int getFk_user() {
        return fk_user;
    }
    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public int getFk_tour() {
        return fk_tour;
    }
    public void setFk_tour(int fk_tour) {
        this.fk_tour = fk_tour;
    }

    @Override
    public String toString() {
        String outString = "";
        try{
            outString = "Action{" +
                    "id=" + id +
                    ", fk_action=" + TypeActionDAO.getTypeAction(fk_action) +
                    ", fk_user=" + new UsersDAO().read(fk_user) +
                    ", fk_tour=" + new ToursDAO().read(fk_tour) +
                    '}';
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outString;
    }
}
