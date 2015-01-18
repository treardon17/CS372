/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

/**
 *
 * @author tylerreardon
 */
public class WeatherHandler extends DefaultHandler {

    private final WeatherInfo weatherInfo = new WeatherInfo();

    private String type;
    private String maxTemp;
    private String minTemp;
    private String data;
    private String coverage;
    private String intensity;
    private String weatherType;
    private boolean maxTempB = false;
    private boolean minTempB = false;
    private boolean rtmaTempB = false;
    private boolean wCondB = false;

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        type = attributes.getValue("type");
        if (qName.equals("temperature")) { 
            if (type.equals("maximum")) {
                maxTempB = true;
                minTempB = rtmaTempB = false;
            } else if (type.equals("minimum")) {
                minTempB = true;
                maxTempB = rtmaTempB = false;
            } else if (type.equals("rtma-hourly")) {
                rtmaTempB = true;
                maxTempB = minTempB = false;
            }
        }else if (qName.equals("weather-conditions")){  
            wCondB = true;
        }
        
        if (qName.equals("value") && wCondB){
            coverage = attributes.getValue("coverage");
            intensity = attributes.getValue("intensity");
            weatherType = attributes.getValue("weather-type");
            WeatherCondition weatherCondition = new WeatherCondition (coverage, intensity, weatherType);
            weatherInfo.addWeatherCondition(weatherCondition);
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
            if (qName.equals("value") && maxTempB && !data.trim().equals("")) {
                weatherInfo.addMaxTemp(Double.parseDouble(data));
            }else if (qName.equals("value") && minTempB && !data.trim().equals("")) {
                weatherInfo.addMinTemp(Double.parseDouble(data));
            }else if (qName.equals("value") && rtmaTempB && !data.trim().equals("")) {
                weatherInfo.addCurrentTemp(Double.parseDouble(data));
            }else if (qName.equals("temperature")) {
                rtmaTempB = false;
            }else if (qName.equals("weather-conditions")){
                wCondB = false;
            }
 
        } catch (Exception e) {
            //System.out.printf("%s\n", e.getMessage());
        }
    }

}
