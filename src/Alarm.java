/**
 * Created by loge on 04/04/16.
 */
public class Alarm extends Clock {

    NumberDisplay alarmHours;
    NumberDisplay alarmMinutes;
    Boolean alarmStatus;

    public Alarm(){

        super();

    }

    public Alarm(int hours, int minutes){

        super(hours, minutes);

        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0,59);

        // if nothing chosen, initialize alarm to 00:00
        this.alarmHours.setValue(0);
        this.alarmMinutes.setValue(0);


    }

    public Alarm(int hours, int minutes, int alarmHours, int alarmMinutes){

        super(hours, minutes);

        this.alarmHours = new NumberDisplay(0, 23);
        this.alarmMinutes = new NumberDisplay(0, 59);

        this.alarmHours.setValue(alarmHours);
        this.alarmMinutes.setValue(alarmMinutes);

    }

    public void alarmSet(int alarmHours, int alarmMinutes){

        this.alarmHours.setValue(alarmHours);
        this.alarmMinutes.setValue(alarmMinutes);

    }

    public void alarmOn(){
        this.alarmStatus = true;

    }

    public void alarmOff(){
        this.alarmStatus = false;

    }

    private boolean checkAlarm(){

        return true;
    }





}
