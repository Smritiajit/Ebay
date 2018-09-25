package cucumber.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GumTreePage extends DriverInt{
	List<String> gumTreeList = new ArrayList<String>();
	List<String> gumTreeTitle = new ArrayList<String>();
	List<Integer> noOfRecords = new ArrayList<Integer>();
	
	
	public void clickGumtree(List list ) throws InterruptedException
	{
		gumTreeList.addAll(list);
		
		for (String element : gumTreeList)
		{
		driver.findElement(By.linkText(element)).click();
		Thread.sleep(2000L);
		gumTreeTitle.add(driver.getTitle());
		List<WebElement> productList = driver.findElements(By.xpath("//ul[@data-q='featuredresults' or @data-q='naturalresults']/li/article"));
		noOfRecords.add(productList.size());
        System.out.println("Title of link :" + driver.getTitle());
        Thread.sleep(2000L);
        driver.navigate().back();
		}
	}
	
	public boolean checkTitle()
	{
		int flag = 0;
		for (String element : gumTreeTitle)
		{
			if(!gumTreeTitle.isEmpty())
			{
				if(gumTreeTitle.contains("gumTree") || gumTreeTitle.contains("gumtree"))
				{
					flag++;
				}
				else 
				{
					System.out.println("Title not proper");
				}
				
			}
			
		}
		if(flag == gumTreeTitle.size())
		{
		return true;
		}
		else
			return false;
	}
	
	public boolean recordsDisplayed()
	{
		boolean flag = true;
		
		for (int i=0;i<= noOfRecords.size();i++)
		{
			if(noOfRecords.get(i).toString().equalsIgnoreCase("0"))
			{
				System.out.println("Gumtree" +i +" link has no car records");
				flag = false;
				break;
				
			}
			
				
		}
		return flag;
		
	}
	
	

}
