package pageObjects;

import java.time.Duration;

import org.openqa.selenium.*;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        driver.findElement(By.linkText("Login")).click();
    }
    
    public void clickCompanyLogin() {
    	driver.findElement(By.xpath("//a[@href='/login']/div[text()='Login']")).click();
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("login_email")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("login_password")).sendKeys(password);
    }

    public void clickSearch() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	WebElement searchButton = driver.findElement(By.className("//span[contains(@class,'HeaderSearch__SearchLensIconWrap')]"));
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    	searchButton.click();
    }
    
    public void searchTask() throws InterruptedException {
    	driver.findElement(By.xpath("//input[@placeholder='Type what you want to search for']")).sendKeys("hello");
    	driver.findElement(By.xpath("//span[text()='hello']")).click();
    }
    public void Direct_hellopage() throws InterruptedException {
    	driver.get("https://www.intervue.io/profile/search/interviews?query=hello");
    }
    public void logout() throws InterruptedException {
    	driver.findElement(By.className("cwhrSp")).click();
    	driver.findElement(By.cssSelector("a[href='/logout']")).click();

    }
    
    
    public void clickLoginButton() throws InterruptedException {

    	driver.findElement(By.xpath("//button[@type='submit' and .//span[text()='Login with email']]")).click();
    }
}