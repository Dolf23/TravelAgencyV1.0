package by.it.servlets.DTO;

public class Hotel {
    private int id;
    private String typeHotel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeHotel() {
        return typeHotel;
    }

    public void setTypeHotel(String typeHotel) {
        this.typeHotel = typeHotel;
    }

    @Override
    public String toString() {
        return "Type Hotel {id=" + id + ", type hotel=" + typeHotel + "}";
    }
}
