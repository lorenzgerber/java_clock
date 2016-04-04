/**
 * Created by loge on 04/04/16.
 */
public class main {

    public static void main( String[] args ){

        Clock myClock;
        myClock = new Clock();

        System.out.println(myClock.getTime());

        for(int iii = 1; iii < 2000; iii++){
            myClock.timeTick();
        }

        System.out.println(myClock.getTime());

        myClock.setTime(45,12);
        System.out.println(myClock.getTime());


    }

}
