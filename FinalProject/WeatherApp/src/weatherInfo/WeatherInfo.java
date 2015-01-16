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
    
    public void addMaxTemp(double maxTemp){
        maxTemps.add(maxTemp);
    }
    
    public void addMinTemp(double minTemp){
        minTemps.add(minTemp);
    }
    
    public void addCurrentTemp(double currentTemp){
        currentTemps.add(currentTemp);
    }
    
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
    
}
