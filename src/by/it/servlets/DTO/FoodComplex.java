package by.it.servlets.DTO;

public class FoodComplex {
    private int id;
    private String foodComplex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodComplex() {
        return foodComplex;
    }

    public void setFoodComplex(String foodComplex) {
        this.foodComplex = foodComplex;
    }

    @Override
    public String toString() {
        return "Food complex {id=" + id + ", Food complex=" + foodComplex + "}";
    }
}
