package com.epam.task2.controller;

import com.epam.task2.data.DataSource;
import com.epam.task2.entity.Book;
import com.epam.task2.model.Books;
import com.epam.task2.model.ResourceManager;
import com.epam.task2.view.BooksView;
import com.epam.task2.view.MenuLangScanner;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    final static Logger logger = Logger.getLogger(Controller.class);
    private Books model = new Books();
    private BooksView view = new BooksView();
    Scanner scan = new Scanner(System.in);
    ResourceManager manager = ResourceManager.INSTANCE;

    public void run() {
        try {
            model.setBooks(DataSource.readAndGetBooksFromTxtFile());
        } catch (FileNotFoundException ex) {
            logger.error("File not found", ex);
        } catch (IOException ex) {
            logger.error("IO exception", ex);
        }
        int menuItem;
        do {
            view.printMenu();
            view.printMessage(manager.getString("ChooseMenuItem"));
            menuItem = getMenuItem();
            while (menuItem > 5 || menuItem < 0) {
                view.printMessage(manager.getString("wrongInput"));
                logger.debug("Wrong number - " + menuItem);
                menuItem = getMenuItem();
            }
            executeMenuItem(menuItem);
        } while (menuItem != 5);
    }

    private void executeMenuItem(int number) {
        logger.debug("Menu item selected - " + number);
        switch (number) {
            case (0):
                view.printLanguageMenu();
                int command = MenuLangScanner.inputCommand();
                Locale locale = getLocale(command);
                manager.changeResource(locale);
                logger.debug("Selected locale - " + locale);

                break;
            case (1):
                view.printMessage(manager.getString("authorName"));
                String author = scan.next();
                logger.debug("Author name - " + author);
                searchByAuthor(author);
                break;
            case (2):
                view.printMessage(manager.getString("publisherName"));
                String publisher = scan.next();
                logger.debug("Publisher name - " + publisher);
                searchByPublisher(publisher);
                break;
            case (3):
                view.printMessage(manager.getString("releaseYear"));
                int releasYear = scan.nextInt();
                logger.debug("Release year - " + releasYear);
                searchByYearRelease(releasYear);
                break;
            case (4):
                sortByPublisher();
                break;
            case (5):
                view.printMessage(manager.getString("bye"));
                System.exit(0);
                break;
            default:
                view.printMessage(manager.getString("wrongInput"));
                break;
        }
    }

    private static Locale getLocale(int command) {
        switch (command) {
            case 1:
                return new Locale("en", "US");
            case 2:
                return new Locale("ru", "RU");
            case 3:
                return new Locale("uk", "UA");
            default:
                return Locale.getDefault();
        }
    }

    private int getMenuItem() {
        while (!scan.hasNextInt()) {
            view.printMessage(manager.getString("wrongInput"));
            logger.debug("Wrong input was typed");
            scan.next();
        }
        return scan.nextInt();

    }

    private void searchByAuthor(String author) {
        Book[] result = model.getByAuthor(author);
        if (result != null && result.length > 0) {
            view.printBooks(manager.getString("author") + " " + author + ":", result);
        } else {
            view.printMessage(manager.getString("notFoundAuthor") + "\n");
            logger.debug("The result is null or an empty array of the books");
        }
    }

    private void searchByPublisher(String publisher) {
        Book[] result = model.getByPublisher(publisher);
        if (result != null && result.length > 0) {
            view.printBooks(manager.getString("publisher") + " " + publisher + ": ", result);
        } else {
            view.printMessage(manager.getString("noBooksPublisher") + " " + publisher + '\n');
            logger.debug("The result is null or an empty array of the books");
        }
    }

    private void searchByYearRelease(int year) {
        Book[] result = model.getAfterYearRelease(year);
        if (result != null && result.length > 0) {
            view.printBooks(manager.getString("booksAfter") + " " + year + " :", result);
        } else {
            view.printMessage(manager.getString("noReleaseYearBook") + year);
            logger.debug("The result is null or an empty array of the books\n");
        }
    }

    private void sortByPublisher() {
        try {
            view.printBooks(manager.getString("sortingByPublisher"), model.sortByPublisher());
        } catch (NullPointerException ex) {
            logger.error("Null pointer exception", ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


