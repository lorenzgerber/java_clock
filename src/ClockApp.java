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
        System.out.println("\n### check instantiate an alarm object");
        Alarm myClock;
        myClock = new Alarm();
        System.out.println("### check end\n");

        // Check time if no value was assigned during construction
        System.out.println("\n### check default clock time after construction");
        System.out.println(myClock.getTime());
        System.out.println("### check end\n");

        // set clock then alarm to same time, will not cause an alarm
        System.out.println("\n### check alarm set to current time does not cause alarm");
        myClock.setTime(0, 0);
        myClock.alarmSet(0, 0);
        System.out.println("### check end\n");


        // set alarm then clock to same time, will not produce alarm
        System.out.println("\n### check time set to alarm time does not cause alarm");
        myClock.alarmSet(1, 52);
        myClock.setTime(1, 52);
        System.out.println("### check end\n");

        // loop through 2000 minutes (24h = 1440 min, hence alarm event
        System.out.println("\n### check alarm switched on and hitting alarm time");
        for(int iii = 1; iii < 2000; iii++)
        {
            myClock.timeTick();
        }
        System.out.println("### check end\n");

        // repeat prior but switch off alarm first, hence no alarm event
        System.out.println("\n### check alarm switched off and hitting alarm time");
        myClock.alarmOff();
        for(int iii = 1; iii < 2000; iii++)
        {
            myClock.timeTick();
        }
        System.out.println(myClock.getTime());
        System.out.println("### check end\n");

        // test exception handling by entering an out
        // of range value for setTime. Exception will be caught
        System.out.println("\n### check exception handling when input out of range");
        try
        {
            myClock.setTime(50, 12);
            System.out.println(myClock.getTime());
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("wrong input range");
        }
        System.out.println("### check end\n");

        // test edge cases, time set to 00:00, then tick
        System.out.println("\n### check edge case when time set to 00:00 and increased");
        myClock.setTime(0,0);
        System.out.println(myClock.getTime());
        myClock.timeTick();
        System.out.println(myClock.getTime());
        System.out.println("### check end\n");

        // test edge case, time set to 23:59, then tick
        System.out.println("\n### check edge case when time set to 23:59 and increased");
        myClock.setTime(23,59);
        System.out.println(myClock.getTime());
        myClock.timeTick();
        System.out.println(myClock.getTime());
        System.out.println("### check end\n");



    }

}
