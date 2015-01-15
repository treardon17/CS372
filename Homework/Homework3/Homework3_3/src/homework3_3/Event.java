/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3_3;

import java.util.Comparator;

/**
 * Represents an event item in the list
 *
 * @author tylerreardon
 */
public class Event {

    private String _name, _location, _month, _date, _year;
    int _monthNumber;

    /**
     * Construct an event item
     *
     * @param name
     * @param location
     * @param month
     * @param date
     * @param year
     */
    public Event(String name, String location, String month, String date, String year) {
        _name = name;
        _location = location;
        _month = month;
        _date = date;
        _year = year;

        if ("January".equals(month)) {
            _monthNumber = 1;
        } else if ("Febrary".equals(month)) {
            _monthNumber = 2;
        } else if ("March".equals(month)) {
            _monthNumber = 3;
        } else if ("April".equals(month)) {
            _monthNumber = 4;
        } else if ("May".equals(month)) {
            _monthNumber = 5;
        } else if ("June".equals(month)) {
            _monthNumber = 6;
        } else if ("July".equals(month)) {
            _monthNumber = 7;
        } else if ("August".equals(month)) {
            _monthNumber = 8;
        } else if ("September".equals(month)) {
            _monthNumber = 9;
        } else if ("October".equals(month)) {
            _monthNumber = 10;
        } else if ("November".equals(month)) {
            _monthNumber = 11;
        } else if ("December".equals(month)) {
            _monthNumber = 12;
        }

    }

    /**
     * Gets the name of an event
     *
     * @return name of the event
     */
    public String getName() {
        return _name;
    }

    /**
     * Gets the location of an event
     *
     * @return location of the event
     */
    public String getLocation() {
        return _location;
    }

    /**
     * Gets the month of an event
     *
     * @return month of the event
     */
    public String getMonth() {
        return _month;
    }

    /**
     * Gets the number equivalent of the month of an event
     *
     * @return the month number of an event
     */
    public int getMonthNumber() {
        return _monthNumber;
    }

    /**
     * Gets the day of the month of an event
     *
     * @return day of event
     */
    public String getDate() {
        return _date;
    }

    /**
     * Gets the year of an event
     *
     * @return year of the event
     */
    public String getYear() {
        return _year;
    }

    /**
     * Formats the information from the event to be placed in the file
     *
     * @return the string to be written to the file
     */
    public String format() {
        String summary = _name + "~ " + _location + "~ " + _month + "/" + _date + "/" + _year + "\n";
        return summary;
    }

    /**
     * Formats the information from the event to be placed in the list
     *
     * @return the string to be displayed
     */
    public String displayFormat() {
        String summary = _name + ":  (at " + _location + "), on " + _month + "/" + _date + "/" + _year + "\n";
        return summary;
    }

    //Compares the date so that lowest value is first
    public static Comparator<Event> DateComparator = new Comparator<Event>() {
        @Override
        public int compare(Event e1, Event e2) {
            int cmp = e1.getYear().compareTo(e2.getYear());
            if (cmp == 0) { //if years are equal
                if (e1.getMonthNumber() == e2.getMonthNumber()) { //if months are equal
                    if (Integer.parseInt(e1.getDate()) < Integer.parseInt(e2.getDate())) { //if day is less
                        cmp = -1;
                    } else if (Integer.parseInt(e1.getDate()) == Integer.parseInt(e2.getDate())) { //if day is equal
                        cmp = 0;
                    } else { //if day is greater
                        cmp = 1;
                    }
                } else if (e1.getMonthNumber() < e2.getMonthNumber()) {
                    cmp = -1;
                } else {
                    cmp = 1;
                }
            } else {
                cmp = 1;
            }
//e1.getDate().compareTo(e2.getDate());
            return cmp;
        }
    };

    //Compares the Location alphabetically
    public static Comparator<Event> LocationComparator = new Comparator<Event>() {
        @Override
        public int compare(Event e1, Event e2) {
            int cmp = e1.getLocation().compareTo(e2.getLocation());
            return cmp;
        }
    };

    //Compares the names alphabetically
    public static Comparator<Event> NameComparator = new Comparator<Event>() {
        @Override
        public int compare(Event e1, Event e2) {
            int cmp = e1.getName().compareTo(e2.getName());
            return cmp;
        }
    };

}
