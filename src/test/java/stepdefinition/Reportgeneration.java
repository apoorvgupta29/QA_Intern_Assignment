package stepdefinition;


import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Reportgeneration 
{
	public static ExtentReports extent;
	public static ExtentTest test; 
	public static WebDriver driver;


	
	@Before
	public void start(Scenario s)
	{
		if(extent==null)
		{	
			extent = new ExtentReports ("G:\\Intervue\\Login_Test\\Report\\intervue.html", true);
		}
		driver = new ChromeDriver();
		String tc = s.getName();
		test = extent.startTest(tc);
	}

	@After
	public void afterScenario(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			test.log(LogStatus.FAIL, "Test is failed");
			File scrFile;
			scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile, new File("G:\\Intervue\\Login_Test\\Screenshots\\testcase_" + scenario.getName() +  ".jpeg"));  
		}
		else {
			test.log(LogStatus.PASS, "Test is pass");
		}
		driver.quit();
		extent.flush();
	}

	public static WebDriver getDriver()
	{
		return driver;
	}
}



