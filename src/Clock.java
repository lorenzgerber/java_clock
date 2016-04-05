/**
 *
 * File:    Clock.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */

/**
 * A class to implement a digital clock with each a number display
 * for hours and minutes.
 */
public class Clock {

    protected NumberDisplay hours;
    protected NumberDisplay minutes;
    private String displayString;

    /**
     * Constructor for Clock class
     *
     * Number displays are initiated
     * to 0-23 for hours and 0-59 for minutes ranges.
     */
    public Clock(){

        this.hours = new NumberDisplay(0,23);
        this.minutes = new NumberDisplay(0,59);

    }


    /**
     *
     * Constructor for Clock class
     *
     * @param hours
     * @param minutes
     */
    public Clock(int hours, int minutes){
        this.hours = new NumberDisplay(0,23);
        this.minutes = new NumberDisplay(0, 59);

        this.hours.setValue(hours);
        this.minutes.setValue(minutes);

    }


    /**
     * method to advance the time by one minute
     *
     */
    public void timeTick(){

        this.minutes.increment();
        if(this.minutes.didWrapAround()){
            this.hours.increment();
        }


    }

    /**
     * method to set the time
     *
     * @param hours
     * @param minutes
     */
    public void setTime(int hours, int minutes){
        this.hours.setValue(hours);
        this.minutes.setValue(minutes);

    }

    /**
     * method that writes the time to stdout
     *
     * @return String
     */
    public String getTime(){
        this.updateDisplay();
        return this.displayString;
    }

    /**
     * method to update the displayString attribute
     */
    private void updateDisplay(){

        StringBuilder displayAssembly = new StringBuilder();
        
        if(this.hours.getValue()<10){
            displayAssembly.append("0");
        }

        displayAssembly.append(String.valueOf(this.hours.getDisplayValue()));

        displayAssembly.append(":");

        if(this.minutes.getValue()<10){
            displayAssembly.append("0");
        }

        displayAssembly.append(String.valueOf(this.minutes.getDisplayValue()));

        this.displayString = displayAssembly.toString();

    }



}
