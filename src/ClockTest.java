/**
 *
 * File:    ClockTest.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */

import org.junit.Test;


public class ClockTest {
    @Test
    public void shouldBeAbleToCreateClock() throws Exception{
        new Clock();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfHoursBigger24() throws Exception{
        new Clock(25, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfHoursNegative() throws Exception{
        new Clock(-10, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfMinutesBigger59() throws Exception{
        new Clock(10, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfMinutesNegative() throws Exception{
        new Clock(10, -10);
    }




}
