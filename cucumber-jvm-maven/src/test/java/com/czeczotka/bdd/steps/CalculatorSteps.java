package com.czeczotka.bdd.steps;

import com.czeczotka.bdd.calculator.Calculator;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CalculatorSteps {

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Given("^I have a calculator$")
    public void i_have_a_calculator() throws Throwable {
        assertNotNull(calculator);
    }

    @When("^I add (-?\\d+) and (-?\\d+)$")
    public void i_add_and(int arg1, int arg2) throws Throwable {
        calculator.add(arg1, arg2);
    }

    @Then("^the result should be (-?\\d+)$")
    public void the_result_should_be(int result) throws Throwable {
        assertEquals(result, calculator.getResult());
    }
    
    @After  
    public void embedScreenshot(Scenario scenario) {  
            try {  
            		Path path = Paths.get("./1.png");
                byte[] screenshot = Files.readAllBytes(path);
                System.out.println("embading");
                scenario.embed(screenshot, "image/png"); 
            } catch (ClassCastException cce) {  
                cce.printStackTrace();  
            } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
    }  
}
