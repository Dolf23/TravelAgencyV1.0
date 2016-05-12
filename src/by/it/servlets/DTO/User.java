package by.it.servlets.DTO;

import by.it.servlets.DAO.RoleDAO;

import java.sql.SQLException;

public class User {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private int fk_Role;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getFk_Role() {
        return fk_Role;
    }
    public void setFk_Role(int fk_Role) {
        this.fk_Role = fk_Role;
    }

    @Override
    public String toString() {
        String outString = "";
        try{
            outString = "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", email='" + email + '\'' +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", fk_Role=" + RoleDAO.getRole(fk_Role) +
                    '}';
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outString;
    }
}
