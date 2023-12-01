package lab4;

import java.util.Date;
import java.util.Objects;

/**
 * @author tfialho
 */
public class Magazine extends Publication {

    // Attributes of a publication
    // defined as instance variables
    private int orderQty = 10;
    private Date currIssue;

    public Magazine() {
    }

    public Magazine(String title, double price, int orderQty, Date currIssue, int copies) {
        super(title, price, copies);
        this.orderQty = orderQty;
        this.currIssue = currIssue;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public Date getCurrIssue() {
        return currIssue;
    }

    public void setCurrIssue(Date currIssue) {
        this.currIssue = currIssue;
    }

    public void adjustQty(int n){
        this.orderQty = n;
    }

    public void receiveNewIssue(Date newIssue){
        this.currIssue = newIssue;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "orderQty=" + orderQty +
                ", currIssue=" + currIssue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine magazine)) return false;
        if (!super.equals(o)) return false;
        return getOrderQty() == magazine.getOrderQty() && Objects.equals(getCurrIssue(), magazine.getCurrIssue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOrderQty(), getCurrIssue());
    }

    @Override
    public void sellCopy() {

    }

    @Override
    public double getPrice() {
        return 0;
    }
}
