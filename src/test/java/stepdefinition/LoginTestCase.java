package stepdefinition;

import java.util.Set;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;


public class LoginTestCase  {

    WebDriver driver;
    LoginPage loginPage;
    
	@Given("User is in Home page and Navigate to login page")
		public void User_is_in_Home_page_and_navigate_to_login_page() throws InterruptedException {	
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.intervue.io");
        loginPage = new LoginPage(driver);
        loginPage.clickLoginLink();
        String originalWindow = driver.getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(driver -> driver.getWindowHandles().size() > 1);
        Set<String> windowHandles = driver.getWindowHandles();

        for (String window : windowHandles) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        
        loginPage.clickCompanyLogin();
	}
	
	@When("User enters user name {string} and  password {string}")
	public void user_enters_user_name_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
	}

	@When("Submit the form and check credentials")
		public void submit_the_form_and_check_credentials() throws InterruptedException {
		loginPage.clickLoginButton();
		Thread.sleep(5000);
	}
	
	@When("User performs some actions")
		public void user_performs_some_actions() throws InterruptedException {
		loginPage.clickSearch();
		Thread.sleep(2000);
		loginPage.searchTask();
		Thread.sleep(2000);
	}

	@Then("User log out successfully")
	public void user_log_out_successfully() throws InterruptedException {
		loginPage.logout();
        driver.quit();
	}


}
