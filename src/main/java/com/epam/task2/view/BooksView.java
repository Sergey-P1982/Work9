package com.epam.task2.view;

import com.epam.task2.entity.Book;
import com.epam.task2.model.ResourceManager;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Locale;


public class BooksView {
    ResourceManager manager = ResourceManager.INSTANCE;

    public void printMenu() {

        System.out.println(manager.getString("mainMenu"));
    }
    public void printLanguageMenu() {
        System.out.println("1 - English");
        System.out.println("2 - Русский");
        System.out.println("3 - Українська");
        System.out.print(manager.getString("SelectLanguage"));
    }

    public void printBooks(String message, Book[] books) {

        System.out.println(message);
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();

    }

    public void printMessage(String message) {
        System.out.print(message);

    }
}
