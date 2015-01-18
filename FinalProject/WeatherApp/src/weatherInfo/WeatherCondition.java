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
public class WeatherCondition {

    private final String coverage;
    private final String intensity;
    private final String weatherType;

    public WeatherCondition(String coverage, String intensity, String weatherType) {
        this.coverage = coverage;
        this.intensity = intensity;
        this.weatherType = weatherType;
    }

    public String getCoverage() {
        return coverage;
    }

    public String getIntensity() {
        return intensity;
    }

    public String getWeatherType() {
        return weatherType;
    }

    @Override
    public String toString() {
        if (coverage.equals("patchy") && !intensity.equals("none")) {
            return "There is " + coverage + " " + weatherType;
        } else if (coverage.equals("slight chance") && !intensity.equals("none")) {
            return "There's a " + coverage + " of " + intensity + " " + weatherType;
        } else if (coverage.equals("definitely") && !intensity.equals("none")) {
            return "There's " + coverage + " going to be " + intensity + " " + weatherType;
        } else if (coverage.equals("slight chance") && !intensity.equals("none")) {
            return coverage + " of " + intensity + " " + weatherType;
        } else if(coverage.equals("likely") && !intensity.equals("none")){
            return "It is likely that there will be "+weatherType;
        }else{
            return "Weather Type: " + weatherType + ",\n" + "Coverage: " + coverage + ",\n" + "Intensity: " + intensity;
        }
    }
}
