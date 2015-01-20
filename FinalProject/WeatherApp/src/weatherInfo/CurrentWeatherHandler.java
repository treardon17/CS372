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
 *
 * @author tylerreardon
 */
public class CurrentWeatherHandler extends DefaultHandler {

    Map<String, ArrayList<Hour>> weatherInfo = new HashMap<>();
    private String currentDate = "";
    private String compareDate = "";
    private boolean newHour = false;
    private boolean updateHour = false;
    int index = 0;
    String data;

    public Map getWeatherInfo() {
        return weatherInfo;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
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
        if (newHour) {
            if (weatherInfo.get(currentDate).size() != 0) {
                index++;
            }
            Hour hour = new Hour();
            weatherInfo.get(currentDate).add(hour);
            updateHour = true;

        }
        if (updateHour) {

            if (qName.equals("symbol")) {
                weatherInfo.get(currentDate).get(index).setWeatherDescr(attributes.getValue("name"));
            }
            else if (qName.equals("windDirection")) {
                weatherInfo.get(currentDate).get(index).setWindDirection(attributes.getValue("name"));
            }
            else if (qName.equals("windSpeed")) {
                weatherInfo.get(currentDate).get(index).setWindSpeed(attributes.getValue("mps"));
                weatherInfo.get(currentDate).get(index).setWindDescr(attributes.getValue("name"));
            }
            else if (qName.equals("temperature")) {
                weatherInfo.get(currentDate).get(index).setTemp(attributes.getValue("value"));
                weatherInfo.get(currentDate).get(index).setDayMinTemp(attributes.getValue("min"));
                weatherInfo.get(currentDate).get(index).setDayMaxTemp(attributes.getValue("max"));
            }
            else if (qName.equals("humidity")) {
                weatherInfo.get(currentDate).get(index).setHumidity(attributes.getValue("value") + attributes.getValue("unit"));
            }
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
