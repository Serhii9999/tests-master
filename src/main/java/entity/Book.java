package entity;

import java.util.Objects;

public class Book {


    private String title;
    private String author;
    private String price;
    private boolean bestSeller;

    public Book(String title, String author, String price, boolean bestseller) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.bestSeller = bestseller;


    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", bestSeller='" + bestSeller + '\'' +
                '}';
    }

}
