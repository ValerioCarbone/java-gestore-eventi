package org.experis.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProgrammEventi {

    // ATTRIBUTI(FIELDS)
    private String title;
    private ArrayList<Event> programm;

    // COSTRUTTORI

    public ProgrammEventi(String title) {
        this.title = title;
    }

    // METODI

    public void addEvent(Event event) {
        programm.add(event);
    }

    public void getDateEvents(Event event, LocalDate date) {
        ArrayList<Event> filteredEvents =
                programm.stream().filter(e -> e.getDate().equals(date)).collect(Collectors.toCollection(ArrayList::new));

        System.out.println(filteredEvents);

    }

    public int getNumberOfEvents() {
        
        return programm.size();
    }
}
