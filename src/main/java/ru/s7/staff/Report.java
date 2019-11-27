package ru.s7.staff;

public class Report {

    private String reportId;
    private String reportName;
    private ReportScheduler reportScheduler;

    public Report(String reportId, String reportName, ReportScheduler reportScheduler){
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportScheduler = reportScheduler;
    }

    public String getReportId() {
        return reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public ReportScheduler getReportScheduler() {
        return reportScheduler;
    }

    public String toString(){
        return "Report Id: " + getReportId() + " Report Name: " + getReportName() + " Repor tScheduler: " + reportScheduler.toString() ;
    }

}
