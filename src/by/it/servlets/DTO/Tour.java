package by.it.servlets.DTO;

import by.it.servlets.DAO.CountriesDAO;
import by.it.servlets.DAO.FoodComplexDAO;
import by.it.servlets.DAO.TransportDAO;
import by.it.servlets.DAO.TypeTourDAO;

import java.sql.SQLException;

public class Tour {
    private int id;
    private int fk_country;
    private int fk_type_tour;
    private int fk_transport;
    private int fk_type_hotel;
    private int fk_food_complex;
    private int cost;
    private int discount;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getFk_country() {
        return fk_country;
    }
    public void setFk_country(int fk_country) {
        this.fk_country = fk_country;
    }

    public int getFk_type_tour() {
        return fk_type_tour;
    }
    public void setFk_type_tour(int fk_type_tour) {
        this.fk_type_tour = fk_type_tour;
    }

    public int getFk_transport() {
        return fk_transport;
    }
    public void setFk_transport(int fk_transport) {
        this.fk_transport = fk_transport;
    }

    public int getFk_type_hotel() {
        return fk_type_hotel;
    }
    public void setFk_type_hotel(int fk_type_hotel) {
        this.fk_type_hotel = fk_type_hotel;
    }

    public int getFk_food_complex() {
        return fk_food_complex;
    }
    public void setFk_food_complex(int fk_food_complex) {
        this.fk_food_complex = fk_food_complex;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        String outString = "";
        try {
            outString = "Tour{" +
                    //"id=" + id +
                    ", fk_country=" + CountriesDAO.getCountry(fk_country) +
                    ", fk_type_tour=" + TypeTourDAO.getTypeTour(fk_type_tour) +
                    ", fk_transport=" + TransportDAO.getTransport(fk_transport) +
                    ", fk_type_hotel=" + TypeTourDAO.getTypeTour(fk_type_hotel) +
                    ", fk_food_complex=" + FoodComplexDAO.getFoodComplex(fk_food_complex) +
                    ", cost=" + cost +
                    //", discount=" + discount +
                    '}';
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outString;
    }
}
