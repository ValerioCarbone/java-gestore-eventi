package org.experis.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProgrammEventi {

    // ATTRIBUTI(FIELDS)
    private String title;
    private ArrayList<Event> programm = new ArrayList<>();

    // COSTRUTTORI

    public ProgrammEventi(String title) {
        this.title = title;
    }

    // METODI

    public void addEvent(Event event) {
        programm.add(event);
    }

    public ArrayList<Event> getDateEvents(LocalDate date) {
        ArrayList<Event> filteredEvents =
                programm.stream().filter(e -> e.getDate().equals(date)).collect(Collectors.toCollection(ArrayList::new));


        return filteredEvents;

    }

    public int getNumberOfEvents() {

        return programm.size();
    }

    public void clearList() {
        programm.clear();
    }

    public String getEvents() {
        ArrayList<Event> filteredEvents =
                programm.stream().sorted(Comparator.comparing(Event::getDate)).collect(Collectors.toCollection(ArrayList::new));
        ;

        String string = "";

        for (Event e : filteredEvents) {
            string += e.getDate() + " " + e.getTitle() + "\n";
        }
        return string;

    }

}
