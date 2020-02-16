package people;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Image {

	public static void main(String[] args) {
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
		
		//Click on an image
		driver.findElement(By.xpath("//*[@id=\"grid\"]/div[1]/a/div/img")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Verify profile
		WebElement element = driver.findElement(By.xpath("/html/body/main/section/div/div/div[2]/div[1]"));
		System.out.println(element.getText());
		//driver.close();
	}

}
