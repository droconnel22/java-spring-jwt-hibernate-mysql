package com.dennis.oconnell.samplejavaapi.controllers;

import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import com.dennis.oconnell.samplejavaapi.services.TimesheetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class TimesheetController {

    private TimesheetServiceImpl timesheetService;

    @Autowired
    public TimesheetController(TimesheetServiceImpl timesheetService) {
        this.timesheetService = timesheetService;
    }

    //public @ResponseBody String
    @GetMapping(value = "getTimesheetByClient", params = "client")
    public Timesheet getTimesheetByClient(@RequestParam(value="client", defaultValue="") String client) {
        return this.timesheetService.GetEntryByClient(client);
    }

    @GetMapping(value = "/")
    public List<Timesheet> getAll() {
        return this.timesheetService.GetAllTimesheets();
    }


}
