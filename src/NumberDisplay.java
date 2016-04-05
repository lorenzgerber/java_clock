/**
 *
 * File:    NumberDisplay.java
 * Author:  Lorenz Gerber
 * Contact: dv15lgr@cs.umu.se
 * Date:    2016-04-05
 */



public class NumberDisplay {


    private int minLimit;
    private int maxLimit;
    private int value;

    public NumberDisplay(int minLimit, int maxLimit){

        this.minLimit = minLimit;
        this.maxLimit = maxLimit;

        this.value = minLimit;


    }

    public int getValue(){

        return this.value;
    }

    public void setValue(int newValue){
        this.value = newValue;
    }

    public String getDisplayValue(){
        return String.valueOf(this.value);
    }

    public void increment(){
        if(this.value + 1 < this.maxLimit){
            this.value++;
        } else {
            this.value = this.minLimit;
        }

    }

    public boolean didWrapAround(){

        if(this.value == this.minLimit){
            return true;
        } else {
            return false;
        }
    }


}
