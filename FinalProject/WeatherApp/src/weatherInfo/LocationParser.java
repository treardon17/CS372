/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import weatherapp.City;
import weatherapp.FileIO;

/**
 * Finds current location by public IP address
 * @author tylerreardon
 */
public class LocationParser {

    FileIO file = new FileIO();
    CurrentLocationHandler cLhandler = new CurrentLocationHandler();
    City city = new City();
    InetAddress IPaddress;
    String IPString;
    String URLString;

    /**
     * Constructs url to find current city
     * @throws UnknownHostException
     * @throws MalformedURLException
     * @throws IOException 
     */
    public LocationParser() throws UnknownHostException, MalformedURLException, IOException {

        //find current public IP address from this website
        URL whatismyip = new URL("http://checkip.amazonaws.com");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            IPString = in.readLine();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //append the IP address to this url
        this.URLString = "http://freegeoip.net/xml/" + IPString;

        
        //parse through this url to get city name and state name
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            URL IPURL = new URL(URLString);

            parser.parse(IPURL.openStream(), cLhandler);
            city.setCityName(cLhandler.getCityName());
            city.setState(cLhandler.getStateName());

            //set the preferred city to the current location
            file.setPreferredCity(city);
            
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(LocationParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Server error\n");
            System.out.printf("%s\n", ex.getMessage());
        }
    }

    /**
     * Allows access to city object made
     * @return city object from parsing
     */
    public City getCity() {
        return city;
    }

}
