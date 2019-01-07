package com.dennis.oconnell.samplejavaapi.services;

import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import com.dennis.oconnell.samplejavaapi.repositories.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetServiceImpl implements TimesheetService{

    private TimesheetRepository timesheetRepository;

    @Autowired
    public TimesheetServiceImpl(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    @Override
    public List<Timesheet> GetAllTimesheets() {
        return (List<Timesheet>) timesheetRepository.findAll();

    }

    @Override
    public Timesheet GetEntryById(long id) {
        return null;
    }

    @Override
    public Timesheet GetEntryByClient(String client) {
        return null;
    }

    @Override
    public void CreateTimesheet(Timesheet timesheet) {

    }

    @Override
    public void UpdateTimesheet(Timesheet timesheet) {

    }
}
