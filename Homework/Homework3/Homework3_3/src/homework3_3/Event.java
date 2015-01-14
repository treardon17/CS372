/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework3_3;

/**
 *
 * @author tylerreardon
 */
public class Event {
    private String _name, _location, _month, _date, _year;
   
    public Event(String name, String location, String month, String date, String year){
        _name = name;
        _location = location;
        _month = month;
        _date = date;
        _year = year;
    }
    
    public String getName(){
        return _name;
    }
    
    public String getLocation(){
        return _location;
    }
    
    public String getMonth(){
        return _month;
    }
    
    public String getDate(){
        return _date;   
    }
    
    public String getYear(){
        return _year;
    }

    public String format(){
      String summary = _name + "~ " + _location + "~ " + _month + "/" + _date + "/" + _year + "\n";
      return summary;
    }
    
}
