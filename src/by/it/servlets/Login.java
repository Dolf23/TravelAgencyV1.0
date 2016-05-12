package by.it.servlets;

import by.it.servlets.DAO.UsersDAO;
import by.it.servlets.DTO.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("Login");
        String password = req.getParameter("passwordinput");

        UsersDAO usersDAO = new UsersDAO();
        List<User> list = usersDAO.getAll("WHERE Login='" + login + "'and Password='" + password + "'");
        if (0==list.size())
            resp.sendRedirect("login.jsp");
        else{
            HttpSession session = req.getSession();
            session.setAttribute("Login", login);
            session.setAttribute("UserIn", true);
            resp.sendRedirect("tourSelect.jsp");
        }

    }
}
