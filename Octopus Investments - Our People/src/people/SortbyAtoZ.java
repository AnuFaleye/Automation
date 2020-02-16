package people;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortbyAtoZ {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anufa\\Documents\\chromedriver.exe");		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Get URL
		driver.get("https://octopusinvestments.com/investor/about-us/our-people/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click continue on pop up
		driver.findElement(By.cssSelector("#info-modal > div.pop-up-info_bottom > div > button")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("scroll(0,1000)");
		Thread.sleep(5000);
		
		//Select A-Z in dropdown 
		Select s=new Select(driver.findElement(By.name("order")));
		s.selectByValue("title-DESC");
		Thread.sleep(3000);
		s.selectByValue("title-ASC");
		
		//Select grid and print name in ASC order
		WebElement table=driver.findElement(By.cssSelector("div[class='search-result row']"));
		int rowcount= table.findElements(By.cssSelector("div[class='search-result_item col-sm-6 is-shown']")).size();
		int count=table.findElements(By.cssSelector("div[class='search-result_item col-sm-6 is-shown'] > a > h2")).size();
		for(int i=0;i<count;i++)
		{
			System.out.println(table.findElements(By.cssSelector("div[class='search-result_item col-sm-6 is-shown'] > a > h2")).get(i).getText());
			//driver.close();
		}
	}
	
}
		
	


