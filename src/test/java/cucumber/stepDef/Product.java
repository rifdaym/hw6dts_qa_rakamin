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
import org.openqa.selenium.WebElement;
import cucumber.tests.TestBase;
import java.util.List;
import java.util.Objects;

public class Product extends TestBase {
    String username_default = "standard_user";
    String password_default = "secret_sauce";
    String detailprod_verify = "Sauce Labs Backpack";
    String[] product_verify = {
            "Sauce Labs Backpack",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie",
            "Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt"
    };

    @Before
    public void setUp() {
        setUpDriver();
        driver = getDriver();
    }
    @After
    public void tearDown() {
        quitDriver();
    }

    /***************
     * PRODUCT
     ****************/
    @Given("^The user in on the homepage$")
    public void theUserInOnTheHomepage() {
        driver.findElement(By.cssSelector("input[data-test='username']")).sendKeys(username_default);
        driver.findElement(By.cssSelector("input[data-test='password']")).sendKeys(password_default);
        driver.findElement(By.cssSelector("input[data-test='login-button']")).click();
        String verify_success = driver.findElement(By.cssSelector(".app_logo")).getText();
        Assert.assertEquals("Swag Labs",verify_success);
        //String url_verify = driver.getCurrentUrl();
        //Assert.assertEquals(baseUrl, url_verify);
        String homepage = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Products", homepage);
    }
    @When("^user click All Items Menu$")
    public void userClickAllItemsMenu() {
        driver.findElement(By.cssSelector("button#react-burger-menu-btn")).click();
        driver.findElement(By.cssSelector("a#inventory_sidebar_link")).click();
    }
    @Then("^user can view the list product page$")
    public void userCanViewTheListProductPage() {
        List<WebElement> product_names = driver.findElements(By.cssSelector(".inventory_item_name"));

        for(int i=0; i < product_verify.length; i++) {
            for (WebElement name : product_names) {
                if (Objects.equals(product_verify[i], name.getText())) {
                    System.out.println(product_verify[i] + name.getText());
                    Assert.assertEquals(product_verify[i], name.getText());
                }
            }
        }
    }
    @When("^user click product$")
    public void userClickProduct() {
        driver.findElement(By.cssSelector(".inventory_list .inventory_item:nth-of-type(1) .inventory_item_name")).click();
    }
    @Then("^user can view the detail product page$")
    public void userCanViewTheDetailProductPage() {
        String detail_product = driver.findElement(By.cssSelector(".inventory_details_name.large_size")).getText();
        Assert.assertEquals(detailprod_verify, detail_product);
    }


    /********************
     * CHECKOUT PRODUCT
     *******************/
    @When("the user clicks the Add to Cart button on one of the products")
    public void theUserClicksTheAddToCartButtonOnOneOfTheProducts() {
        driver.findElement(By.cssSelector("button[data-test='add-to-cart-sauce-labs-backpack']")).click();
    }
    @And("User click on icon cart")
    public void userClickOnIconCart() {
        driver.findElement(By.cssSelector("div#shopping_cart_container > .shopping_cart_link")).click();
    }
    @And("User click Checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.cssSelector("button[data-test='checkout']")).click();
    }
    @And("User input valid first name")
    public void userInputValidFirstName() {
        driver.findElement(By.cssSelector("input[data-test='firstName']")).sendKeys("Test Nama");
    }
    @And("User input valid last name")
    public void userInputValidLastName() {
        driver.findElement(By.cssSelector("input[data-test='lastName']")).sendKeys("Test Last Name");
    }
    @And("User input valid postal code")
    public void userInputValidPostalCode() {
        driver.findElement(By.cssSelector("input[data-test='postalCode']")).sendKeys("Test Postalcode");
    }
    @And("User click Continue button")
    public void userClickContinueButton() {
        driver.findElement(By.cssSelector("input[data-test='continue']")).click();
    }
    @And("User click Finish button")
    public void userClickFinishButton() {
        driver.findElement(By.cssSelector("button[data-test='finish']")).click();
    }
    @Then("User view the Order Success Page")
    public void userViewTheOrderSuccessPage() {
        String txt_success = driver.findElement(By.cssSelector("div#checkout_complete_container > .complete-header")).getText();
        Assert.assertEquals("Thank you for your order!", txt_success);
        String title_complete = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals("Checkout: Complete!", title_complete);
    }
    @And("User skip fill the form, after that click Continue button")
    public void userSkipFillTheFormAfterThatClickContinueButton() {
        driver.findElement(By.cssSelector("input[data-test='continue']")).click();
    }
    @Then("User view the alert message that field must be filled out")
    public void userViewTheAlertMessageThatFieldMustBeFilledOut() {
        String txt_failed = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue(txt_failed.contains("Error"));
    }
}
