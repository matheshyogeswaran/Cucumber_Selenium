package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");

	}

	@Given("^User has navigated to login page$")
	public void userHasNavigatedToLoginPage() {
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")).click();
		driver.findElement(By.linkText("Login")).click();

	}

	@When("User enters valid email address {string} into email field")
	public void userEntersValidEmailAddress(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}

	@And("User enters valid password {string} into password field")
	public void userEntersValidPassword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}

	@And("User clicks on Login button")
	public void userClicksOnLoginButton() {
		driver.findElement(
				By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"))
				.click();

	}

	@Then("User should get successfully logged in")
	public void userShouldGetSuccessfullyLoggedIn() {
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
}
