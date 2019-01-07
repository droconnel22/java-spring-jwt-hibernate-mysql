package com.dennis.oconnell.samplejavaapi.repositories;

import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet,Long> {
}
