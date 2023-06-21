package ABB;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    private static final By LOGINTITLE= By.xpath("//div[@class=\"main-header\"]");
    private static final By USERNAMEINPUT= By.id("userName");
    private static final By PASSWORDINPUT= By.id("password");
    private static final By LOGINBUTTONINLOGINPAGE=By.id("login");
    private static final By USERNAMELABEL=By.id("userName-label");
    private static final By USERNAMEVALUE=By.id("userName-value");

    public boolean isLoginPageLoaded(){
       return isElementPresent(LOGINTITLE);
    }
    public void introduceUserName(){
        waitPresenceOfElement(USERNAMEINPUT);
        getDriver().findElement(USERNAMEINPUT).sendKeys(WebDriverFactory.getPropertiesData("USERNAME"));

    }
    public void introducePassword(){
        waitPresenceOfElement(PASSWORDINPUT);
        getDriver().findElement(PASSWORDINPUT).sendKeys(WebDriverFactory.getPropertiesData("PASSWORD"));

    }
    public void clicksLoginButtonInLoginPage(){
        waitPresenceOfElement(LOGINBUTTONINLOGINPAGE);
        clickWebElement(LOGINBUTTONINLOGINPAGE);
    }
    public boolean isUserNameLabelDisplayed(){
        return isElementPresent(USERNAMELABEL);

    }
    public boolean isUserNameValueDisplayed(){
        System.out.println(getDriver().findElement(USERNAMEVALUE).getText());
        return getDriver().findElement(USERNAMEVALUE).getText().equals(WebDriverFactory.getPropertiesData("USERNAME"));
    }
}
