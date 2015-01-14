/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Allows for file Input and Output
 * @author tylerreardon
 */
public class FileIO {

    /**
     * Creates an array of Event objects from a file
     * @return an <code>ArrayList</code> of Events
     * @throws FileNotFoundException 
     */
    public ArrayList<Event> readEvents() throws FileNotFoundException {
        ArrayList<Event> events = new ArrayList<>();
        File f = new File("resources/events.txt");
        String line;
        String[] date;
        String[] info;
        try {
            BufferedReader rdr = new BufferedReader(new FileReader(f));

            while ((line = rdr.readLine()) != null) { //read to the end of the file
                info = line.split("~ "); //split items based on "~ "
                date = info[2].split("/"); //splits date based on "/"
                if (info.length == 3) {
                    Event e1 = new Event(info[0], info[1], date[0], date[1], date[2]); //constructs object with file information
                    events.add(e1); //add item to array
                }

            }
            rdr.close();
        } catch (Exception ex) {
            System.out.println("Error!");
        }
        return events; //return the ArrayList
    }

    /**
     * Saves the events to a file
     * @param events 
     */
    public void saveEvents(ArrayList<Event> events) {
        File file = new File("resources/events.txt");
        try {
            BufferedWriter wrtr = new BufferedWriter(new FileWriter(file));
            String line;

            for (int i = 0; i < events.size(); i++) {
                line = events.get(i).format();
                wrtr.write(line);
            }

            wrtr.close();
        } catch (Exception ex) {
            System.out.println("Invalid File!");
        }

    }

}
