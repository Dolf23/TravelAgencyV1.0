package by.it.servlets.DTO;

public class TypeTour {
    private int id;
    private String typeTour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeTour() {
        return typeTour;
    }

    public void setTypeTour(String typeTour) {
        this.typeTour = typeTour;
    }

    @Override
    public String toString() {
        String out = "Type tour {id=" + id + ", type tour=" + typeTour + "}";
        return out;
    }
}
