
/**
 * Created by loge on 04/04/16.
 */
public class MainClock {

    public static void main( String[] args )
    {

        Alarm myClock;
        myClock = new Alarm();

        System.out.println(myClock.getTime());

        try
        {
            myClock.setTime(10, 52);
            myClock.alarmSet(10, 52);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("wrong input range");
        }



        for(int iii = 1; iii < 2000; iii++)
        {
            myClock.timeTick();
        }


        System.out.println(myClock.getTime());

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
