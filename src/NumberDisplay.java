/**
 *
 * File:    NumberDisplay.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */


/**
 * A Class that simulates a single digit number Display
 * it can be incremented unit wise and it will flip back to
 * it's lowest range when incremented on it's maximum range
 * value
 */
public class NumberDisplay
{


    private int minLimit;
    private int maxLimit;
    private int value;

    /**
     * Constructor for Number Display
     *
     * @param minLimit Upper limit of NumberDisplay value range
     * @param maxLimit Lower limit of NumberDisplay value range
     * @throws IllegalArgumentException
     */
    public NumberDisplay(int minLimit, int maxLimit)
    throws IllegalArgumentException
    {

        if (minLimit >= maxLimit )
        {
            throw new IllegalArgumentException("minLimit has to be smaller than maxLimit");
        }
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;

        this.value = minLimit;


    }

    /**
     * getter / accessor method
     * to access the value of the NumberDisplay
     * @return
     */
    public int getValue()
    {

        return this.value;
    }

    /**
     * setter / modifier method
     * to write new value of the NumberDisplay
     * @param newValue
     */
    public void setValue(int newValue) throws IllegalArgumentException
    {
        if(newValue < this.minLimit)
            throw new IllegalArgumentException("entered value is too low");
        if(newValue > this.maxLimit)
            throw new IllegalArgumentException("entered value is too high");

        this.value = newValue;

    }

    /**
     * Get the NumberDisplay value as String
     * @return value
     */
    public String getDisplayValue()
    {
        StringBuilder displayAssembly = new StringBuilder();

        if(this.value<10)
        {
            displayAssembly.append("0");
        }

        displayAssembly.append(String.valueOf(this.value));

        return displayAssembly.toString();
    }

    /**
     * Method to increment NumberDisplay
     * increment is one step
     */
    public void increment()
    {
        if(this.value + 1 < this.maxLimit)
        {
            this.value++;
        } else {
            this.value = this.minLimit;
        }

    }

    /**
     * Method that produces boolean true when
     * invoked after a wrap around
     * @return boolean
     */
    public boolean didWrapAround()
    {

        if(this.value == this.minLimit)
        {
            return true;
        } else {
            return false;
        }
    }
}
