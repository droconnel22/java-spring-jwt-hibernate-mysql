package com.dennis.oconnell.samplejavaapi.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
@Table(name="timesheets")
public class Timesheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="Date")
    @NotNull
    @PastOrPresent
    private Date date;

    @Column(name="Client")
    private String client;

    @Column(name="Project")

    private String project;

    @Column(name="ProjectCode", nullable = false)
    private String projectCode;

    @Column(name="Task", nullable = false)
    private String task;

    @Column(name="Hours", nullable = false)
    private double hours;

    @Column(name="HoursRounded", nullable = false)
    private double hoursRounded;

    @Column(name="Billable")
    private Boolean billable;

    @Column(name="Invoiced")
    private Boolean invoiced;

    @Column(name="Approved")
    private Boolean approved;

    @Column(name="FirstName", nullable = false)
    @NotEmpty
    private String firstName;

    @Column(name="LastName", nullable = false)
    private String lastName;

    @Column(name="Department")
    private String department;

    @Column(name="Employee")
    private Boolean employee;

    @Column(name="BillableRate", nullable = false)
    private int billableRate;

    @Column(name="CostRate", nullable = false)
    private int costRate;

    @Column(name="CostAmount")
    private int costAmount;

    @Column(name="Currency")
    private String currency;

    @Column(name="ExternalReferenceURL")
    private String externalReferenceUrl;

    public Timesheet() {

    }

    public Timesheet(@NotNull @PastOrPresent Date date, @NotEmpty @NotNull String client, @NotEmpty @NotNull String project, @NotEmpty String projectCode, @NotEmpty String task, @Min(value = 0, message = "Hours must be a positive value") double hours, @Min(value = 0, message = "Hours Rounded must be a positive value") double hoursRounded, Boolean billable, Boolean invoiced, Boolean approved, @NotEmpty String firstName, @NotEmpty String lastName, String department, Boolean employee, @Min(value = 0, message = "Billable Rate must be a positive value") int billableRate, @Min(value = 0, message = "Cost Rate must be a positive value") int costRate, @NotNull(message = "Cost amount must be defined") @Min(value = 0, message = "Cost Amount must be a positive value") int costAmount, @NotEmpty @Min(2) @NotNull String currency, String externalReferenceUrl) {
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
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getClient() {
        return client;
    }

    public String getProject() {
        return project;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getTask() {
        return task;
    }

    public double getHours() {
        return hours;
    }

    public double getHoursRounded() {
        return hoursRounded;
    }

    public Boolean getBillable() {
        return billable;
    }

    public Boolean getInvoiced() {
        return invoiced;
    }

    public Boolean getApproved() {
        return approved;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public Boolean getEmployee() {
        return employee;
    }

    public int getBillableRate() {
        return billableRate;
    }

    public int getCostRate() {
        return costRate;
    }

    public int getCostAmount() {
        return costAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExternalReferenceUrl() {
        return externalReferenceUrl;
    }

    @Override
    public String toString() {
        return "Timesheet{" +
                "id=" + id +
                ", date=" + date +
                ", client='" + client + '\'' +
                ", project='" + project + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", task='" + task + '\'' +
                ", hours=" + hours +
                ", hoursRounded=" + hoursRounded +
                ", billable=" + billable +
                ", invoiced=" + invoiced +
                ", approved=" + approved +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", employee=" + employee +
                ", billableRate=" + billableRate +
                ", costRate=" + costRate +
                ", costAmount=" + costAmount +
                ", currency='" + currency + '\'' +
                ", externalReferenceUrl='" + externalReferenceUrl + '\'' +
                '}';
    }
}
