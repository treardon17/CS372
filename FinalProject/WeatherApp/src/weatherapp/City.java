/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.Comparator;

/**
 *
 * @author tylerreardon
 */
public class City {
    private String _zipCode;
    private String _state;
    private String _cityName;
    
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
    
     public void setZipCode(String zipCode){
        _zipCode = zipCode;
    }
    
    public void setState(String state){
        _state = state;
    }
    
    public void setCityName(String cityName){
        _cityName = cityName;
    }
    
    public static Comparator<City> CityComparator = new Comparator<City>(){
        
        @Override
        public int compare(City c1, City c2){
            int cmp = c1.getCityName().compareTo(c2.getCityName());
            return cmp;
        }
    };
}
