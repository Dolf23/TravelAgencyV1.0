package by.it.servlets.DTO;

public class Transport {
    private int id;
    private String transport;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "Transport {id=" + id + ", type transport=" + transport + "}";
    }
}
