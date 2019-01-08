package com.dennis.oconnell.samplejavaapi.seeder;

import com.dennis.oconnell.samplejavaapi.TimesheetApplication;
import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import com.dennis.oconnell.samplejavaapi.repositories.TimesheetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

@Component
public class TimesheetDbSeeder implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(TimesheetApplication.class);

    @Value(value = "classpath:input/GM_Backend_Coding_Exercise_-_Sample_Data_Report.csv")
    private Resource timesheetSeedCSV;

    @Autowired
    private TimesheetRepository timesheetRepository;

    public void Seed() throws Exception {


        // reset table
        timesheetRepository.deleteAll();

        Scanner scanner = new Scanner(timesheetSeedCSV.getFile());
        scanner.useDelimiter(",");

        // Skip Header
        scanner.nextLine();

        // Read until end of file.
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();

            // Check if line is empty and continue.
            if(line.toCharArray()[0] == ',') {
                continue;
            }

            Timesheet timesheet = createTimesheetFromLine(line.split(","));
            timesheetRepository.save(timesheet);
        }
        scanner.close();
    }

    /*
    this.date = date;
        this.client = client;
        this.project = project;
        this.projectCode = projectCode;
        this.task = task;
        this.hours = hours;
        this.hoursRounded = hoursRounded;
        this.billable = billable;
        this.invoiced = invoiced;
        this.approved = approved;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.employee = employee;
        this.billableRate = billableRate;
        this.costRate = costRate;
        this.costAmount = costAmount;
        this.currency = currency;
        this.externalReferenceUrl = externalReferenceUrl;

        4/3/17|Twitri|CLOB Rearchitecture|BGC001|Project Management| 6.26 |6|Yes|Yes|Yes|Walter|Silva|Product|Yes|50|0|0|United States Dollar - USD|
     */
    private Timesheet createTimesheetFromLine(String[] line) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/DD/YY");

        try {
            return new Timesheet(
                    formatter.parse(line[0]), // date
                    line[1], // client
                    line[2], // project
                    line[3], // projectCode
                    line[4], // task
                    Double.parseDouble(line[5]), // hours
                    Double.parseDouble(line[6]), // hoursRounded
                    parseBoolean(line[7]), // billable
                    parseBoolean(line[8]), // invoiced
                    parseBoolean(line[9]), // approved
                    line[10], // first name
                    line[11], // last name
                    line[12], // department
                    parseBoolean(line[13]), // employed
                    Integer.parseInt(line[14]), // billableRate
                    Integer.parseInt(line[15]), // cost rate
                    Integer.parseInt(line[16]), // cost amount
                    line[17], // currency
                    "" // external facing url
            );

        } catch (Exception ex ) {
            log.error(ex.getMessage());
            return null;
        }
    }

    private Boolean parseBoolean(String s) {
        return s == "Yes";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.Seed();
    }
}

