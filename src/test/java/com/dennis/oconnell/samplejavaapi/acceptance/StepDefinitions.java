package com.dennis.oconnell.samplejavaapi.acceptance;

import com.dennis.oconnell.samplejavaapi.models.Timesheet;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import org.assertj.core.api.Assertions;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

public class StepDefinitions extends RestTemplateBase {

    private World world;

    // world resets for each scenario.
    public StepDefinitions() {
        this.world = new World();
    }

    //
    @Given("^An existing Timesheet with Id of (\\d+)$")
    public void getTimesheetById(long id) throws Throwable{

    }

    @When("^A Client calls GET \"(.+)\" with an Id of (\\d+)$")
    public void getTimeSheetById(String url, long id) throws  Throwable {
        ResponseEntity<Timesheet> retrievedTimesheet = executeSingleEntityGet("timesheet",id);
        world.setRetrievedTimesheet(retrievedTimesheet);
    }

    @Given("^A Seeded Database of (\\d+) records$")
    public void aSeededDatabase(Long expectedSize) throws Throwable {
        long size = executeCount("timesheet/count");
        Assertions.assertThat(size).isGreaterThan(0);
        Assertions.assertThat(size).isEqualTo(expectedSize);
        world.setDataBaseCount(size);
    }

    @Then("^The Client receives a response status code of (\\d+)$")
    public void theClientReceivesAResponseStatusCodeOf(int responseCode) throws Throwable {
        Assertions.assertThat(world.getRetrievedTimesheet().getStatusCode().value()).isEqualTo(responseCode);
    }

    @And("^The Client receives a valid response body$")
    public void theClientReceivesAValidResponseBody() throws Throwable {
       Assertions.assertThat(world.getRetrievedTimesheet()).isNotNull();
       Assertions.assertThat(world.getRetrievedTimesheet().getBody()).isInstanceOf(Timesheet.class);
       Assertions.assertThat(world.getRetrievedTimesheet().hasBody()).isTrue();
    }

    @And("^The Client receives a Timesheet with Id equal to (\\d+)$")
    public void theClientReceivesATimesheetWithIdEqualTo(long expectedId) throws Throwable {
       Assertions.assertThat(world.getRetrievedTimesheet().getBody().getId()).isEqualTo(expectedId);
    }

    @And("^The  Client receives a Timesheet with a Client Name of \"([^\"]*)\"$")
    public void theClientReceivesATimesheetWithAClientNameOf(String expectedClientName) throws Throwable {
        Assertions.assertThat(world.getRetrievedTimesheet().getBody().getClient()).isEqualTo(expectedClientName);
    }

    @When("^A Client calls GET \"([^\"]*)\"$")
    public void aClientCallsGET(String url) throws Throwable {
        ResponseEntity<Timesheet[]> timesheets = executeTimesheetGetAll(url);
        world.setTimesheets(timesheets);
    }

    @Then("^The Client receives a valid response status code of (\\d+)$")
    public void theClientReceivesAValidResponseStatusCodeOf(int expectedStatusCode) throws Throwable {
        Assertions.assertThat(world.getTimesheets().getStatusCode().value()).isEqualTo(expectedStatusCode);
    }

    @And("^The Client receives a valid response body with a collection$")
    public void theClientReceivesAValidResponseBodyWithACollection() throws Throwable {
        Assertions.assertThat(world.getTimesheets()).isNotNull();
        Assertions.assertThat(world.getTimesheets().hasBody()).isTrue();
        Assertions.assertThat(world.getTimesheets().getBody()).isInstanceOf(Timesheet[].class);
    }

    @And("^The Client receives a collection of timesheets with a count of (\\d+)$")
    public void theClientReceivesACollectionOfTimesheetsWithACountOf(int expectedCount) throws Throwable {
       Assertions.assertThat(world.getTimesheets().getBody().length).isEqualTo(expectedCount);
    }

    @When("^A Client calls GET \"([^\"]*)\" with a client name of \"([^\"]*)\"$")
    public void aClientCallsGETWithAClientNameOf(String url, String client) throws Throwable {
        world.setTimesheets(executeTimesheetSearch(url,client));
    }

    @And("^The Client only receives a collection of Timesheets with a Client Name of \"([^\"]*)\"$")
    public void theClientOnlyReceivesACollectionOfTimesheetsWithAClientNameOf(String expectedClientName) throws Throwable {
        Timesheet[] timesheets = world.getTimesheets().getBody();
        Boolean result = Arrays.asList(timesheets).stream().allMatch(f -> f.getClient().equalsIgnoreCase(expectedClientName));
        Assertions.assertThat(result).isTrue();

    }

    @When("^A Client calls POST \"([^\"]*)\" with Data:$")
    public void aClientCallsPOSTWithData(String url, DataTable input) throws Throwable {

        DataTableRow dataTableRow = input.getGherkinRows().get(1);
        Timesheet timesheet = createTimesheetFromLine(dataTableRow.getCells().toArray());
        world.setRetrievedTimesheet(executePost(url, timesheet));
    }

    @Then("^The Client calls DELETE \"([^\"]*)\" on created Timesheet$")
    public void theClientCallsDELETEOnCreatedTimesheet(String url) throws Throwable {
        executeSingleEntityDelete(url,world.getRetrievedTimesheet().getBody());
    }

    /*
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
     */
    @When("^A Client calls PUT \"([^\"]*)\" with Id of (\\d+) and an update of Client of \"([^\"]*)\"$")
    public void aClientCallsPUTWithIdOfAndAnUpdateOfClientOf(String url, long id, String clientName) throws Throwable {
        Timesheet t = world.getRetrievedTimesheet().getBody();
        t.setClient(clientName);
        executeSingleEntityPut(url,t);
    }
}

