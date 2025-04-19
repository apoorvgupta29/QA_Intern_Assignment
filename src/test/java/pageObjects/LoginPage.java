package pageObjects;

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
    	Thread.sleep(2000);
    	driver.findElement(By.className("HeaderSearch__SearchLensIconWrap")).click();
    	Thread.sleep(2000);
    }
    
    public void searchTask() throws InterruptedException {
    	driver.findElement(By.xpath("//input[@placeholder='Type what you want to search for']")).sendKeys("hello");
        Thread.sleep(5000);
    	driver.findElement(By.xpath("//span[text()='hello']")).click();
    }
    
    public void logout() throws InterruptedException {
    	driver.findElement(By.className("cwhrSp")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.cssSelector("a[href='/logout']")).click();
        Thread.sleep(5000);
    }
    
    
    public void clickLoginButton() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//button[@type='submit' and .//span[text()='Login with email']]")).click();
        Thread.sleep(5000);
    }
}