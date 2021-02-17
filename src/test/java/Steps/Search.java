package Steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search {
    WebDriver driver;

    @Given("^I launch the browser$")
    public void iLaunchTheBrowser() {
        System.setProperty("webdriver.gecko.driver","D:\\drivers\\geckodriver.exe");
        driver= new FirefoxDriver();
        driver.manage().window().maximize();
    }


    @And("^I enter the URL to search the text$")
    public void iEnterTheURLToSearchTheText() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Duck");
        driver.findElement(By.className("gNO89b")).click();

    }

    @Then("^I verify the assertion$")
    public void iVerifyTheAssertion() {
        String verifyTxt=driver.findElement(By.xpath("//span[@text'Duck']")).getText();
        Assert.assertEquals("Duck",verifyTxt);
        driver.close();
    }
}
