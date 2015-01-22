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
 *
 * @author tylerreardon
 */
public class LocationParser {

    FileIO file = new FileIO();
    CurrentLocationHandler cLHandler = new CurrentLocationHandler();
    City city = new City();
    InetAddress IPaddress;
    String IPString;
    String URLString;

    public LocationParser() throws UnknownHostException, MalformedURLException, IOException {

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

        //IPaddress = InetAddress.getLocalHost();
        //IPString = IPaddress.toString();
        //IPString = IPString.replaceAll("[^0-9.]", ""); //removes all characters from string
        this.URLString = "http://freegeoip.net/xml/" + IPString;

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            URL IPURL = new URL(URLString);

            parser.parse(IPURL.openStream(), cLHandler);
            this.city.setCityName(cLHandler.getCityName());
            this.city.setState(cLHandler.getStateName());

            file.setPreferredCity(city);
            
        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(LocationParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Server error\n");
            System.out.printf("%s\n", ex.getMessage());
        }
    }

    public City getCity() {
        return city;
    }

}
