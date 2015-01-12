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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author tylerreardon
 */
public class FileIO {

    public ArrayList makeCities() {
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
                info = line.split(" "); //finds zipCode, state, and cityName separated by space
                if (info.length == 3) {
                    City c1 = new City(info[0], info[1], info[2]); //constructs city object based on array
                    cities.add(c1);
                } else {
                    String multiWordCity = info[2];
                    for (int i = 3; i < info.length; i++) {
                        multiWordCity += " ";
                        multiWordCity += info[i];
                    }
                    City c1 = new City(info[0], info[1], multiWordCity);
                    cities.add(c1);
                }
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

    public void addCity(String zipcode, String state, String cityName) throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<City> cities = new ArrayList();
        cities = makeCities(); //make cities array
        zipcode = zipcode.replaceAll("\\s+", ""); //remove all excess spaces from zipcode

        String[] cityNameParts = cityName.split(" "); //make sure the user didn't add any extra spaces
        boolean firstWord = false;
        cityName = "";
        for (int i = 0; i < cityNameParts.length; i++) { //take away excess spaces in city name
            if (!"".equals(cityNameParts[i]) && !" ".equals(cityNameParts[i]) && firstWord == false && cityNameParts[0] != null) {
                cityNameParts[i] = cityNameParts[i].replaceAll("\\s+", "");
                cityName = cityNameParts[i]; //make corrected string
                firstWord = true;
            } else if (!"".equals(cityNameParts[i]) && !" ".equals(cityNameParts[i]) && firstWord == true && cityNameParts[i] != null) {
                cityName += " ";
                cityName += cityNameParts[i];
            }
        }

        City c1 = new City(zipcode, state, cityName); //create new city object
        cities.add(c1); //add object to city ArrayList
        PrintWriter writer = new PrintWriter("resources/Cities.txt", "UTF-8"); //write the information to the file
        for (int i = 0; i < cities.size(); i++) {
            writer.printf("%s %s %s\n", cities.get(i).getZipCode(), cities.get(i).getState(), cities.get(i).getCityName());
        }
        writer.close();
    }
    
    public void modifyOrRemoveCity(ArrayList<City> cities) throws FileNotFoundException, UnsupportedEncodingException{
        PrintWriter writer = new PrintWriter("resources/Cities.txt", "UTF-8");
        for (int i = 0; i < cities.size(); i++) {
            writer.printf("%s %s %s\n", cities.get(i).getZipCode(), cities.get(i).getState(), cities.get(i).getCityName());
        }
        writer.close();
    }

}
