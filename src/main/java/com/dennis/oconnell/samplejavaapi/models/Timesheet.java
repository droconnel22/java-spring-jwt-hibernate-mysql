package com.dennis.oconnell.samplejavaapi.models;


import javax.persistence.*;
import javax.validation.constraints.*;
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
    @NotEmpty
    @NotBlank
    @NotNull
    private String client;

    @Column(name="Project")
    @NotEmpty
    @NotNull
    private String project;

    @Column(name="ProjectCode")
    @NotNull
    @NotEmpty
    private String projectCode;

    @Column(name="Task")
    @NotNull
    @NotEmpty
    private String task;

    @Column(name="Hours")
    @NotNull
    @PositiveOrZero
    private double hours;

    @Column(name="HoursRounded")
    @PositiveOrZero
    @NotNull
    private double hoursRounded;

    @Column(name="Billable")
    @NotNull
    private Boolean billable;

    @Column(name = "Invoiced")
    @NotNull
    private Boolean invoiced;

    @Column(name="Approved")
    @NotNull
    private Boolean approved;

    @Column(name="FirstName")
    @NotEmpty
    @NotNull
    private String firstName;

    @Column(name="LastName")
    @NotNull
    @NotEmpty
    private String lastName;

    @Column(name="Department")
    private String department;

    @Column(name="Employee")
    private Boolean employee;

    @Column(name="BillableRate")
    @PositiveOrZero
    @NotNull
    private int billableRate;

    @Column(name="CostRate")
    @PositiveOrZero
    @NotNull
    private int costRate;

    @Column(name="CostAmount")
    @PositiveOrZero
    @NotNull
    private int costAmount;

    @Column(name="Currency")
    @NotNull
    private String currency;

    @Column(name="ExternalReferenceURL")
    private String externalReferenceUrl;

    public Timesheet() {

    }

    // built in constructor guard clauses
    public Timesheet(@NotNull @PastOrPresent Date date, @NotEmpty @NotBlank @NotNull String client, @NotEmpty @NotNull String project, @NotNull @NotEmpty String projectCode, @NotNull @NotEmpty String task, @NotNull @PositiveOrZero double hours, @PositiveOrZero @NotNull double hoursRounded, @NotNull Boolean billable, @NotNull Boolean invoiced, @NotNull Boolean approved, @NotEmpty @NotNull String firstName, @NotNull @NotEmpty String lastName, String department, Boolean employee, @PositiveOrZero @NotNull int billableRate, @PositiveOrZero @NotNull int costRate, @PositiveOrZero @NotNull int costAmount, @NotNull String currency, String externalReferenceUrl) {
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
