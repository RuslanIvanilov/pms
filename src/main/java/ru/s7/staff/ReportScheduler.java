package ru.s7.staff;

public class ReportScheduler {

    private String reportId;
    private SchedulerDateFilter schedulerDateFilter;

    public ReportScheduler(){
    }

    public ReportScheduler setSchedulerDateFilter(SchedulerDateFilter schedulerDateFilter){
        this.schedulerDateFilter = schedulerDateFilter;
        return this;
    }

    public ReportScheduler setReportId(String reportId){
        this.reportId = reportId;
        return this;
    }

    public String getReportId() {
        return reportId;
    }

    public SchedulerDateFilter getSchedulerDateFilter() {
        return new SchedulerDateFilter()
                .setMinutes(schedulerDateFilter.getMinutes())
                .setHour(schedulerDateFilter.getHour())
                .setNumberMonth(schedulerDateFilter.getNumberMonth())
                .setDayOfMonth(schedulerDateFilter.getDayOfMonth())
                .setDayOfWeek(schedulerDateFilter.getDayOfWeek());
    }

    public String toString(){
        return "Report Id: " + getReportId() + " SchedulerDateFilter: " +schedulerDateFilter.toString();
    }
}
