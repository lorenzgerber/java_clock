/**
 *
 * File:    ClockTest.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */

import org.junit.Test;


public class ClockTest
{
    @Test
    public void shouldBeAbleToCreateClock() throws Exception
    {
        new Clock();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfWrongInputRange() throws Exception
    {
        new Clock(25, 10);
        new Clock(-10, 10);
        new Clock(10, 100);
        new Clock(10, -10);
    }



}
