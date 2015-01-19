/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;
import java.util.*;
/**
 *
 * @author tylerreardon
 */
public class WeatherInfo {
    private ArrayList<Double> maxTemps = new ArrayList();
    private ArrayList<Double> minTemps = new ArrayList();
    private ArrayList<Double> currentTemps = new ArrayList();
    private ArrayList<WeatherCondition> weatherConditions = new ArrayList();
    private Map<String,ArrayList<String>> timeLayout = new HashMap<>();
    
    public void addMaxTemp(double maxTemp){
        maxTemps.add(maxTemp);
    }
    
    public void addMinTemp(double minTemp){
        minTemps.add(minTemp);
    }
    
    public void addCurrentTemp(double currentTemp){
        currentTemps.add(currentTemp);
    }
    
    public void addWeatherCondition(WeatherCondition weatherCondition){
        weatherConditions.add(weatherCondition);
    }
    
    /*
    public void setTimeLayout(Map<String, ArrayList<String>> timeLayout){
        this.timeLayout = timeLayout;
    }
    */
    public ArrayList<Double> getMaxTemps(){
        return maxTemps;
    }
    
    public ArrayList<Double> getMinTemps(){
        return minTemps;
    }
    
    public ArrayList<Double> getCurrentTemps(){
       return currentTemps;
    }
    
    public double getCurrentTemp(){
        return currentTemps.get(currentTemps.size()-1);
    }
    
    public ArrayList<WeatherCondition> getWeatherConditions(){
        return weatherConditions;
    }
    
    /*
    public Map<String, ArrayList<String>> getTimeLayout(){
        return timeLayout;
    }
    */
}
