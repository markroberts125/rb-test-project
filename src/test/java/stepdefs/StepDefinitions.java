package stepdefs;

import client.FileTableField;
import client.RainbirdInteractor;
import config.CucumberConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

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
    }

    @Then("the files are sorted by {fileTableField} descending")
    public void theFilesAreSortedByNameDescending(FileTableField fileTableField) {
    }

}
