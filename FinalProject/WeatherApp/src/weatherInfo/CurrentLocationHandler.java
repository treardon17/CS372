/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Gets the cityName and stateName from freegoip.net
 * @author tylerreardon
 */
public class CurrentLocationHandler extends DefaultHandler{
    String cityName;
    String stateName;
    String data;
    
    /**
     * Allows access to the cityName that was found
     * @return the name of the city
     */
    public String getCityName(){
        return cityName;
    }
    
    /**
     * Allows access to the stateName that was found
     * @return the name of the state
     */
    public String getStateName(){
        return stateName;
    }

    /**
     * Resets the data when new element is found
     * @param uri
     * @param localName
     * @param qName
     * @param attributes 
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data = "";
    }

    /**
     * Gathers the data
     * @param ch
     * @param start
     * @param length 
     */
    @Override
    public void characters(char[] ch, int start, int length) {
        data = data + new String(ch, start, length);
    }

    /**
     * Stores the data
     * @param uri
     * @param localName
     * @param qName 
     */
    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("RegionName")){
            stateName = data;
        }else if (qName.equals("City")){
            cityName = data;
        }
    }
}
