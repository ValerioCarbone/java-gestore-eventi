package org.experis.events;

import java.text.DateFormat;
import java.time.LocalDate;

public class Event {

    // ATTRIBUTI

    private String title;
    private LocalDate date;
    private int numberOfSeats, numberOfBookedSeats;

    // COSTRUTTORE


    public Event(int numberOfSeats, LocalDate newDate, String title) throws IllegalArgumentException {
        this.numberOfBookedSeats = 0;
        this.numberOfSeats = numberOfSeats;
        this.title = title;

        if (newDate.isAfter(LocalDate.now())) {
            this.date = newDate;
        } else {
            throw new IllegalArgumentException("The date is incorrect");
        }


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfBookedSeats() {
        return numberOfBookedSeats;
    }


    // METODI

    public void book(Event event, int seatsToBook) {
        try {
            if (checkSeats(event.getNumberOfSeats(), event.getNumberOfBookedSeats(), seatsToBook) && checkDate(event.getDate())) {
                this.numberOfBookedSeats += seatsToBook;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Fail to book." + e);
        }
    }

    public void cancel(Event event, int seatsToCancel) throws IllegalArgumentException {

        if (event.getNumberOfBookedSeats() >= seatsToCancel) {
            this.numberOfBookedSeats -= seatsToCancel;
        } else if (event.getNumberOfBookedSeats() < seatsToCancel) {
            throw new IllegalArgumentException("You can't cancel seats not booked");
        } else if (!checkDate(event.getDate())) {
            throw new IllegalArgumentException("You can't cancel booked seats for a past event");
        }

    }

    public boolean checkSeats(int numberOfSeats, int bookedSeats, int seatsToBook) throws IllegalArgumentException {
        if (numberOfSeats - bookedSeats > seatsToBook) {
            return true;
        } else {
            throw new IllegalArgumentException("Not enough seats to complete your booking!");
        }
    }

    public boolean checkDate(LocalDate eventDate) throws IllegalArgumentException {

        LocalDate currentDate = LocalDate.now();

        if (eventDate.isBefore(currentDate)) throw new IllegalArgumentException("You can't book a seat for a past " +
                "event");
        else {
            return true;
        }
    }

    @Override
    public String toString() {


        return "Event{" +
                "date = " + date +
                ", title = '" + title + '\'' +
                '}';
    }
}
