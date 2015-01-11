/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

/**
 *
 * @author tylerreardon
 */
public class City {
    String _pointNumber;
    String _state;
    String _cityName;
    
    public City(String pointNumber, String state, String cityName){
        _pointNumber = pointNumber;
        _state = state;
        _cityName = cityName;
    }
    
    public String getPointNumber(){
        return _pointNumber;
    }
    
    public String getState(){
        return _state;
    }
    
    public String getCityName(){
        return _cityName;
    }
}
