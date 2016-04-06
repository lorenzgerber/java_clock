/**
 *
 * File:    ClockApp.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */

/**
 * Java Application that makes use of the
 * Clock Class to simulate a digital clock
 */
public class ClockApp
{

    public static void main( String[] args )
    {

        // Instantiate a Alarm object
        Alarm myClock;
        myClock = new Alarm();

        // Check time if no value was assigned during construction
        System.out.println(myClock.getTime());

        // use exception handling for clock settings
        try
        {
            // set clock then alarm to same time, will produce an alarm
            myClock.setTime(10, 52);
            myClock.alarmSet(10, 52);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("wrong input range");
        }

        try
        {
            // set alarm then clock to same time, will produce an alarm
            myClock.alarmSet(10, 52);
            myClock.setTime(10, 52);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("wrong input range");
        }


        // loop through 2000 minutes (24h = 1440 min, hence alarm event
        for(int iii = 1; iii < 2000; iii++)
        {
            myClock.timeTick();
        }

        // repeat prior but switch off alarm first, hence no alarm event
        myClock.alarmOff();
        for(int iii = 1; iii < 2000; iii++)
        {
            myClock.timeTick();
        }



        // output time
        System.out.println(myClock.getTime());

        // test exception handling by entering an out
        // of range value for setTime. Exception will be caught
        try
        {
            myClock.setTime(50, 12);
            System.out.println(myClock.getTime());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("wrong input range");
        }

    }

}
