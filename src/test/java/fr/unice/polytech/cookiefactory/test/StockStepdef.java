package fr.unice.polytech.cookiefactory.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StockStepdef {

    @Given("the stock already constains {int} doses of chocolates")
    public void the_stock_already_constains_doses_of_chocolates(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("the manager adds {int} doses of chocolates")
    public void the_manager_adds_doses_of_chocolates(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the stock should contain {int} doses of chocolates")
    public void the_stock_should_contain_doses_of_chocolates(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("the manager asks to remove  {int} doses of chocolates")
    public void the_manager_asks_to_remove_doses_of_chocolates(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("the withdrawal is refused")
    public void the_withdrawal_is_refused() {
        // Write code here that turns the phrase above into concrete actions
    }
}
