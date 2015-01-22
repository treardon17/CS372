/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.*;
import org.xml.sax.*;

/**
 * Constructs url used to obtain weather information
 * @author tylerreardon
 */
public class WeatherParser {

    private CurrentWeatherHandler cWhandler = new CurrentWeatherHandler();
    private Map<String,ArrayList<Hour>> _weatherInfo = new HashMap<>();
    private String forecastString = new String();

    /**
     * 
     * @param state
     * @param cityName
     * @throws MalformedURLException
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException 
     */
    public WeatherParser(String state, String cityName) throws MalformedURLException, IOException, SAXException, ParserConfigurationException {
        try {
            forecastString = "http://api.openweathermap.org/data/2.5/forecast?q="+cityName+","+state+"&mode=xml&units=imperial&APPID=4b55385bebda5f273b763dafa99745c7";

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            URL forecastURL = new URL(forecastString);
            
            
            parser.parse(forecastURL.openStream(), cWhandler);
            _weatherInfo = cWhandler.getWeatherInfo();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.printf("%s", e.getMessage());
        }
    }

    /**
     * Gets weather info from the handler and allows access in other classes
     *
     * @return weather information to be displayed
     */
    public Map getWeatherInfo() {
        return _weatherInfo;
    }
}
