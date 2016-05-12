package by.it.servlets;

import by.it.servlets.DAO.DAO;
import by.it.servlets.DAO.RoleDAO;
import by.it.servlets.DAO.UsersDAO;
import by.it.servlets.DTO.User;
import by.it.servlets.Logger.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registry extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new DAO();
        boolean is = false;
        User user = new User();
        try{
            user.setName(req.getParameter("name"));
            user.setSurname(req.getParameter("surname"));
            user.setEmail(req.getParameter("email"));
            user.setLogin(req.getParameter("login"));
            user.setPassword(req.getParameter("password"));

            if (null == req.getParameter("role"))
                user.setFk_Role(RoleDAO.getID("administrator"));
            else
                user.setFk_Role(RoleDAO.getID("user"));

            UsersDAO usersDAO = new UsersDAO();
            is = usersDAO.create(user);

        } catch (Exception e) {
            Logger.writeLog(e.toString());
        }

        if (is)
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("/registry.jsp").forward(req, resp);
    }
}
