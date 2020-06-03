import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownloadConcept_Chrome
{
	@Test
	public void test() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Piyush\\RadicalAutomation\\RadicalSoftwares\\chromedriver_win32_B39\\chromedriver.exe");
		String downloadPath = System.getProperty("user.dir")+"\\DownloadedFiles\\";
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath); //This step will set the download path.
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("http://only-testing-blog.blogspot.in/2014/05/login.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Download Text File')]")).click();
		
	}
}
