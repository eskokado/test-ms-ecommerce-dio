package com.eskokado.ecommerce.diocheckoutapi.steps;

import com.eskokado.ecommerce.diocheckoutapi.SpringIntegrationTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class StepDefinitions extends SpringIntegrationTest {
    @When("the client calls {string}")
    public void theClientCalls(String path) throws IOException {
        // TODO : Configurar
    }

    @Then("the client receives status code of {int}")
    public void theClientReceivesStatusCodeOf(int expectedStatusCode) {
        // TODO : Configurar
    }

    @And("response is {string}")
    public void responseIs(String expectedResponseBody) {
        // TODO : Configurar
    }

    @Given("checkout code {string}")
    public void checkoutCode(String checkoutCode) {
        // TODO : Configurar
    }
}
