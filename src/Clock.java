/**
 *
 * File:    Clock.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */

/**
 * A class to implement a digital clock with one numberDisplay
 * class object for hours and one for minutes.
 */
public class Clock
{

    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;

    /**
     * Constructor for Clock class
     *
     * Number displays are initiated
     * to 0-23 for hours and 0-59 for minutes ranges.
     */
    public Clock()
    {

        this.hours = new NumberDisplay(0,23);
        this.minutes = new NumberDisplay(0,59);

    }


    /**
     * Constructor for Clock class
     *
     * @param hours
     * @param minutes
     * @throws IllegalArgumentException
     */
    public Clock(int hours, int minutes)
    throws IllegalArgumentException
    {
        this.hours = new NumberDisplay(0,23);
        this.minutes = new NumberDisplay(0, 59);

        this.setTime(hours, minutes);


    }


    /**
     * getter/accessor for hours value
     *
     * @return hours as value
     */
    public int getHours(){
        return this.hours.getValue();
    }

    /**
     * getter/accessor for minutes value
     *
     * @return minutes as value
     */
    public int getMinutes(){
        return this.minutes.getValue();
    }



    /**
     * Method to advance the time by one minute
     * Will check for minutes wrap around. In case
     * of wrap around, it will increase hours by 1
     *
     */
    public void timeTick()
    {

        this.minutes.increment();

        if(this.minutes.didWrapAround())
        {
            this.hours.increment();
        }
    }

    /**
     * method to set the time
     *
     * @param hours
     * @param minutes
     * @throws IllegalArgumentException
     */
    public void setTime(int hours, int minutes)
    {

        try
        {
            this.hours.setValue(hours);
        } catch(IllegalArgumentException e)
        {
            System.out.println("wrong hours argument input range");
            System.out.println(e.getMessage());
        }

        try
        {
            this.minutes.setValue(minutes);
        } catch(IllegalArgumentException e)
        {
            System.out.println("wrong minutes argument input range");
            System.out.println(e.getMessage());
        }

    }

    /**
     * method that writes the time to stdout
     *
     * @return String
     */
    public String getTime()
    {
        this.updateDisplay();
        return this.displayString;
    }

    /**
     * method to update the displayString attribute
     * only for internal use
     */
    private void updateDisplay()
    {

        StringBuilder displayAssembly = new StringBuilder();
        
        displayAssembly.append(this.hours.getDisplayValue());
        displayAssembly.append(":");
        displayAssembly.append(this.minutes.getDisplayValue());

        this.displayString = displayAssembly.toString();

    }


}
