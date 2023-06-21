package ABB;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final long DEFAULT_TIME = 10;
    private WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage() {
        driver = WebDriverFactory.getDriver();
        wait = new WebDriverWait(driver, DEFAULT_TIME);
    }

    protected final WebDriver getDriver() {
        return driver;
    }


    protected void waitPresenceOfElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    protected boolean isElementPresent(By element) {
        try {
            waitPresenceOfElement(element);
            return true;
        } catch (NoSuchElementException notElement) {
            notElement.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void clickWebElement(By element) {
        try {
            driver.findElement(element).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
