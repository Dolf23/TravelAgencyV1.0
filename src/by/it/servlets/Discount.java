package by.it.servlets;

import by.it.servlets.DAO.*;
import by.it.servlets.DTO.Action;
import by.it.servlets.DTO.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Discount extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean is;
        PrintWriter printer = resp.getWriter();
        Tour tour = new Tour();
        Action action = new Action();
        try{
            tour.setId(Integer.parseInt(req.getParameter("id")));
            tour.setFk_type_tour(TypeTourDAO.getID(req.getParameter("Type_tour")));
            tour.setFk_country(CountriesDAO.getID(req.getParameter("Country")));
            tour.setFk_transport(TransportDAO.getID(req.getParameter("Transport")));
            tour.setFk_type_hotel(TypeHotelDAO.getID(req.getParameter("Type_hotel")));
            tour.setFk_food_complex(FoodComplexDAO.getID(req.getParameter("Food_complex")));
            tour.setCost(Integer.parseInt(req.getParameter("Cost")));
            tour.setDiscount(Integer.parseInt(req.getParameter("Discount")));

            ToursDAO toursDAO = new ToursDAO();
            is = toursDAO.update(tour);
            if (!is)
                new Exception("Discount not appointed.");

            printer.println(tour.toString());
            printer.flush();

            action.setFk_action(TypeActionDAO.getID("Discount"));
            action.setFk_tour(tour.getId());
            action.setFk_user(1);

            ActionDAO actionDAO = new ActionDAO();
            actionDAO.create(action);
        } catch (Exception e) {
            printer.println(e.toString());
        }
    }
}
