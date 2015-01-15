/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

import java.net.*;
import java.io.*;
import javax.swing.text.Document;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author tylerreardon
 */
public class Parser {

    private final WeatherHandler whandler = new WeatherHandler();
    private WeatherInfo _weatherInfo = new WeatherInfo();
    private String _URLString = new String();
    private final String _content = new String();
    private static Document _xmlDoc;

    public Parser(String zipcode) throws MalformedURLException, IOException, SAXException, ParserConfigurationException {
        try {
            _URLString = "http://graphical.weather.gov/xml/SOAP_server/ndfdXMLclient.php?whichClient=NDFDgenMultiZipCode&lat=&lon"
                    + "=&listLatLon=&lat1=&lon1=&lat2=&lon2=&resolutionSub=&listLat1=&listLon1=&listLat2=&listLon2=&resolutionList"
                    + "=&endPoint1Lat=&endPoint1Lon=&endPoint2Lat=&endPoint2Lon=&listEndPoint1Lat=&listEndPoint1Lon=&listEndPoint2"
                    + "Lat=&listEndPoint2Lon=&zipCodeList=" + zipcode + "&listZipCodeList=&centerPointLat=&centerPointLon=&distance"
                    + "Lat=&distanceLon=&resolutionSquare=&listCenterPointLat=&listCenterPointLon=&listDistanceLat=&listDistanceLon="
                    + "&listResolutionSquare=&citiesLevel=&listCitiesLevel=&sector=&gmlListLatLon=&featureType=&requestedTime=&start"
                    + "Time=&endTime=&compType=&propertyName=&product=time-series&begin=2004-01-01T00%3A00%3A00&end=2019-01-12T00%3A00"
                    + "%3A00&Unit=e&maxt=maxt&mint=mint&temp=temp&snow=snow&wx=wx&appt=appt&Submit=Submit";
            URL weatherURL = new URL(_URLString);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(weatherURL.openStream(), whandler);
            
            _weatherInfo = whandler.getWeatherInfo();
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.printf("%s", e.getMessage());
        }
    }

    /**
     * Gets weather info from the handler and allows access in other classes
     * @return weather information to be displayed
     */
    public WeatherInfo getWeatherInfo() {
        return _weatherInfo;
    }
}
