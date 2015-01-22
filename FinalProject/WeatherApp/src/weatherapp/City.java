/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import weatherInfo.Hour;
import weatherInfo.LocationParser;
import weatherInfo.WeatherParser;

/**
 * Contains all the information required for a city
 * @author tylerreardon
 */
public class City {
    private static Map<String, ArrayList<Hour>> _weatherInfo = new HashMap<>();
    private String _state;
    private String _cityName;
    
    /**
     * Create new city object
     * @param zipCode
     * @param state
     * @param cityName 
     */
    public City(String state, String cityName) throws IOException, MalformedURLException, SAXException, ParserConfigurationException{
        _state = state;
        _cityName = cityName;     
    }

    public City() {}
    
    
    /**
     * Get the state the city is in
     * @return state city is in
     */
    public String getState(){
        return _state;
    }
    
    /**
     * Get the name of the city
     * @return name of city
     */
    public String getCityName(){
        return _cityName;
    }
    

     /**
      * Sets the state
      * @param state 
      */
    public void setState(String state){
        _state = state;
    }
    
    /**
     * Sets the city name
     * @param cityName 
     */
    public void setCityName(String cityName){
        _cityName = cityName;
    }
    
    /**
     * Sets the weather info
     * @param weatherInfo 
     */
    public void setWeatherInfo(Map<String, ArrayList<Hour>> weatherInfo){
        _weatherInfo = weatherInfo;
    }
    
    /**
     * Finds the 
     * @return A Map of strings and hours
     * @throws java.io.IOException 
     * @throws java.net.MalformedURLException 
     * @throws org.xml.sax.SAXException 
     * @throws javax.xml.parsers.ParserConfigurationException 
     */
    public Map parseForWeather() throws IOException, MalformedURLException, SAXException, ParserConfigurationException{
        WeatherParser parse = new WeatherParser(_state,_cityName);        
        _weatherInfo = parse.getWeatherInfo();
        return _weatherInfo;
    }
 
    //Sorts cities alphabetically
    public static Comparator<City> CityComparator = new Comparator<City>(){
        
        @Override
        public int compare(City c1, City c2){
            int cmp = c1.getCityName().compareTo(c2.getCityName());
            return cmp;
        }
    };
}
