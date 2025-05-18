package junit.gradle.feature.stepdefs;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private String username;
    private String password;
    private boolean loginSuccess;

    @Given("I have a valid username and password")
    public void i_have_a_valid_username_and_password() {
        // You could set these from a mock user or a test config
        username = "testUser";
        password = "testPass";
    }

    @When("I submit the login form")
    public void i_submit_the_login_form() {
        // Simulate submitting the login form
        loginSuccess = (username.equals("testUser") && password.equals("testPass"));
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        // Assertion for the login success
        assertTrue(loginSuccess, "Login should be successful.");
    }
}
