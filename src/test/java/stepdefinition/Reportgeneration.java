package stepdefinition;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Reportgeneration 
{
	public static WebDriver driver;
	public static ExtentReports extent = new ExtentReports ("G:\\Intervue\\Login_Test\\Report\\intervue.html", true);; 
    public static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
    
    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = extent.startTest(scenario.getName());
        testThread.set(test);
       driver = new ChromeDriver();
    }

    @After
    public void afterScenario(Scenario scenario) throws InterruptedException {
    	WebDriver driver = getDriver();
        ExtentTest test = testThread.get();
        if (scenario.isFailed()) {
        	Thread.sleep(1000);
            test.log(LogStatus.FAIL, "Scenario failed: " + scenario.getName());
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath ="G:\\Intervue\\Login_Test\\Screenshots\\testcase_" + scenario.getName() + ".jpeg";
            try {
                FileUtils.copyFile(src, new File(screenshotPath));
                test.log(LogStatus.INFO, "Screenshot saved at: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
                test.log(LogStatus.WARNING, "Failed to save screenshot: " + e.getMessage());
            }
        } else {
            test.log(LogStatus.PASS, "Scenario passed: " + scenario.getName() );
        }
        
        if (driver != null) {
            driver.quit();  
        }

        extent.endTest(test);
        extent.flush();
		
    }

	public static WebDriver getDriver()
	{
		return driver;
	}
}



