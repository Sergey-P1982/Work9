package com.epam;

import com.epam.task2.data.DataSource;
import com.epam.task2.entity.Book;
import com.epam.task2.model.Books;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestBooks {
    public static Books books;

    @Parameterized.Parameter
    public String author;

    @Parameterized.Parameter(1)
    public String publisher;

    @Parameterized.Parameter(2)
    public int yearRelease;

    @Parameterized.Parameter(3)
    public Book[] booksExpByAuthor;

    @Parameterized.Parameter(4)
    public Book[] booksExpByPublisher;

    @Parameterized.Parameter(5)
    public Book[] expBooksAfterYearRelease;

    @Parameterized.Parameters
    public static Collection data() throws IOException {
        init();

        return Arrays.asList(new Object[][]{
                {"Petrov", "DUH", 2000, new Book[]{books.getBooks()[3]}, new Book[]{books.getBooks()[1]},
                        new Book[]{books.getBooks()[2], books.getBooks()[3]}},
                {"Ivanov", "TIME", 2015, new Book[]{books.getBooks()[2]}, new Book[]{books.getBooks()[0]},
                        new Book[]{}},
                {"Frank", "VEL", 1919, new Book[]{}, new Book[]{}, DataSource.readAndGetBooksFromTxtFile()},

        });
    }

    @BeforeClass
    public static void init() throws IOException {
        books = new Books();
        books.setBooks(DataSource.readAndGetBooksFromTxtFile());

    }

    @Test
    public void TestGetByAuthor() {
        Book[] foundBooks = books.getByAuthor(author);
        Assert.assertArrayEquals(booksExpByAuthor, foundBooks);
    }

    @Test
    public void TestGetByPublisher() {
        Book[] foundBooks = books.getByPublisher(publisher);
        Assert.assertArrayEquals(booksExpByPublisher, foundBooks);
    }

    @Test
    public void TestGetAfterYearRelease() {
        Book[] foundBooks = books.getAfterYearRelease(yearRelease);
        Assert.assertArrayEquals(expBooksAfterYearRelease, foundBooks);
    }

    @Test
    public void TestSortByPyblisher() throws IOException {
        Book[] sortedBooks = books.sortByPublisher();
        Book[] expectedSortedBooks = new Book[]
                {new Book("Title2", "Tkachenko", "DUH", 1978, 420, 480.0),
                        new Book("Title3", "Ivanov", "FACT", 2012, 520, 150.0),
                        new Book("Title4", "Petrov", "TEZA", 2013, 620, 450.0),
                        new Book("Title1", "Shevchenko", "TIME", 1920, 320, 450.0),
                        new Book("Title5", "Franko", "VELES", 1982, 120, 350.0)};

        Assert.assertArrayEquals(expectedSortedBooks, sortedBooks);
    }
}
