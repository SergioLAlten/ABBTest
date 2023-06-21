package ABB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BooksPage extends BasePage {
    private static final By TITLELISTBOOKS=By.xpath("//div[@class=\"main-header\"]");
    private static final By INPUTSEARCHBOX= By.id("searchBox");
    private static final By BOOKSLIST= By.xpath("//div[@class=\"ReactTable -striped -highlight\"]");
    private static final By EACHBOOK=By.xpath("//div[@class=\"rt-tr -odd\"] |//div[@class=\"rt-tr -even\"]");
    private static final By LOGINBUTTON=By.id("login");

    public boolean isPageLoaded(){
        return getDriver().getCurrentUrl().equals("https://demoqa.com/books");
    }
    public boolean isTitleDisplayed(){
        if(getDriver().findElement(TITLELISTBOOKS).getText().equals("Book Store")){
            return true;
         }else{
            return false;
        }
    }
    public boolean isSearchBoxDisplayed(){
       return isElementPresent(INPUTSEARCHBOX);
    }
    public boolean isBooksListDisplayed(){
        return isElementPresent(BOOKSLIST);
    }
    public void enterData(String arg){
        getDriver().findElement(INPUTSEARCHBOX).sendKeys(arg);
    }
    public int getNumberBooks(){
        List<WebElement> books=getDriver().findElements(EACHBOOK);
        return books.size();
    }
    public void clicksInLogin(){
    waitPresenceOfElement(LOGINBUTTON);
    clickWebElement(LOGINBUTTON);

    }
}
