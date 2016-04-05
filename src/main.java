/**
 * Created by loge on 04/04/16.
 */
public class main {

    public static void main( String[] args ){

        Alarm myClock;
        myClock = new Alarm();

        System.out.println(myClock.getTime());

        myClock.alarmSet(10,52);
        myClock.alarmOn();

        for(int iii = 1; iii < 2000; iii++){
            myClock.timeTick();
        }

        System.out.println(myClock.getTime());

        myClock.setTime(45,12);
        System.out.println(myClock.getTime());



    }

}
