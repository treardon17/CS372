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
    String _zipCode;
    String _state;
    String _cityName;
    
    public City(String zipCode, String state, String cityName){
        _zipCode = zipCode;
        _state = state;
        _cityName = cityName;
    }
    
    public String getZipCode(){
        return _zipCode;
    }
    
    public String getState(){
        return _state;
    }
    
    public String getCityName(){
        return _cityName;
    }
}