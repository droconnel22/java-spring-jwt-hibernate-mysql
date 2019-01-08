package com.dennis.oconnell.samplejavaapi.controllers;

import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import com.dennis.oconnell.samplejavaapi.repositories.TimesheetRepository;
import com.dennis.oconnell.samplejavaapi.utility.ErrorMessage;
import com.dennis.oconnell.samplejavaapi.utility.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/")
public class TimesheetController {

    @Autowired
    private TimesheetRepository timesheetRepository;

    @GetMapping(value = "/timesheet")
    public ResponseEntity<Iterable<Timesheet>> getAll() {
        return new ResponseEntity<>(timesheetRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/timesheet/{id}")
    public ResponseEntity<Optional<Timesheet>> getById(@PathVariable Long id){
        return new ResponseEntity<>(timesheetRepository.findById(id), HttpStatus.OK);
    }

    //public @ResponseBody String
    @GetMapping(value = "/timesheet/search")
    public ResponseEntity<Iterable<Timesheet>> getByClient(@Valid @RequestParam(value="client", required = true) String client) {
        if(client != "") {
            return new ResponseEntity<>(timesheetRepository.findByClient(client),HttpStatus.OK);
        } else throw  new ValidationException("Client not specified.");
    }

    @PostMapping(value = "/timesheet")
    public ResponseEntity<Timesheet> create(@Valid @RequestBody Timesheet timesheet) {
        if(timesheet.getId() != 0){
            return new ResponseEntity<>(timesheetRepository.save(timesheet), HttpStatus.OK);
        } else throw new ValidationException("Timesheet can not be created");
    }

    @PutMapping(value = "/timesheet")
    public ResponseEntity<Timesheet> update(@Valid @RequestBody Timesheet timesheet){
        if(!timesheetRepository.findById(timesheet.getId()).isPresent()){
            return new ResponseEntity<>(timesheetRepository.save(timesheet), HttpStatus.OK);
        } else throw new ValidationException("Timesheet can not be updated");
    }

    @DeleteMapping("/timesheet/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        if(this.timesheetRepository.findById(id).isPresent()){
            timesheetRepository.deleteById(id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else throw new ValidationException("Timesheet can not be deleted");
    }
}