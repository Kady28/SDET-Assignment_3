package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_3 {

	


		WebDriver driver;

			
			@BeforeTest(enabled = true)
			public void bt() throws InterruptedException {
		     
				WebDriverManager.chromedriver().setup();
				
				driver=new ChromeDriver();
				
				driver.get("https://www.ebay.com/");
				
				driver.manage().window().maximize();
				
			}
			@Test(enabled = true)
			public void Login() throws InterruptedException, IOException {
				Thread.sleep(3000);
		    
				WebElement ele = driver.findElement(By.xpath("(//a[text()='Electronics'])[2]"));

				//Creating object of an Actions class
				Actions action = new Actions(driver);

				//Performing the mouse hover action on the target element.
				action.moveToElement(ele).perform();
				
				WebElement fas = driver.findElement(By.xpath("(//a[text()='Fashion'])[2]"));

				//Creating object of an Actions class
				Actions action1 = new Actions(driver);

				//Performing the mouse hover action on the target element.
				action.moveToElement(fas).perform();
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("window.scrollBy(0,350)", "");
			    
			    WebElement Re = driver.findElement(By.xpath("//h3[normalize-space()='Refurbished']"));

				//Creating object of an Actions class
				Actions action2 = new Actions(driver);

				//Performing the mouse hover action on the target element.
				action.moveToElement(Re).perform();
			    
			    
				

		   }
			@AfterTest
			public void af() {
				driver.close();
			}
		}

