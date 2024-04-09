package org.experis.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Event evento = null;

        try {
            Concert concert = new Concert(300, LocalDate.of(2026, 10, 22), "Prova", LocalTime.parse("15:22:18"),
                    new BigDecimal(1.22));
            System.out.println(concert);
            System.out.println(concert.getFormattedPrice());
            System.out.println(concert.getDateTime());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


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

                System.out.println("The date format is incorrect!");
                throw new IllegalArgumentException(e.getMessage());

            }

            System.out.println("How many seats have your location?");

            int seats = Integer.parseInt(scan.nextLine());


            try {
                evento = new Event(seats, date, title);
                isCorrect = true;
//
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            if (isCorrect) {
                boolean exitBook = false;

                while (!exitBook) {
                    System.out.println("Do you wish to book tickets for this event? Y/N");

                    String answer = scan.nextLine().toUpperCase();

                    switch (answer) {
                        case "N":
                            exitBook = true;
                            break;
                        case "Y":
                            System.out.println("The reserved tickets are : " + evento.getNumberOfBookedSeats());

                            System.out.println("How many tickets do you want to book?");

                            int seatsToBook = Integer.parseInt(scan.nextLine());

                            if (isCorrect) {
                                try {
                                    evento.book(seatsToBook);

                                    System.out.println("Your booking is complete");

                                    exitBook = true;

                                    System.out.println("The number of booked seats is: " + evento.getNumberOfBookedSeats());
                                    System.out.println("The remaining availability of tickets is: " + evento.getAvailableSeats());

                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
                            }

                            break;
                        default:
                            System.out.println("Invalid answer");
                            break;

                    }

                }


                boolean exitCancel = false;

                while (!exitCancel) {
                    System.out.println("Do you wish to cancel your booking for this event? Y/N");

                    String answer = scan.nextLine().toUpperCase();

                    switch (answer) {
                        case "N":
                            exitCancel = true;
                            break;
                        case "Y":
                            System.out.println("How many tickets do you want to cancel?");

                            int ticketsToCancel = Integer.parseInt(scan.nextLine());

                            try {
                                evento.cancel(ticketsToCancel);

                                System.out.println("Your cancellation is done!");

                                exitCancel = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }

                            System.out.println("The number of booked seats is: " + evento.getNumberOfBookedSeats());
                            System.out.println("The remaining availability of tickets is: " + evento.getAvailableSeats());


                            break;
                        default:
                            System.out.println("Invalid answer");
                            break;

                    }

                }
            }


        }

    }
}
