/**
 * Clock Class
 */
public class Clock {

    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;

    public Clock(){

        this.hours = new NumberDisplay(0,23);
        this.minutes = new NumberDisplay(0,59);

    }

    public Clock(int hours, int minutes){
        this.hours = new NumberDisplay(0,23);
        this.minutes = new NumberDisplay(0, 59);

        this.hours.setValue(hours);
        this.minutes.setValue(minutes);

    }

    public void timeTick(){

        this.minutes.increment();
        if(this.minutes.didWrapAround()){
            this.hours.increment();
        }


    }

    public void setTime(int hours, int minutes){
        this.hours.setValue(hours);
        this.minutes.setValue(minutes);

    }

    public String getTime(){
        this.updateDisplay();
        return this.displayString;
    }

    private void updateDisplay(){

        StringBuilder displayAssembly = new StringBuilder();
        
        if(this.hours.getValue()<10){
            displayAssembly.append("0");
        }

        displayAssembly.append(String.valueOf(this.hours.getDisplayValue()));

        displayAssembly.append(":");

        if(this.minutes.getValue()<10){
            displayAssembly.append("0");
        }

        displayAssembly.append(String.valueOf(this.minutes.getDisplayValue()));

        this.displayString = displayAssembly.toString();

    }



}
