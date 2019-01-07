package com.dennis.oconnell.samplejavaapi.services;

import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TimesheetService {

    public List<Timesheet> GetAllTimesheets();
    public Timesheet GetEntryById(long id);
    public Timesheet GetEntryByClient(String client);
    public void CreateTimesheet(Timesheet timesheet);
    public void UpdateTimesheet(Timesheet timesheet);
}

