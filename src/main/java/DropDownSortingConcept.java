import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownSortingConcept 
{

	@Test
	public void test() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Piyush\\RadicalAutomation\\RadicalSoftwares\\chromedriver_win32_B39\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Piyush/RadicalAutomation/Piyush%20Dummy%20Website/PiyushDropdownSorting.html");
		driver.findElement(By.id("cars")).click();
		List<WebElement> dropdownOptions = driver.findElements(By.xpath("//select/option"));
		List<String> data = new ArrayList<String>();
		
		System.out.println("============Before Sorting Data====================");
		for(int i=0; i<dropdownOptions.size(); i++)
		{
			String dropdownValue = dropdownOptions.get(i).getText();
			data.add(dropdownValue);
			System.out.println(dropdownValue);
		}
		
		List<String> data2 = new ArrayList<String>();
		data2 = data;
		
		//Sort data in ascending order
		Collections.sort(data);
		System.out.println("============After Sorting Data in Ascending Order====================");
		for(int i=0; i<data.size(); i++)
		{
			System.out.println(data.get(i));
		}
	
		//Sort data in descending order
		Collections.reverse(data);
		System.out.println("============After Sorting Data in Descending Order====================");
		for(int i=0; i<data.size(); i++)
		{
			System.out.println(data.get(i));
		}
		
		Assert.assertTrue(data.equals(data2));
	}
}
