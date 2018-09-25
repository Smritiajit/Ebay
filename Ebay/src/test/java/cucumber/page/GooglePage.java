package cucumber.page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage extends DriverInt {
	@FindBy(how = How.NAME,using = "q")
	WebElement textbox;
	
	@FindBy(how = How.NAME,using = "btnK")
	WebElement searchbtn;
	
	List<String> gumTreeLink = new ArrayList<String>();
	
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "E://New folder//Downloads//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void openURL() 
	{
		driver.get("http://www.google.com");
	}
		
	public void search(String arg1)
	{
		String searchStr = arg1;
		if(textbox.isDisplayed())
		{
			textbox.sendKeys(searchStr);
			searchbtn.click();
		} 
		else
		{
			System.out.println("Searchbox not displayed");
		}
	}
	
	public int gumtreeLinks() throws InterruptedException
	{
		List<WebElement> linkElements = driver.findElements(By.xpath("//h3[@class='r']/a"));
		int noOfGumtree = 0;
		
		for (WebElement element : linkElements)
			 
		  {
	 
			  if(element.getText().contains("gumtree"))
			  {
				  noOfGumtree++; 
				  gumTreeLink.add(((WebElement) linkElements).getText());
	            
	          } 
	      }
	 return noOfGumtree;
	}
	
	public List getLinks()
	{
		return gumTreeLink;
	}
	

}
