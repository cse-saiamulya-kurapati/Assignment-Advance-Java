package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bookstore")
public class Bookstore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookName;
    private String author;
    private double price;

    public Bookstore() {}

    public Bookstore(String bookName, String author, double price) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
