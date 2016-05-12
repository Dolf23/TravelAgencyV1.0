package by.it.servlets;

import by.it.servlets.DAO.*;
import by.it.servlets.DTO.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.it.servlets.Logger.Logger.writeLog;

public class TourSelect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new DAO();
        writeLog("First act");
        List<TypeTour> typeTourList = new TypeTourDAO().getAll("");
        writeLog("1");
        req.setAttribute("typeTourList", typeTourList);
        writeLog("2");

        List<Country> countryList = new CountriesDAO().getAll("");
        req.setAttribute("countryList", countryList);

        List<Transport> transportList = new TransportDAO().getAll("");
        req.setAttribute("transportList", transportList);

        List<Hotel> hotelList = new TypeHotelDAO().getAll("");
        req.setAttribute("hotelList", hotelList);

        List<FoodComplex> foodComplexList = new FoodComplexDAO().getAll("");
        req.setAttribute("foodComplexList", foodComplexList);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        writeLog("second act");
        boolean is = false;
        String sql;
        try{
            sql =String.format("WHERE FK_type_tour=%s and FK_country=%s and FK_transport=%s and FK_food_complex=%s and FK_type_hotel=%s",
                    req.getParameter("Type_tour"), req.getParameter("Country"), req.getParameter("Transport"), req.getParameter("Food_complex"), req.getParameter("Type_hotel"));
            ToursDAO toursDAO = new ToursDAO();
            List<Tour> list = toursDAO.getAll(sql);

            HttpSession session = req.getSession();
            session.setAttribute("userList", list);

        }
        catch (Exception e){
            writeLog(e.toString());
        }

        req.getRequestDispatcher("/reserve.jsp").forward(req, resp);
    }
}
