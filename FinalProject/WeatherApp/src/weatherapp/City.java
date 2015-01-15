/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;

import java.util.Comparator;

/**
 * Contains all the information required for a city
 * @author tylerreardon
 */
public class City {
    private String _zipCode;
    private String _state;
    private String _cityName;
    
    /**
     * Create new city object
     * @param zipCode
     * @param state
     * @param cityName 
     */
    public City(String zipCode, String state, String cityName){
        _zipCode = zipCode;
        _state = state;
        _cityName = cityName;
    }
    
    /**
     * Get the zipcode for the city
     * @return zipcode of city
     */
    public String getZipCode(){
        return _zipCode;
    }
    
    /**
     * Get the state the city is in
     * @return state city is in
     */
    public String getState(){
        return _state;
    }
    
    /**
     * Get the name of the city
     * @return name of city
     */
    public String getCityName(){
        return _cityName;
    }
    
    /**
     * Sets the zipcode
     * @param zipCode 
     */
     public void setZipCode(String zipCode){
        _zipCode = zipCode;
    }
    
     /**
      * Sets the state
      * @param state 
      */
    public void setState(String state){
        _state = state;
    }
    
    /**
     * Sets the city name
     * @param cityName 
     */
    public void setCityName(String cityName){
        _cityName = cityName;
    }
    
    //Sorts cities alphabetically
    public static Comparator<City> CityComparator = new Comparator<City>(){
        
        @Override
        public int compare(City c1, City c2){
            int cmp = c1.getCityName().compareTo(c2.getCityName());
            return cmp;
        }
    };
}
