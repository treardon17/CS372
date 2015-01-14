/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapp;
import java.util.*;
/**
 *
 * @author tylerreardon
 */
public class WeatherInfo {
    private ArrayList<Integer> maxTemps = new ArrayList();
    private ArrayList<Integer> minTemps = new ArrayList();
    
    public void addMaxTemp(int maxTemp){
        maxTemps.add(maxTemp);
    }
    
    public void addMinTemp(int minTemp){
        minTemps.add(minTemp);
    }
    
    public ArrayList<Integer> getMaxTemps(){
        return maxTemps;
    }
    
    public ArrayList<Integer> getMinTemps(){
        return minTemps;
    }
    
}
