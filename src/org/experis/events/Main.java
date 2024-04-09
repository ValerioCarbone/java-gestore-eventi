package org.experis.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean isCorrect = false;

        while (!isCorrect) {
            System.out.println("To create a new event insert :");
            System.out.println("Title ");

            String title = scan.nextLine();

            System.out.println("Date (dd-mm-yyyy) ");

            LocalDate date = null;
            try {
                date = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                System.out.println(date);
            } catch (IllegalArgumentException e) {

                System.out.println("The date forma is incorrect!");
                throw new IllegalArgumentException(e.getMessage());

            }

            System.out.println("How many seats have your location?");

            int seats = Integer.parseInt(scan.nextLine());

            Event evento = null;

            try {
                evento = new Event(seats, date, title);
                isCorrect = true;
//
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println(evento);
        }


    }


}
