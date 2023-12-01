package lab4;

import java.util.Objects;

/**
 * @author tfialho
 */

public class Ticket implements SaleableItem{


    // Attributes of a publication
    // defined as instance variables
    private String description;
    private double price;
    private String client;

    public Ticket(String description) {
        this.description = description;
    }

    public Ticket(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public Ticket(String description, double price, String client) {
        this.description = description;
        this.price = price;
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Double.compare(getPrice(), ticket.getPrice()) == 0 && Objects.equals(getDescription(), ticket.getDescription()) && Objects.equals(getClient(), ticket.getClient());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getPrice(), getClient());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", client='" + client + '\'' +
                '}';
    }

    @Override
    public void sellCopy() {
        System.out.println("**********************************");
        System.out.println("          TICKET VOUCHER          ");
        System.out.println(toString());
        System.out.println("**********************************");
        System.out.println();
    }

    @Override
    public double getPrice() {
        return price;
    }
}
