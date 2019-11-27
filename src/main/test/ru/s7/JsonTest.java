package ru.s7;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.s7.staff.Report;
import ru.s7.staff.ReportScheduler;
import ru.s7.staff.SchedulerDateFilter;

import java.io.IOException;

public class JsonTest {

    @Test
    public void shouldCreateSchedulerFilter(){
        SchedulerDateFilter schedulerDateFilterEmpty = new SchedulerDateFilter(null, null, null, null, null);
        SchedulerDateFilter schedulerDateFilter = new SchedulerDateFilter("0","12", null, null, "1,2,3,4,5" );

        System.out.println(schedulerDateFilterEmpty.toString());
        System.out.println(schedulerDateFilter.toString());
    }

    @Test
    public void shouldCreateReport(){
        SchedulerDateFilter schedulerDateFilter = new SchedulerDateFilter("0","12", null, null, null);
        ReportScheduler reportScheduler = new ReportScheduler().setSchedulerDateFilter(schedulerDateFilter).setReportId("some_report");
        Report report = new Report( reportScheduler.getReportId(), reportScheduler.getReportId()+".jrxml",  reportScheduler);

        System.out.println("report: " + report.toString() );

    }


    @Test
    public void shouldReadJson(){
        String fileName = "reports.json";
        String path = this.getClass().getClassLoader().getResource(fileName).getPath();
        System.out.println("PATH: " + path);

        JSONParser parser = new JSONParser();
        SchedulerDateFilter sch;

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader(path));
            for (Object o : a)
            {
                JSONObject json = (JSONObject) o;

                String st = (String) json.get("name");
                System.out.println("name : " + st);

                String dob = (String) json.get("minutes");
                System.out.println("minutes : " + dob);

                String doj = (String) json.get("hour");
                System.out.println("hour : " + doj);

                String role = (String) json.get("dayOfWeek");
                System.out.println("dayOfWeek : " + role);

                System.out.println("\n");

                sch = new SchedulerDateFilter().setMinutes(json.get("minutes"))
                        .setHour(json.get("hour"))
                        .setDayOfMonth(json.get("dayOfMonth"))
                        .setNumberMonth(json.get("numberMonth"))
                        .setDayOfWeek(json.get("dayOfWeek"));

                System.out.println("Scheduler: " + sch );

            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
