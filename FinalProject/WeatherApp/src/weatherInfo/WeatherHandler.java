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

    private WeatherInfo _weatherInfo = new WeatherInfo();

    private String _type;
    private String _maxTemp;
    private String _minTemp;
    private String _data;
    boolean _maxTempB = false;
    boolean _minTempB = false;
    boolean _hourTempB = false;

    public WeatherInfo getWeatherInfo() {
        return _weatherInfo;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals("temperature")) {

            _type = attributes.getValue("type");

            if (_type.equals("maximum")) {
                _maxTempB = true;
                _minTempB = _hourTempB = false;
            } else if (_type.equals("minimum")) {
                _minTempB = true;
                _maxTempB = _hourTempB = false;
            } else if (_type.equals("hourly")) {
                _hourTempB = true;
                _maxTempB = _minTempB = false;
            }
        }

        _data = "";

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        _data = _data + new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        try {
            if (qName.equals("value") && _maxTempB && !_data.equals("")) {
                _weatherInfo.addMaxTemp(Double.parseDouble(_data));
            } else if (qName.equals("value") && _minTempB && !_data.equals("")) {
                _weatherInfo.addMinTemp(Double.parseDouble(_data));
            } else if (qName.equals("value") && _hourTempB && !_data.equals("")) {
                _weatherInfo.addCurrentTemp(Double.parseDouble(_data));
            }
        } catch (Exception e) {
            System.out.printf("%s\n", e.getMessage());
        }
    }

}
