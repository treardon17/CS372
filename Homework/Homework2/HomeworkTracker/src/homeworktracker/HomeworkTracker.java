/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeworktracker;
import java.util.*;
/**
 *
 * @author tylerreardon
 */
public class HomeworkTracker {
    //PT -- Do these need to be member variables? I don't think so
    double _max;
    double _min;
    double _average;
    
    /**
     * Takes a list of scores and finds the maximum value in the list
     * @param scoreList
     * @return <code>_max</code> which is the maximum value
     */
    public double findMax(List<Double> scoreList){
        _max = scoreList.get(0); //assumes the max is the first item in the list
        for (int i = 0; i<scoreList.size(); i++){
            if (scoreList.get(i)>_max){ //if the current item is larger...
                _max = scoreList.get(i); //then assign it to max
            }
        }
        return _max; //return the max value
    }
    /**
     * Takes a list of scores and finds the minimum value in the list
     * @param scoreList
     * @return <code>_min</code> which is the minimum value
     */
    public double findMin(List<Double> scoreList){ 
         _min = scoreList.get(0); //assumes the minimum value is the first item in the list
        for (int i = 0; i<scoreList.size(); i++){
            if (scoreList.get(i)<_min){ //if the current item is smaller...
                _min = scoreList.get(i); //then assign it to min
            }
        }
        return _min; //return the min value
    }
    /**
     * Takes a list of scores and finds the average value in the list
     * @param scoreList
     * @return <code>_average</code> which is the average value
     */
    public double findAverage(List<Double> scoreList){
        _average = 0;
        for (int i = 0; i<scoreList.size(); i++){
            _average += scoreList.get(i); //add up all scores in list
        }
        _average = _average/scoreList.size(); //divide by number of scores in list
        return _average; //return average value of list
    }
    
}
