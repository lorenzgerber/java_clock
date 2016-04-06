/**
 *
 * File:    AlarmTest.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */


import org.junit.Test;


public class AlarmTest
{
    @Test
    public void shouldBeAbleToCreateAlarm() throws Exception
    {
        new Alarm();
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowExceptionIfWrongAlarmInputRange() throws Exception
    {
        new Alarm(10,10,30,10);
        new Alarm(10,10,10,80);

    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowExceptionIfSetAlarmOutOfRange() throws Exception
    {
        Alarm myAlarm;
        myAlarm = new Alarm();
        myAlarm.alarmSet(10,100);
        myAlarm.alarmSet(100,10);

    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowExceptionIfWrongTimeInputRange() throws Exception
    {
        Alarm myAlarm;
        myAlarm = new Alarm();
        myAlarm.setTime(10,100);
        myAlarm.setTime(100,10);
    }

}
