package com.epam.task2.entity;

public class Book {
    private String name;
    private String author;
    private String publisher;
    private int year;
    private int pages;
    private double price;


    public Book(String name, String author, String publisher, int year, int pages, double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return getYear() == book.getYear() &&
                getPages() == book.getPages() &&
                Double.compare(book.getPrice(), getPrice()) == 0 &&
                getName().equals(book.getName()) &&
                getAuthor().equals(book.getAuthor()) &&
                getPublisher().equals(book.getPublisher());
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + name.hashCode();
        result = 31*result + author.hashCode();
        result = 31*result + publisher.hashCode();
        result = 31*result + year;
        result = 31*result + pages;
        result = 31*result + (int)((Double.doubleToLongBits(price))^(Double.doubleToLongBits(price)>>>32));
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }

}
