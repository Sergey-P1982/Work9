package com.epam.task2.view;


import java.util.Scanner;

public class MenuLangScanner {
    private static Scanner scan = new Scanner(System.in);

    public static int scanMenuItem() {

        while (!scan.hasNextInt()) {
            System.out.print("Wrong input. Try again > ");
            scan.next();
        }
        return scan.nextInt();
    }

    public static int inputCommand() {
        int com = 0;
        while (com < 1 || com > 3) {
            com = scanMenuItem();
            if (com < 1 || com > 3) System.out.print("Wrong input. Try again > ");
        }

        return com;
    }
}
