package steps;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ABB.WebDriverFactory;


public class Hooks {
    private static final Logger LOGGER = LogManager.getLogger(Hooks.class);
    private Scenario scenario = null;


    @Before
    public void setup(Scenario scenario) throws Exception{
        LOGGER.info("setup");
        WebDriverFactory.setup();
        this.scenario = scenario;

    }
    @After
    public void tearDown(Scenario scenario)  {
        LOGGER.info("tearDown");
        WebDriverFactory.closeSetup();
    }

}
