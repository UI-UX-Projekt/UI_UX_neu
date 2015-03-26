package com.mycompany.neuerversuch;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class EventComparator implements Comparator<Event> {
    private Map<Event, Double> base;
    public EventComparator(Map<Event, Double> map) {
        base = map;
    }

    @Override
    public int compare(Event lhs, Event rhs) {
        if (base.get(lhs).intValue() >= base.get(rhs).intValue()) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
