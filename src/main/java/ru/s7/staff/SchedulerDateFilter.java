package ru.s7.staff;

public class SchedulerDateFilter {
    // run job  every day in 18:07, if day is 13.05(13 may) , if day of week is Friday.
    private String minutes;
    private String hour;
    private String dayOfMonth;
    private String numberMonth;
    private String dayOfWeek;
    //private SchedulerDateFilter schedulerDateFilter;

    public SchedulerDateFilter(){
       // this.schedulerDateFilter = new SchedulerDateFilter();
    }

    /**
     * @deprecated
     * */
    public SchedulerDateFilter(String minutes, String hour, String dayOfMonth, String numberMonth, String dayOfWeek){
        this.minutes = minutes == null ? "*" :  minutes;
        this.hour = hour == null ? "*" :  hour;
        this.dayOfMonth = dayOfMonth == null ? "*" :  dayOfMonth;
        this.numberMonth = numberMonth == null ? "*" :  numberMonth;
        this.dayOfWeek = dayOfWeek == null ? "*" :  dayOfWeek;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getHour() {
        return hour;
    }

    public String getDayOfMonth() {
        return dayOfMonth;
    }

    public String getNumberMonth() {
        return numberMonth;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public SchedulerDateFilter setMinutes(Object minutes) {
        this.minutes = (String)minutes;
        return this;
    }

    public SchedulerDateFilter setHour(Object hour) {
        this.hour = (String)hour;
        return this;
    }

    public SchedulerDateFilter setDayOfMonth(Object dayOfMonth) {
        this.dayOfMonth = (String)dayOfMonth;
        return this;
    }

    public SchedulerDateFilter setNumberMonth(Object numberMonth) {
        this.numberMonth = (String)numberMonth;
        return this;
    }

    public SchedulerDateFilter setDayOfWeek(Object dayOfWeek) {
        this.dayOfWeek = (String)dayOfWeek;
        return this;
    }



    @Override
    public String toString(){
        return "Minutes: " + minutes + " Hour: " + hour + " Day Of Month: " + dayOfMonth + " Number Month: " + numberMonth + " Day Of Week: " + dayOfWeek;
    }
}
