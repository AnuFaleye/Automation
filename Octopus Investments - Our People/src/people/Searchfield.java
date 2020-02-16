package people;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Searchfield {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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

}
