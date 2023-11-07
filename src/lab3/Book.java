package lab3;

import java.util.Objects;

/**
 * @author tfialho
 */
public class Book extends Publication {

    // Attributes of a publication
    // defined as instance variables
    private String author;

    public Book(String author) {
        super();
        this.author = author;
    }

    public Book(String author, String title, double price, int copies) {
        super(title, price, copies);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void orderCopies(int numCopies){
        this.setCopies(numCopies);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(getAuthor(), book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAuthor());
    }
}
