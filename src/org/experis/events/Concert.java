package org.experis.events;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event {

    // ATTRIBUTI(FIELD)

    private LocalTime time;
    private BigDecimal price;

    // COSTRUTTORI

    public Concert(int numberOfSeats, LocalDate newDate, String title, LocalTime time, BigDecimal price) throws IllegalArgumentException {
        super(numberOfSeats, newDate, title);

        if (price.compareTo(new BigDecimal(0)) <= 0) {
            throw new IllegalArgumentException("The ticket price must be over 0");
        }

        this.price = price;
        this.time = time;
    }

    // METODI


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getFormattedPrice() {
        return NumberFormat.getCurrencyInstance().format(price);
    }

    public String getDateTime() {
        return "Date: " + getDate() + "\n" + "Time: " + getTime();
    }


    @Override
    public String toString() {
        return "Concert { " + "\n" +
                getDateTime() + "\n" +
                "Title: " + getTitle() + "\n" +
                "Price: " + getFormattedPrice() + "\n" +
                " \n}";
    }
}
