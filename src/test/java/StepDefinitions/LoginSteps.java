package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import utilities.DriverManager;

import java.io.IOException;
import java.time.Duration;

public class LoginSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setUp() throws IOException {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }
    @Given("User open the browser and navigate to the login page")
    public void i_open_the_browser_and_navigate_to_the_login_page() {
        driver.get("https://leap.secp.gov.pk/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@color='primary']"))).click();

    }

    @When("User log in with {string} and {string}")
    public void i_log_in_with_and(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-0"))).sendKeys(username);
        driver.findElement(By.id("mat-input-1")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("User navigate to the Reserved Names section")
    public void i_navigate_to_the_reserved_names_section() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'MENU')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='menu-sidebar__option__button-text mat-h3'][normalize-space()='Home']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'MENU')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='menu-sidebar__option__button-text mat-h3'][normalize-space()='Reserved Names']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@color='primary']"))).click();
    }

    @Then("User proceed to reserve a name for a new LLP")
    public void i_proceed_to_reserve_a_name_for_a_new_llp() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Reservation of name for incorporation of a new llp')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='PROCEED']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'SELECT')])[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-radio-container']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='PROCEED']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='menu']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-3"))).sendKeys("azaan");
        driver.findElement(By.xpath("//button[contains(.,'Check availability')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//mat-icon[normalize-space()='arrow_back']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@title='Close']")).click();


    }

    @Then("User is logged out successfully")
    public void i_close_the_browser() {
        driver.findElement(By.className("user-profile__user-info")).click();
        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[2]")).click();
    }
    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
