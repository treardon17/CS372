/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 *
 * @author tylerreardon
 */
public class ReadFromFile {
    
    public ArrayList makeCities(){
        ArrayList<City> cities = new ArrayList();
        File cityFile = new File("resources/Cities.txt");
        String line = null;
        String[] info;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream(cityFile);

            // Here BufferedInputStream is added for fast reading.
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            // dis.available() returns 0 if the file does not have more lines.
            while (dis.available() != 0) {
                line = dis.readLine(); //reads line from file
                info = line.split(" "); //finds pointNumber, state, and cityName separated by space
                City c1 = new City(info[0], info[1], info[2]); //constructs city object based on array
                cities.add(c1);
            }

            // dispose all the resources after using them.
            fis.close();
            bis.close();
            dis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
