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

        // if nothing chosen, initialize alarm to 00:00
        this.alarmHours.setValue(0);
        this.alarmMinutes.setValue(0);
        this.alarmStatus = false;


    }

    /**
     * Constructor for alarm clock class Alarm
     * This constructor allows setting just the clock.
     * Alarm will be att 00:00 off state.
     * @param hours
     * @param minutes
     */
    public Alarm(int hours, int minutes)
    {

        super(hours, minutes);

        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0,59);

        // if nothing chosen, initialize alarm to 00:00
        this.alarmHours.setValue(0);
        this.alarmMinutes.setValue(0);
        this.alarmStatus = false;


    }

    /**
     * This constructor allows setting both clock and alarm. The alarm
     * will be in state on.
     * @param hours
     * @param minutes
     * @param alarmHours
     * @param alarmMinutes
     * @throws IllegalArgumentException
     */
    public Alarm(int hours, int minutes, int alarmHours, int alarmMinutes)
    throws IllegalArgumentException
    {

        super(hours, minutes);


        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0, 59);

        if(alarmHours > 23 || alarmHours < 0)
        {
            throw new IllegalArgumentException("arg alarmHours out of range");
        }

        this.alarmHours.setValue(alarmHours);

        if(alarmMinutes > 59 || alarmMinutes < 0)
        {
            throw new IllegalArgumentException("arg alarmMinutes out of range");
        }

        this.alarmMinutes.setValue(alarmMinutes);
        this.alarmStatus = true;

    }

    /**
     * Setter method for alarm time. Alarm will produce output to
     * stdout if the alarm is set to the current time.
     * @param alarmHours
     * @param alarmMinutes
     * @throws IllegalArgumentException
     */
    public void alarmSet(int alarmHours, int alarmMinutes)
    throws IllegalArgumentException
    {

        if(alarmHours > 23 || alarmHours < 0)
        {
            throw new IllegalArgumentException("arg alarmHours out of range");
        }
        this.alarmHours.setValue(alarmHours);

        if(alarmMinutes > 59 || alarmMinutes < 0)
        {
            throw new IllegalArgumentException("arg alarmMinutes out of range");
        }

        this.alarmMinutes.setValue(alarmMinutes);
        this.alarmStatus = true;

        // make sure the alarm goes also when it is set
        // to current time
        this.setTime(this.hours.getValue(),this.minutes.getValue()-1);
        this.timeTick();

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
     * @return boolean
     */
    private boolean checkAlarm()
    {
        if(this.alarmHours.getValue() == this.hours.getValue() &&
                this.alarmMinutes.getValue() == this.minutes.getValue())
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

        this.minutes.increment();
        if(this.minutes.didWrapAround())
        {
            this.hours.increment();
        }

        if(this.checkAlarm() && this.alarmStatus)
        {
            System.out.println("alarm");
        }

    }

    /**
     * Setter method for clock. Will produce an alarm when clock is set
     * to an alarm time and alarm is in on state
     * @param hours
     * @param minutes
     */
    @Override
    public void setTime(int hours, int minutes)
    {
        // make sure alarm goes also when time is set on current alarm time
        if(hours > 23 || hours < 0)
        {
            throw new IllegalArgumentException("arg alarmHours out of range");
        }
        this.hours.setValue(hours);

        if(hours > 23 || hours < 0)
        {
            throw new IllegalArgumentException("arg alarmHours out of range");
        }
        this.minutes.setValue(minutes-1);
        this.timeTick();

    }


}
