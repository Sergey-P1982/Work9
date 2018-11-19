package com.epam.task2;

import com.epam.task2.controller.Controller;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        new Controller().run();
    }
}
//OUTPUT:
//       WELCOME TO THE LIBRARY MENU:
//        0. Select language.
//        1. Search for books by author.
//        2. Search for books by publisher name.
//        3. Find books after a certain year of publication.
//        4. Sort books by publisher name.
//        5. Exit.
//
//        Choose menu item >1
//        Enter author name:ABC
//        Not found any books by same author
//        WELCOME TO THE LIBRARY MENU:
//        0. Select language.
//        1. Search for books by author.
//        2. Search for books by publisher name.
//        3. Find books after a certain year of publication.
//        4. Sort books by publisher name.
//        5. Exit.
//
//        Choose menu item >0
//        1 - English
//        2 - Русский
//        3 - Українська
//        Select number to change the language >2
//        ДОБРО ПОЖАЛОВАТЬ В МЕНЮ БИЛИОТЕКИ:
//        0. Выбор языка.
//        1. Поиск книг по автору.
//        2. Поиск книг по издательству.
//        3. Поиск книг после заданного года издания.
//        4. Сортировка книг по названию издательства.
//        5. Выход.
//
//        Выберите пункт меню > 2
//        Введите название издательства: DUH
//        Издательство -  DUH:
//        Book{name='Title2', author='Tkachenko', publisher='DUH', year=1978, pages=420, price=480.0}
//
//        ДОБРО ПОЖАЛОВАТЬ В МЕНЮ БИЛИОТЕКИ:
//        0. Выбор языка.
//        1. Поиск книг по автору.
//        2. Поиск книг по издательству.
//        3. Поиск книг после заданного года издания.
//        4. Сортировка книг по названию издательства.
//        5. Выход.
//
//        Выберите пункт меню > 0
//        1 - English
//        2 - Русский
//        3 - Українська
//        Выберите язык по номеру >3
//        ЛАСКАВО ПРОСИМО ДО БІБЛІОТЕЧНОГО МЕНЮ:
//        0. Вибір мови.
//        1. Пошук книг за автором.
//        2. Пошук книг за видавництвом.
//        3. Пошук книг за певним роком видання.
//        4. Сотування книг за назвою видавництва.
//        5. Вихід.
//
//        Оберіть пункт меню > 3
//        Введіть рік видання книги:1999
//        Книги видані після 1999 :
//        Book{name='Title3', author='Ivanov', publisher='FACT', year=2012, pages=520, price=150.0}
//        Book{name='Title4', author='Petrov', publisher='TEZA', year=2013, pages=620, price=450.0}
//
//        ЛАСКАВО ПРОСИМО ДО БІБЛІОТЕЧНОГО МЕНЮ:
//        0. Вибір мови.
//        1. Пошук книг за автором.
//        2. Пошук книг за видавництвом.
//        3. Пошук книг за певним роком видання.
//        4. Сотування книг за назвою видавництва.
//        5. Вихід.
//
//        Оберіть пункт меню > 4
//        Книги відсортовані за назвою видавництва:
//        Book{name='Title2', author='Tkachenko', publisher='DUH', year=1978, pages=420, price=480.0}
//        Book{name='Title3', author='Ivanov', publisher='FACT', year=2012, pages=520, price=150.0}
//        Book{name='Title4', author='Petrov', publisher='TEZA', year=2013, pages=620, price=450.0}
//        Book{name='Title1', author='Shevchenko', publisher='TIME', year=1920, pages=320, price=450.0}
//        Book{name='Title5', author='Franko', publisher='VELES', year=1982, pages=120, price=350.0}
//
//        ЛАСКАВО ПРОСИМО ДО БІБЛІОТЕЧНОГО МЕНЮ:
//        0. Вибір мови.
//        1. Пошук книг за автором.
//        2. Пошук книг за видавництвом.
//        3. Пошук книг за певним роком видання.
//        4. Сотування книг за назвою видавництва.
//        5. Вихід.
//
//        Оберіть пункт меню > 5
//        До побачення!