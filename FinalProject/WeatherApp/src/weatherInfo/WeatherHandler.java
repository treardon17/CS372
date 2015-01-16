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

    private WeatherInfo weatherInfo = new WeatherInfo();

    private String type;
    private String maxTemp;
    private String minTemp;
    private String data;
    private boolean maxTempB = false;
    private boolean minTempB = false;
    private boolean rtmaTempB = false;

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("temperature")) {

            type = attributes.getValue("type");

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
            if (qName.equals("value") && maxTempB && !data.equals("")) {
                weatherInfo.addMaxTemp(Double.parseDouble(data));
            } else if (qName.equals("value") && minTempB && !data.equals("")) {
                weatherInfo.addMinTemp(Double.parseDouble(data));
            } else if (qName.equals("value") && rtmaTempB && !data.equals("")) {
                weatherInfo.addCurrentTemp(Double.parseDouble(data));
            }

            if (qName.equals("temperature")) {
                rtmaTempB = false;
            }
        } catch (Exception e) {
            //System.out.printf("%s\n", e.getMessage());
        }
    }

}
