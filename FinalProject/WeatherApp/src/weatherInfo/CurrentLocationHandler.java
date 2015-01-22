/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import weatherapp.City;

/**
 *
 * @author tylerreardon
 */
public class CurrentLocationHandler extends DefaultHandler{
    String cityName;
    String stateName;
    String data;
    
    public String getCityName(){
        return cityName;
    }
    
    public String getStateName(){
        return stateName;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data = data + new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals("RegionName")){
            stateName = data;
        }else if (qName.equals("City")){
            cityName = data;
        }
    }
}
