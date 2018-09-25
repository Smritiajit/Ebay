package cucumber.step;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.page.GooglePage;
import cucumber.page.GumTreePage;

public class TaskOneStep {
	GooglePage googlePage = new GooglePage();
	GumTreePage gumTreePage = new GumTreePage();


@Given("^user launch Google$")
public void user_launch_Google() throws Throwable {
	googlePage.launchBrowser();
	googlePage.openURL();
    
}

@When("^searched for \"([^\"]*)\"$")
public void searched_for(String arg1) throws Throwable {
	googlePage.search(arg1);
   
}

@Then("^on first page user can see Gumtree link$")
public void on_first_page_user_can_see_Gumtree_link() throws Throwable {
   int num =googlePage.gumtreeLinks();
   assertTrue(num > 0);
   
    
}

@Then("^check number of Gumtree links on the page\\.$")
public void check_number_of_Gumtree_links_on_the_page() throws Throwable {
	 int num =googlePage.gumtreeLinks();
    System.out.println("There are "+num+ " Gumtree links present on 1st page");
}

@Given("^user wants to search \"([^\"]*)\" on Google$")
public void user_wants_to_search_on_Google(String arg1) throws Throwable {
	googlePage.launchBrowser();
	googlePage.openURL();
	googlePage.search(arg1);
    
}

@When("^user clicks on Gumtree links$")
public void user_clicks_on_Gumtree_links() throws Throwable {
	int num =googlePage.gumtreeLinks();
	assertTrue(num > 0);
	gumTreePage.clickGumtree(googlePage.getLinks());
   
}

@Then("^check title displayed in each link\\.$")
public void check_title_displayed_in_each_link() throws Throwable {
   Boolean check =gumTreePage.checkTitle();
   assertTrue(check);
   
}

@Then("^validate No of Car displayed as result > (\\d+)\\.$")
public void validate_No_of_Car_displayed_as_result(int arg1) throws Throwable {
	boolean result = gumTreePage.recordsDisplayed();
	assertTrue(result);
   
}

@Then("^no Gumtree link is displayed\\.$")
public void no_Gumtree_link_is_displayed() throws Throwable {
	int num =googlePage.gumtreeLinks();
    
}


@Before (order= 0)
public void testing()
{
	System.out.println("*****************Testing Starts*******************");
}

@After (order= 1)
public void testingEnd()
{
	System.out.println("*******************Testing Ends********************");
}
}
