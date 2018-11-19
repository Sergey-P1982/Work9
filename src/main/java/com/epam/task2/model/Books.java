package com.epam.task2.model;

import com.epam.task2.entity.Book;

import java.io.IOException;
import java.util.Arrays;

public class Books {
    private Book[] books;

    public Books() {
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Book[] getByAuthor(String author) {
        if (books != null) {
            Book[] temp = new Book[books.length];
            int counter = 0;
            for (int i = 0; i < books.length; i++) {
                if (books[i].getAuthor().equalsIgnoreCase(author)) {
                    temp[counter++] = books[i];
                }
            }
            return Arrays.copyOf(temp, counter);
        } else return null;
    }

    public Book[] getByPublisher(String publisher) {
        if (books != null) {
            Book[] temp = new Book[books.length];
            int counter = 0;
            for (int i = 0; i < books.length; i++) {
                if (books[i].getPublisher().equalsIgnoreCase(publisher)) {
                    temp[counter++] = books[i];
                }
            }
            return Arrays.copyOf(temp, counter);
        } else return null;
    }

    public Book[] getAfterYearRelease(int year) {
        if (books != null) {
            Book[] temp = new Book[books.length];
            int counter = 0;
            for (int i = 0; i < books.length; i++) {
                if (books[i].getYear() > year) {
                    temp[counter++] = books[i];
                }
            }
            return Arrays.copyOf(temp, counter);
        } else return null;
    }

    public Book[] sortByPublisher() throws IOException {
        if (books != null) {
            Book[] temp = getBooks();
            Arrays.sort(temp, new PublisherComparator());

            return temp;
        } else return null;
    }
}
