package by.it.servlets;

import by.it.servlets.DAO.*;
import by.it.servlets.DTO.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateTour extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Tour tour = new Tour();
        try {
            tour.setFk_type_tour(Integer.parseInt(req.getParameter("Typetour")));
            tour.setFk_country(CountriesDAO.getID(req.getParameter("Country")));
            tour.setFk_transport(TransportDAO.getID(req.getParameter("Transport")));
            tour.setFk_type_hotel(TypeHotelDAO.getID(req.getParameter("Hotel")));
            tour.setFk_food_complex(FoodComplexDAO.getID(req.getParameter("FoodComplex")));
            tour.setCost(Integer.parseInt(req.getParameter("Cost")));
            tour.setDiscount(0);

            ToursDAO toursDAO = new ToursDAO();
            if (!toursDAO.create(tour))
                new Exception("Error create tour.");
            out.println(tour.toString());
        }
        catch (Exception e){
            out.println(e.toString());
        }
        out.flush();
        resp.sendRedirect("createTour.jsp");
    }
}
