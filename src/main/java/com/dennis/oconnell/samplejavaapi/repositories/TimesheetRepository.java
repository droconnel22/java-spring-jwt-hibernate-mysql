package com.dennis.oconnell.samplejavaapi.repositories;

import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import org.springframework.data.repository.CrudRepository;

public interface TimesheetRepository extends CrudRepository<Timesheet,Long> {
    Iterable<Timesheet> findByClient(String client);
}
