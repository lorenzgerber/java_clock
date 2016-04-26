/**
 *
 * File:    Alarm.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */

/**
 * Sub class of 'Clock' with the additional functionality
 * of an alarm
 */
public class Alarm extends Clock
{

    private NumberDisplay alarmHours;
    private NumberDisplay alarmMinutes;
    private Boolean alarmStatus;

    /**
     * Constructor for alarm clock class Alarm
     * This constructor will set both clock and
     * alarm to 00:00, alarm state off.
     */
    public Alarm()
    {

        super();

        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0,59);
        this.alarmStatus = false;

    }

    /**
     * Constructor for alarm clock class Alarm
     * This constructor allows setting just the clock.
     * Alarm will be att 00:00 off state.
     *
     * @param hours
     * @param minutes
     */
    public Alarm(int hours, int minutes)
    {

        super(hours, minutes);

        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0,59);
        this.alarmStatus = false;

    }

    /**
     * This constructor allows setting both clock and alarm. The alarm
     * will be in state on.
     *
     * @param hours
     * @param minutes
     * @param alarmHours
     * @param alarmMinutes
     * @throws IllegalArgumentException
     */
    public Alarm(int hours, int minutes, int alarmHours, int alarmMinutes)
    {

        super(hours, minutes);

        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0, 59);
        this.alarmSet(alarmHours, alarmMinutes);
        this.alarmStatus = true;

    }

    /**
     * Setter method for alarm time. Alarm will produce output to
     * stdout if the alarm is set to the current time.
     *
     * @param alarmHours
     * @param alarmMinutes
     * @throws IllegalArgumentException
     */
    public void alarmSet(int alarmHours, int alarmMinutes)
    {
        try
        {
            this.alarmHours.setValue(alarmHours);
        } catch(IllegalArgumentException e)
        {
            System.out.println("wrong alarmHours argument input range");
            System.out.println(e.getMessage());
        }

        try
        {
            this.alarmMinutes.setValue(alarmMinutes);
        } catch(IllegalArgumentException e)
        {
            System.out.println("wrong alarmMinutes argument input range");
            System.out.println(e.getMessage());
        }

        this.alarmStatus = true;
    }

    /**
     * Method to switch on alarm
     */
    public void alarmOn()
    {
        this.alarmStatus = true;
    }

    /**
     * method to switch off alarm
     */
    public void alarmOff()
    {
        this.alarmStatus = false;
    }

    /**
     * internal method that checks if clock and alarm time match
     *
     * @return boolean
     */
    private boolean checkAlarm()
    {
        if(this.alarmHours.getValue() == this.getHours() &&
                this.alarmMinutes.getValue() == this.getMinutes())
        {
            return true;

        } else
        {
            return false;
        }
    }

    /**
     * method to increment the time one minute
     * will output 'alarm' to stdout if clock and alarm match
     */
    @Override
    public void timeTick()
    {

        super.timeTick();

        if (this.checkAlarm() && this.alarmStatus)
        {
            System.out.println("alarm");
        }

    }




}
