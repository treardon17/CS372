/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherInfo;

/**
 *
 * @author tylerreardon
 */
public class Hour {
    private String temperature;
    private String dayMinTemp;
    private String dayMaxTemp;
    private String humidity;
    private String windSpeed;
    private String windDescr;
    private String windDirection;
    private String weatherDescr;
    private String clouds;
      
    public Hour(){
        temperature = "N/A";
        dayMinTemp = "N/A";
        dayMaxTemp = "N/A";
        humidity = "N/A";
        windSpeed = "N/A";
        windDescr = "N/A";
        windDirection = "N/A";
        weatherDescr = "N/A";
        clouds = "N/A";
    }
    
    public void setTemp(String temperature){
        double d = Double.parseDouble(temperature);
        int i = (int)d;
        this.temperature = Integer.toString(i);
    }
    
    public void setDayMinTemp(String dayMinTemp){
        double d = Double.parseDouble(dayMinTemp);
        int i = (int)d;
        this.dayMinTemp = Integer.toString(i);
    }
    
    public void setDayMaxTemp(String dayMaxTemp){
        double d = Double.parseDouble(dayMaxTemp);
        int i = (int)d;
        this.dayMaxTemp = Integer.toString(i);
    }
    
    public void setHumidity(String humidity){
        this.humidity = humidity;
    }
    
    public void setWindSpeed(String windSpeed){
        double d = Double.parseDouble(windSpeed);
        int i = (int)d;
        this.windSpeed = Integer.toString(i);
    }
    
    public void setWindDescr(String windDescr){
        this.windDescr = windDescr;
    }
    
    public void setWindDirection(String windDirection){
        this.windDirection = windDirection;
    }
    
    public void setWeatherDescr(String weatherDescr){
        this.weatherDescr = weatherDescr;
    }
    
    public void setClouds(String clouds){
        this.clouds = clouds;
    }
    
    public String getTemp(){
        return temperature;
    }
    
    public String getDayMinTemp(){
        return dayMinTemp;
    }
    
    public String getDayMaxTemp(){
        return dayMaxTemp;
    }
    
    public String getHumidity(){
        return humidity;
    }
    
    public String getWindSpeed(){
        return windSpeed;
    }
    
    public String getWindDirection(){
        return windDirection;
    }
    
    public String getWeatherDescr(){
        return weatherDescr;
    }
    
    public String getClouds(){
      return clouds;  
    }
 
}
