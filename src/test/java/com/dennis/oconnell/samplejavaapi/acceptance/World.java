package com.dennis.oconnell.samplejavaapi.acceptance;

import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import org.springframework.http.ResponseEntity;

public class World {
    private Long dataBaseCount;
    private ResponseEntity<Timesheet> retrievedTimesheet;
    private ResponseEntity<Timesheet[]> timesheets;

    public World() {
    }

    public ResponseEntity<Timesheet> getRetrievedTimesheet() {
        return retrievedTimesheet;
    }

    public void setRetrievedTimesheet(ResponseEntity<Timesheet> retrievedTimesheet) {
        this.retrievedTimesheet = retrievedTimesheet;
    }

    public void setDataBaseCount(Long dataBaseCount) {
        this.dataBaseCount = dataBaseCount;
    }

    public Long getDataBaseCount() {
        return dataBaseCount;
    }

    public ResponseEntity<Timesheet[]> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(ResponseEntity<Timesheet[]> timesheets) {
        this.timesheets = timesheets;
    }
}
