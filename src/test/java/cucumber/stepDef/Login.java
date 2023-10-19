package cucumber.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.tests.TestBase;


public class Login extends TestBase {

    @Before
    public void setUp() {
        setUpDriver();
        driver = getDriver();
    }
    @After
    public void tearDown() {
        quitDriver();
    }

    @Given("^User in the login page$")
    public void user_in_the_login_page(){
        String url_verify = driver.getCurrentUrl();
        Assert.assertEquals(baseUrl, url_verify);
    }
    @When("^User input (.*) as registered username$")
    public void user_input_username_as_registered_username(String username){
        driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys(username);
    }
    @And("^User input (.*) as correct password$")
    public void user_input_password_as_correct_password(String password){
        driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys(password);
    }
    @And("^User click Login button$")
    public void user_click_login_button (){
        driver.findElement(By.cssSelector("input[data-test='login-button']")).click();
    }
    @Then("^User will be redirected to homepage with (.*) login results$")
    public void user_will_be_redirected_to_homepage_with_status_loginresults (String status) {
        String verify_success = driver.findElement(By.cssSelector(".app_logo")).getText();
        Assert.assertEquals("Swag Labs",verify_success);
    }
    @And("^User input (.*) as incorrect password$")
    public void user_input_password_as_incorrect_password(String password) {
        driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys(password);
    }
    @Then("^User view the alert message that status user is (.*)$")
    public void user_view_the_alert_message_that_status_user_is_status(String status) {
        if(status.equals("invalid_password")){
            String ermsg_invalidpass = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
            Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", ermsg_invalidpass);
        } else {
            String ermsg_invalidpass = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
            Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", ermsg_invalidpass);
        }
    }

}
