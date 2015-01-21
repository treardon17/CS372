/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Allows user to input and output information to relevant files
 *
 * @author tylerreardon
 */
public class FileIO {

    Map<String, File[]> imageFiles = new HashMap();

    public FileIO() {

        File imageFolder = new File("resources/images");
        File[] listOfFolders = imageFolder.listFiles();
        for (int i = 1; i < listOfFolders.length; i++) {
            File[] listOfFiles = listOfFolders[i].listFiles();
            imageFiles.put(listOfFolders[i].getName(), listOfFiles);
        }

    }

    /**
     * Reads cities from file and creates City objects
     *
     * @return an ArrayList of City objects
     * @throws java.net.MalformedURLException
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public ArrayList makeCities() throws MalformedURLException, SAXException, ParserConfigurationException {
        ArrayList<City> cities = new ArrayList();
        File cityFile = new File("resources/Cities.txt");

        String line;
        String[] info;
        FileInputStream fis;
        BufferedInputStream bis;
        DataInputStream dis;
        try {
            fis = new FileInputStream(cityFile);

            // Here BufferedInputStream is added for fast reading.
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            // dis.available() returns 0 if the file does not have more lines.
            while (dis.available() != 0) {
                line = dis.readLine(); //reads line from file
                info = line.split(" ~"); //finds zipCode, state, and cityName separated by space
                if (info.length == 2) {
                    City c1 = new City(info[0], info[1]); //constructs city object based on array
                    cities.add(c1); //adds city object to cities ArrayList
                } else { //if the city is more than one word
                    String multiWordCity = info[1]; //set the first word of the city
                    for (int i = 2; i < info.length; i++) {
                        multiWordCity += " "; //append the next words to the end with a space in between
                        multiWordCity += info[i];
                    }
                    City c1 = new City(info[0], multiWordCity); //create new city object
                    cities.add(c1); //add city to city ArrayList
                }
            }

            // dispose all the resources after using them.
            fis.close();
            bis.close();
            dis.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("File input output exception...");
        }
        Collections.sort(cities, City.CityComparator); //sort city alphabetically

        return cities;
    }

    /**
     * Adds a city to the file
     *
     * @param zipcode
     * @param state
     * @param cityName
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     * @throws java.net.MalformedURLException
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public void addCity(String state, String cityName) throws FileNotFoundException, UnsupportedEncodingException, IOException, MalformedURLException, SAXException, ParserConfigurationException {
        ArrayList<City> cities = makeCities(); //make cities array

        String[] cityNameParts = cityName.split(" "); //make sure the user didn't add any extra spaces
        String[] stateNameParts = state.split(" ");
        boolean firstWord = false; //determines if the first word has been reached if there are multiple spaces before the word
        cityName = "";
        state = "";
        for (int i = 0; i < cityNameParts.length; i++) { //take away excess spaces in city name
            if (!"".equals(cityNameParts[i]) && !" ".equals(cityNameParts[i]) && firstWord == false && cityNameParts[0] != null) {
                cityNameParts[i] = cityNameParts[i].replaceAll("\\s+", ""); //replace all space characters with empty string
                cityName = cityNameParts[i]; //make corrected string
                firstWord = true;
            } else if (!"".equals(cityNameParts[i]) && !" ".equals(cityNameParts[i]) && firstWord == true && cityNameParts[i] != null) {
                cityName += " ";
                cityName += cityNameParts[i];
            }
        }

        for (int i = 0; i < stateNameParts.length; i++) { //take away excess spaces in state name
            if (!"".equals(stateNameParts[i]) && !" ".equals(stateNameParts[i]) && firstWord == false && stateNameParts[0] != null) {
                stateNameParts[i] = stateNameParts[i].replaceAll("\\s+", ""); //replace all space characters with empty string
                state = stateNameParts[i]; //make corrected string
                firstWord = true;
            } else if (!"".equals(stateNameParts[i]) && !" ".equals(stateNameParts[i]) && firstWord == true && stateNameParts[i] != null) {
                state += " ";
                state += stateNameParts[i];
            }
        }

        City c1 = new City(state, cityName); //create new city object
        cities.add(c1); //add object to city ArrayList
        //write city information to file
        try (PrintWriter writer = new PrintWriter("resources/Cities.txt", "UTF-8") //write the information to the file
                ) {
            //write city information to file
            for (int i = 0; i < cities.size(); i++) {
                writer.printf("%s ~%s\n", cities.get(i).getState(), cities.get(i).getCityName());
            }
        }
    }

    /**
     * Gives the ability to modify a city in the file or remove a city from the
     * file
     *
     * @param cities
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public void modifyOrRemoveCity(ArrayList<City> cities) throws FileNotFoundException, UnsupportedEncodingException {
        try (PrintWriter writer = new PrintWriter("resources/Cities.txt", "UTF-8")) {
            for (int i = 0; i < cities.size(); i++) {
                writer.printf("%s ~%s\n", cities.get(i).getState(), cities.get(i).getCityName());
            }
        }
    }

    /**
     * Saves preferred city in file for startup
     *
     * @param city
     * @throws FileNotFoundException
     */
    public void setPreferredCity(City city) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter("resources/Preferences.txt")) {
            writer.printf("%s ~%s\n", city.getState(), city.getCityName());
        }
    }

    /**
     * Gets the preferred city from the file
     *
     * @return preferred city
     * @throws java.io.IOException
     * @throws java.net.MalformedURLException
     * @throws org.xml.sax.SAXException
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    public City getPreferredCity() throws IOException, MalformedURLException, SAXException, ParserConfigurationException {
        File cityFile = new File("resources/Preferences.txt");
        String line;
        String[] info;
        FileInputStream fis;
        BufferedInputStream bis;
        DataInputStream dis;
        City c1 = null;
        try {
            fis = new FileInputStream(cityFile);

            // Here BufferedInputStream is added for fast reading.
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            // dis.available() returns 0 if the file does not have more lines.
            line = dis.readLine(); //reads line from file
            info = line.split(" ~"); //finds zipCode, state, and cityName separated by space

            c1 = new City(info[0], info[1]); //constructs city object based on array

            // dispose all the resources after using them.
            fis.close();
            bis.close();
            dis.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            // if the file is empty or corrupted, set Spokane as the preferred city
            c1 = new City("Washington", "Spokane");
        } catch (IOException e) {
            System.out.println("File input output error...");
            c1 = new City("Washington", "Spokane");
        }

        return c1;
    }

    public BufferedImage getBackgroundImage(String weatherCondition) {
        //String fileName = "resources/images/";
        Random rand = new Random();
        File weatherFile = null;

        Set<String> keywords = imageFiles.keySet();
        Iterator it = keywords.iterator();
        boolean containsValue = false;
        String weatherComparator;
        while (it.hasNext() && !containsValue && weatherCondition != null) {
            weatherComparator = it.next().toString();
            if (weatherCondition.contains(weatherComparator)) {
                //get a random number between the first and last element of the array in the map
                int fileSelection = rand.nextInt(imageFiles.get(weatherComparator).length-1)+1;
                File[] files = imageFiles.get(weatherComparator);
                weatherFile = files[fileSelection];
                containsValue = true;
            }
        }

        if (!containsValue) {
            weatherFile = new File("resources/images/clouds/cloudy_planes.jpeg");
        }
        
        BufferedImage image = null;
        
        try {
            image = ImageIO.read(weatherFile);
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return image;
    }
}
