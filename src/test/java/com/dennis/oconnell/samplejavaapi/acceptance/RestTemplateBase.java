package com.dennis.oconnell.samplejavaapi.acceptance;

import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RestTemplateBase {

    private RestTemplate restTemplate = new RestTemplate();

    String baseProtocol = "http://";
    String baseUrl ="localhost:8080/api/v1/";

    protected ResponseEntity<Timesheet> executePost(String url, Timesheet timesheet) throws Exception {
        if(!url.isEmpty() && timesheet != null){
            return restTemplate.postForEntity(baseProtocol+baseUrl+url, timesheet, Timesheet.class);
        } else throw new Exception("Invalid request to create timesheet");
    }

    protected long executeCount(String url) throws Exception {
        if(!url.isEmpty()){
            return restTemplate.getForObject(baseProtocol+baseUrl+url, Long.class);
        } else  throw  new Exception("Invalid request to get count of timesheets");
    }

    protected ResponseEntity<Timesheet> executeSingleEntityGet(String url, long id) throws  Exception{
        if(!url.isEmpty() && id != 0){
            return  restTemplate.getForEntity(baseProtocol+baseUrl+url+"/"+id, Timesheet.class);
        } else throw new Exception("Invalid request to get single timesheet by id");
    }

    protected void executeSingleEntityDelete(String url, Timesheet timesheet) throws Exception {
        if(!url.isEmpty() && timesheet != null && timesheet.getId() != 0) {
            restTemplate.delete(baseProtocol+baseUrl+url+"/"+timesheet.getId(), Timesheet.class);
        } else throw  new Exception("Invalid request to delete single timesheet");
    }

    protected void executeSingleEntityPut(String url, Timesheet timesheet) throws Exception {
        if(!url.isEmpty() && timesheet != null && timesheet.getId() != 0){
            restTemplate.put(baseProtocol+baseUrl+url, timesheet, Timesheet.class);
        } else throw new Exception("Invalid request to put single timesheet");
    }

    protected ResponseEntity<Timesheet[]> executeTimesheetSearch(String url, String client) throws Exception {
        if(!url.isEmpty() && !client.isEmpty()){
            Timesheet[] timesheets = restTemplate.getForObject(baseProtocol+baseUrl+url+"?client="+client, Timesheet[].class);
            return  new ResponseEntity<>(timesheets, HttpStatus.OK);
        } else throw new Exception("Invalid request to get search for timesheet");
    }

    protected ResponseEntity<Timesheet[]> executeTimesheetGetAll(String url) throws Exception {
        if(!url.isEmpty()){
            Timesheet[] timesheets = restTemplate.getForObject(baseProtocol+baseUrl+url, Timesheet[].class);
            return  new ResponseEntity<>(timesheets, HttpStatus.OK);
        } else throw new Exception("Invalid request to get search for timesheet");
    }


    protected Timesheet createTimesheetFromLine(Object[] line) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");

        try {
            return new Timesheet(
                    formatter.parse(line[7].toString()), // date
                    line[3].toString(), // client
                    line[16].toString(), // project
                    line[17].toString(), // projectCode
                    line[18].toString(), // task
                    Double.parseDouble(line[12].toString()), // hours
                    Double.parseDouble(line[13].toString()), // hoursRounded
                    parseBoolean(line[1].toString()), // billable
                    parseBoolean(line[14].toString()), // invoiced
                    parseBoolean(line[0].toString()), // approved
                    line[11].toString(), // first name
                    line[15].toString(), // last name
                    line[8].toString(), // department
                    parseBoolean(line[9].toString()), // employed
                    Integer.parseInt(line[2].toString()), // billableRate
                    Integer.parseInt(line[5].toString()), // cost rate
                    Integer.parseInt(line[4].toString()), // cost amount
                    line[6].toString(), // currency
                    "" // external facing url
            );

        } catch (Exception ex ) {
            return null;
        }
    }

    private Boolean parseBoolean(String s) {
        return s == "Yes";
    }


}
