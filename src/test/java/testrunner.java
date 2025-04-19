import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features = {"src/test/resources/features"},glue = {"stepdefinition"},tags = "@login")
public class testrunner extends AbstractTestNGCucumberTests
{
}