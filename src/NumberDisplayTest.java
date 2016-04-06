/**
 *
 * File:    NumberDisplayTest.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */

import org.junit.Test;

public class NumberDisplayTest
{
    @Test
    public void shouldBeAbleToCreateNumberDisplay() throws Exception
    {
        new NumberDisplay(1,7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfMinLargerMax() throws Exception
    {
        new NumberDisplay(10,5);
    }
}