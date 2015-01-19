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
    private String _URLString2 = new String();

    public Parser(String zipcode) throws MalformedURLException, IOException, SAXException, ParserConfigurationException {
        try {
            _URLString = "http://graphical.weather.gov/xml/SOAP_server/ndfdXMLclient.php?whichClient=NDFDgenMultiZip"
                    + "Code&lat=&lon=&listLatLon=&lat1=&lon1=&lat2=&lon2=&resolutionSub=&listLat1=&listLon1=&listLat2="
                    + "&listLon2=&resolutionList=&endPoint1Lat=&endPoint1Lon=&endPoint2Lat=&endPoint2Lon=&listEndPoint"
                    + "1Lat=&listEndPoint1Lon=&listEndPoint2Lat=&listEndPoint2Lon=&zipCodeList=" + zipcode + "&listZipCodeList=&"
                    + "centerPointLat=&centerPointLon=&distanceLat=&distanceLon=&resolutionSquare=&listCenterPointLat=&"
                    + "listCenterPointLon=&listDistanceLat=&listDistanceLon=&listResolutionSquare=&citiesLevel=&listCit"
                    + "iesLevel=&sector=&gmlListLatLon=&featureType=&requestedTime=&startTime=&endTime=&compType=&proper"
                    + "tyName=&product=time-series&begin=2004-01-01T00%3A00%3A00&end=2019-01-17T00%3A00%3A00&Unit=e&maxt"
                    + "=maxt&mint=mint&snow=snow&wx=wx&appt=appt&precipa_r=precipa_r&sky_r=sky_r&temp_r=temp_r&wdir_r=wd"
                    + "ir_r&wspd_r=wspd_r&wwa=wwa&Submit=Submit";

            /*_URLString2 = "http://graphical.weather.gov/xml/SOAP_server/ndfdXMLclient.php?whichClient=NDFDgenMultiZip"
                    + "Code&lat=&lon=&listLatLon=&lat1=&lon1=&lat2=&lon2=&resolutionSub=&listLat1=&listLon1=&listLat2=&"
                    + "listLon2=&resolutionList=&endPoint1Lat=&endPoint1Lon=&endPoint2Lat=&endPoint2Lon=&listEndPoint1La"
                    + "t=&listEndPoint1Lon=&listEndPoint2Lat=&listEndPoint2Lon=&zipCodeList=" + zipcode + "&listZipCodeList=&cente"
                    + "rPointLat=&centerPointLon=&distanceLat=&distanceLon=&resolutionSquare=&listCenterPointLat=&listCen"
                    + "terPointLon=&listDistanceLat=&listDistanceLon=&listResolutionSquare=&citiesLevel=&listCitiesLevel="
                    + "&sector=&gmlListLatLon=&featureType=&requestedTime=&startTime=&endTime=&compType=&propertyName=&pro"
                    + "duct=glance&begin=2004-01-01T00%3A00%3A00&end=2019-01-18T00%3A00%3A00&Unit=e&maxt=maxt&mint=mint&sn"
                    + "ow=snow&sky=sky&wx=wx&precipa_r=precipa_r&temp_r=temp_r&wspd_r=wspd_r&Submit=Submit";*/

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            URL weatherURL = new URL(_URLString);
            //URL weatherDayConditionURL = new URL(_URLString2);

            parser.parse(weatherURL.openStream(), whandler);
            //parser.parse(weatherDayConditionURL.openStream(), whandler);

            _weatherInfo = whandler.getWeatherInfo();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.printf("%s", e.getMessage());
        }
    }

    /**
     * Gets weather info from the handler and allows access in other classes
     *
     * @return weather information to be displayed
     */
    public WeatherInfo getWeatherInfo() {
        return _weatherInfo;
    }
}
