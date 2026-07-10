package stepdefinations;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Steps {
    WebDriver driver;
    @Given("the user is on the nopCommerce login page")

    public void the_user_is_on_the_nop_commerce_login_page() {
         driver=new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//ul[@class='list-inline']//li[@class='dropdown']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
    }

    @When("the user enters the username {string} and password {string}")
    public void the_user_enters_the_username_and_password(String username, String Pass) {
       driver.findElement(By.xpath ("//input[@id='input-email']")).sendKeys(username);
        driver.findElement(By.xpath (  "//input[@id='input-password']")).sendKeys(Pass);

    }

    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
       driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Then("the user should be redirected to the My Account page")
    public void the_user_should_be_redirected_to_the_my_account_page() {
boolean status=driver.findElement(By.xpath("//a[normalize-space()='Account']")).isDisplayed();
Assert.assertEquals(status,true);

    }

    @Then("the user should see the welcome message")
    public void the_user_should_see_the_welcome_message() {
     boolean welcmmsg= driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
Assert.assertEquals(welcmmsg,true);
     driver.quit();


    }


}
