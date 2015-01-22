/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

/**
 * Gets the weather information from openweathermaps.org
 * @author tylerreardon
 */
public class CurrentWeatherHandler extends DefaultHandler {

    Map<String, ArrayList<Hour>> weatherInfo = new HashMap<>();
    private String currentDate = "";
    private String compareDate = "";
    private String sunrise = "";
    private String sunset = "";
    private boolean newHour = false;
    private boolean updateHour = false;
    int index = 0;
    String data;
    
    /**
     * Allows access to the weather information found
     * @return 
     */
    public Map getWeatherInfo() {
        return weatherInfo;
    }

    /**
     * Gets the weather information
     * @param uri
     * @param localName
     * @param qName
     * @param attributes 
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        
        //For getting the sunrise and sunset times...
        if (qName.equals("sun")){
            
        }
        
        //Get a unique date
        if (qName.equals("time") && !newHour && !updateHour) {
            newHour = true;
            currentDate = attributes.getValue("from");
            currentDate = currentDate.substring(0, Math.min(currentDate.length(), 10));
            if (!currentDate.equals(compareDate)) {
                ArrayList<Hour> hours = new ArrayList<>();
                weatherInfo.put(currentDate, hours);
                compareDate = attributes.getValue("from");
                compareDate = compareDate.substring(0, Math.min(compareDate.length(), 10));
                index = 0;
            }
        }
        
        //Gets all of the available weather information for the hours of that unique date
        if (newHour) {
            if (weatherInfo.get(currentDate).size() != 0) { //don't forget to add an hour to the first element of the Hour arraylist
                index++;
            }
            Hour hour = new Hour();
            weatherInfo.get(currentDate).add(hour);
            updateHour = true;
        }
        
        //If there is another hour, then add the weather information
        if (updateHour) {

            //Gets description of weather
            //Adds description to an Hour object at the specified index of an Hour array, which is a value found by the current date
            if (qName.equals("symbol")) {
                weatherInfo.get(currentDate).get(index).setWeatherDescr(attributes.getValue("name"));
            }
            //Gets the direction of the wind
            else if (qName.equals("windDirection")) {
                weatherInfo.get(currentDate).get(index).setWindDirection(attributes.getValue("name"));
            }
            //Gets the speed of the wind and its units
            else if (qName.equals("windSpeed")) {
                weatherInfo.get(currentDate).get(index).setWindSpeed(attributes.getValue("mps"));
                weatherInfo.get(currentDate).get(index).setWindDescr(attributes.getValue("name"));
            }
            //Gets the current temperature, the max, and the min
            else if (qName.equals("temperature")) {
                weatherInfo.get(currentDate).get(index).setTemp(attributes.getValue("value"));
                weatherInfo.get(currentDate).get(index).setDayMinTemp(attributes.getValue("min"));
                weatherInfo.get(currentDate).get(index).setDayMaxTemp(attributes.getValue("max"));
            }
            //Gets the current humidity
            else if (qName.equals("humidity")) {
                weatherInfo.get(currentDate).get(index).setHumidity(attributes.getValue("value") + attributes.getValue("unit"));
            }
            //Gets the cloud cover
            else if (qName.equals("clouds")) {
                weatherInfo.get(currentDate).get(index).setClouds(attributes.getValue("value") + " " + attributes.getValue("all") + attributes.getValue("unit"));
            }
            newHour = false;

        }
        data = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data = data + new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        try {
            if (qName.equals("time")) {
                updateHour = false;
            }
        } catch (Exception e) {
            //System.out.printf("%s\n", e.getMessage());
        }
    }
}
