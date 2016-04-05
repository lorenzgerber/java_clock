/**
 *
 * File:    Alarm.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */

public class Alarm extends Clock {

    private NumberDisplay alarmHours;
    private NumberDisplay alarmMinutes;
    private Boolean alarmStatus;

    public Alarm(){

        super();

        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0,59);

        // if nothing chosen, initialize alarm to 00:00
        this.alarmHours.setValue(0);
        this.alarmMinutes.setValue(0);
        this.alarmStatus = false;


    }

    public Alarm(int hours, int minutes){

        super(hours, minutes);

        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0,59);

        // if nothing chosen, initialize alarm to 00:00
        this.alarmHours.setValue(0);
        this.alarmMinutes.setValue(0);
        this.alarmStatus = false;


    }

    public Alarm(int hours, int minutes, int alarmHours, int alarmMinutes){

        super(hours, minutes);

        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0, 59);

        this.alarmHours.setValue(alarmHours);
        this.alarmMinutes.setValue(alarmMinutes);
        this.alarmStatus = true;

    }

    public void alarmSet(int alarmHours, int alarmMinutes){

        this.alarmHours.setValue(alarmHours);
        this.alarmMinutes.setValue(alarmMinutes);
        this.alarmStatus = true;

        // make sure the alarm goes also when it is set
        // to current time
        this.setTime(this.hours.getValue(),this.minutes.getValue()-1);
        this.timeTick();

    }

    public void alarmOn(){
        this.alarmStatus = true;

    }

    public void alarmOff(){
        this.alarmStatus = false;

    }

    private boolean checkAlarm(){

        if(this.alarmHours.getValue() == this.hours.getValue() &&
                this.alarmMinutes.getValue() == this.minutes.getValue()){
            return true;

        } else {
            return false;
        }
    }

    @Override
    public void timeTick(){

        this.minutes.increment();
        if(this.minutes.didWrapAround()){
            this.hours.increment();
        }

        if(this.checkAlarm() && this.alarmStatus){
            System.out.println("ALARM");
        }

    }

    @Override
    public void setTime(int hours, int minutes){
        // make sure alarm goes also when time is set on current alarm time
        this.hours.setValue(hours);
        this.minutes.setValue(minutes-1);
        this.timeTick();

    }


}
