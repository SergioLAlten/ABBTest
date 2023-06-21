package steps;

import ABB.Api;
import ABB.BooksPage;
import ABB.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Steps {
    private BooksPage booksPage =new BooksPage();
    private LoginPage loginPage =new LoginPage();
    private Api api=new Api();
    @Given("^The user is in book list page$")
    public void the_user_is_in_book_list_page()  {
        Assert.assertTrue(booksPage.isTitleDisplayed());

    }
    @Given("^The Input search box is displayed$")
    public void the_Input_search_box_is_displayed()  {
        Assert.assertTrue(booksPage.isSearchBoxDisplayed());
        Assert.assertTrue(booksPage.isPageLoaded());
    }

    @Given("^The input search box button is displayed and clickable$")
    public void the_input_search_box_button_is_displayed_and_clickable() {
        Assert.assertTrue(booksPage.isSearchBoxDisplayed());
    }

    @Given("^The List books is displayed$")
    public void the_List_books_is_displayed()  {
        Assert.assertTrue(booksPage.isBooksListDisplayed());

    }
    @When("^The user introduces \"([^\"]*)\" in text input$")
    public void the_user_introduces_in_text_input(String arg1)  {
        booksPage.enterData(arg1);
    }

    @Then("^The books list refresh and show \"([^\"]*)\" books that contains the text$")
    public void the_books_list_refresh_and_show_books_that_contains_the_text(int arg1) {
        Assert.assertEquals(booksPage.getNumberBooks(), arg1);
    }
    @When("^The user clicks in log in button$")
    public void the_user_clicks_in_log_in_button()  {
        booksPage.clicksInLogin();
    }

    @When("^The user is redirected to login page$")
    public void the_user_is_redirected_to_login_page()  {
        Assert.assertTrue(loginPage.isLoginPageLoaded());
    }

    @When("^The user introduces the user name in username input$")
    public void the_user_introduces_the_user_name_in_username_input()  {
        loginPage.introduceUserName();
    }

    @When("^The user introduces the password in password input$")
    public void the_user_introduces_the_password_in_password_input()  {
        loginPage.introducePassword();
    }

    @When("^The user clicks in log in button in log in page$")
    public void the_user_clicks_in_log_in_button_in_log_in_page()  {
        loginPage.clicksLoginButtonInLoginPage();
    }

    @Then("^The user is logged$")
    public void the_user_is_logged()  {
        Assert.assertTrue(loginPage.isUserNameLabelDisplayed());
        Assert.assertTrue(loginPage.isUserNameValueDisplayed());
    }
    @Given("^I send a GET request to fetch book information$")
    public void i_send_a_GET_request_to_fetch_book_information()  {
      api.sendGetRequest();

    }
    @When("^the response should have a status code of (\\d+)$")
    public void the_response_should_have_a_status_code_of(int arg1)  {
        Assert.assertTrue(api.verifyStatusCode(arg1));
    }
    @Then("^the response should contain the title and author of the book$")
    public void the_response_should_contain_the_title_and_author_of_the_book()  {
        Assert.assertTrue(api.getTitleandAuthor());
    }



}






