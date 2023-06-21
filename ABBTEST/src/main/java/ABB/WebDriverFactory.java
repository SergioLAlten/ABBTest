package ABB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    private static ThreadLocal<ChromeDriver> driverThreadLocal = new ThreadLocal<ChromeDriver>();
    private static Properties properties = new Properties();
    private static final String pathToPropertiesFile = "src/test/resources/configuration.properties";
    private static final Logger LOGGER = LogManager.getLogger(WebDriverFactory.class);

    public Properties getProperties(){
        return properties;
    }
    public static void setup() throws Exception {

        properties.load(new BufferedReader(new FileReader(pathToPropertiesFile)));

        setDriver(properties.getProperty("URL"));

    }

    private static void setDriver(String url) throws IOException {

        WebDriverManager.chromedriver().setup();
        driverThreadLocal.set(new ChromeDriver());
        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverThreadLocal.get().get(url);
    }
    public static void closeSetup() {
        driverThreadLocal.get().quit();
    }

    public static ChromeDriver getDriver() {
        return driverThreadLocal.get();
    }
    public static String getPropertiesData(String arg){
        return properties.getProperty(arg);
    }
}
