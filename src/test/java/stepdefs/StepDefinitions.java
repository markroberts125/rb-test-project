package stepdefs;

import client.FileTableField;
import client.RainbirdInteractor;
import config.CucumberConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static client.FileTableField.LastModified;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitions extends CucumberConfig {

    @Autowired
    RainbirdInteractor rainbirdInteractor;

    @Given("I am logged in")
    public void iAmLoggedIn() {
        rainbirdInteractor.login();
    }

    @Given("I am on the studio page")
    public void iAmOnTheStudioPage() {
        rainbirdInteractor.goToStudioPage();
    }

    @When("I am on the default sort")
    public void iAmOnTheDefaultSort() {
        //Nothing to do here, it's the default
    }

    @When("I sort by {fileTableField} ascending")
    public void iSortByNameAscending(FileTableField fileTableField) {
        rainbirdInteractor.setAscending(fileTableField);
    }

    @When("I sort by {fileTableField} descending")
    public void iSortByNameDescending(FileTableField fileTableField) {
        rainbirdInteractor.setDescending(fileTableField);
    }

    @Then("the files are sorted by {fileTableField} ascending")
    public void theFilesAreSortedByNameAscending(FileTableField fileTableField) {
        List<String> column = rainbirdInteractor.getFilesColumnContents(fileTableField);
        if(fileTableField == LastModified){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\n HH:mm");
            List<LocalDateTime> dateTimeColumn = new ArrayList<>();
            column.forEach(entry -> dateTimeColumn.add(LocalDateTime.parse(entry, formatter)));
            List<LocalDateTime> sortedDateTimeColumn = new ArrayList<>(dateTimeColumn);
            Collections.sort(sortedDateTimeColumn);
            assertEquals(sortedDateTimeColumn, dateTimeColumn);
        }
        else {
            List<String> sortedColumn = new ArrayList<String>(column);
            Collections.sort(sortedColumn);
            assertEquals(sortedColumn, column);
        }
    }

    @Then("the files are sorted by {fileTableField} descending")
    public void theFilesAreSortedByNameDescending(FileTableField fileTableField) {
        List<String> column = rainbirdInteractor.getFilesColumnContents(fileTableField);
        if(fileTableField == LastModified){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy\n HH:mm");
            List<LocalDateTime> dateTimeColumn = new ArrayList<>();
            column.forEach(entry -> dateTimeColumn.add(LocalDateTime.parse(entry, formatter)));
            List<LocalDateTime> sortedDateTimeColumn = new ArrayList<>(dateTimeColumn);
            sortedDateTimeColumn.sort(Collections.reverseOrder());
            assertEquals(sortedDateTimeColumn, dateTimeColumn);
        }
        else {
            List<String> sortedColumn = new ArrayList<String>(column);
            sortedColumn.sort(Collections.reverseOrder());
            assertEquals(sortedColumn, column);
        }
    }

}
