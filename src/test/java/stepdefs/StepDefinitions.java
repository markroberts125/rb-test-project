package stepdefs;

import client.RainbirdInteractor;
import config.CucumberConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefinitions extends CucumberConfig {

    @Autowired
    RainbirdInteractor rainbirdInteractor;

    @Given("I am logged in")
    public void iAmLoggedIn() {
        rainbirdInteractor.login();
    }

    @Given("I am on the files page")
    public void iAmOnTheFilesPage() {

    }

    @When("I am on the default sort")
    public void iAmOnTheDefaultSort() {
    }

    @When("I sort by name ascending")
    public void iSortByNameAscending() {
    }

    @When("I sort by name descending")
    public void iSortByNameDescending() {
    }

    @When("I sort by description ascending")
    public void iSortByDescriptionAscending() {
    }

    @When("I sort by description descending")
    public void iSortByDescriptionDescending() {
    }

    @When("I sort by last modified ascending")
    public void iSortByLastModifiedAscending() {
    }

    @When("I sort by last modified descending")
    public void iSortByLastModifiedDescending() {
    }

    @Then("the files are sorted by name ascending")
    public void theFilesAreSortedByNameAscending() {
    }

    @Then("the files are sorted by name descending")
    public void theFilesAreSortedByNameDescending() {
    }

    @Then("the files are sorted by description ascending")
    public void theFilesAreSortedByDescriptionAscending() {
    }

    @Then("the files are sorted by description descending")
    public void theFilesAreSortedByDescriptionDescending() {
    }

    @Then("the files are sorted by last modified ascending")
    public void theFilesAreSortedByLastModifiedAscending() {
    }

    @Then("the files are sorted by last modified descending")
    public void theFilesAreSortedByLastModifiedDescending() {
    }

}
