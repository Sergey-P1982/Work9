package com.epam.task2.data;

import com.epam.task2.entity.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DataSource {
    public static Book[] readAndGetBooksFromTxtFile() throws IOException {
        String inFileName = "Books_Txt_File.txt";
        Book[] books;
        int count = 0;
        String inputLine;
        try (BufferedReader reader = new BufferedReader(new FileReader(inFileName));
             BufferedReader reader2 = new BufferedReader(new FileReader(inFileName))) {
            while ((reader.readLine()) != null) count++;
            books = new Book[count];

            for (int i = 0; i < books.length; i++) {
                inputLine = reader2.readLine();
                String[] token = inputLine.split(",");
                if (token.length == 6) {
                    books[i] = new Book(token[0].trim(), token[1].trim(), token[2].trim(), Integer.parseInt(token[3].trim()),
                            Integer.parseInt(token[4].trim()), Double.parseDouble(token[5].trim()));
                }
            }
        }

        return books;
    }

}

