package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "classpath:cucumber" ,
            glue = "steps",
            monochrome = true,
            format = "json:target/cucumber-json-report.json"
    )
    public class RunTest {

}
