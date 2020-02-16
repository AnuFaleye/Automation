package ourPeople;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class OctopusPeoplePage {

	@Test
	public void Searchfield() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anufa\\Documents\\chromedriver.exe");		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Get URL
		driver.get("https://octopusinvestments.com/investor/about-us/our-people/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Click continue on pop up
		driver.findElement(By.cssSelector("#info-modal > div.pop-up-info_bottom > div > button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Enter name in search field and click
		driver.findElement(By.name("search")).sendKeys("Chloe Allan");
		driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div[1]/section/div[2]/form/div[1]/label/span/img")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Verify name
		WebElement element = driver.findElement(By.xpath("//*[@id=\"grid\"]/div/a/h2"));
		System.out.println(element.getText());	
		//driver.close();
	}
	
	@Test
	public void Image() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anufa\\Documents\\chromedriver.exe");		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Get URL
		driver.get("https://octopusinvestments.com/investor/about-us/our-people/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Click continue on pop up
		driver.findElement(By.cssSelector("#info-modal > div.pop-up-info_bottom > div > button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Click on an image
		driver.findElement(By.xpath("//*[@id=\"grid\"]/div[1]/a/div/img")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Verify profile
		WebElement element = driver.findElement(By.xpath("/html/body/main/section/div/div/div[2]/div[1]"));
		System.out.println(element.getText());
		//driver.close();
	}
	
	@Test
	public void SortbyAtoZ() throws InterruptedException {
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
	
	@Test
	public void SortbyZtoA() throws InterruptedException {
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
		
		//Select Z-A in dropdown
		Select s=new Select(driver.findElement(By.name("order")));
		s.selectByValue("title-DESC");
		
		//Select grid and print name in DESC order
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

