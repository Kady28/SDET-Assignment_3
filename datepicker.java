package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class datepicker {

WebDriver driver;

	
	@BeforeTest(enabled = true)
	public void bt() throws InterruptedException {
     
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
	@Test(enabled = true)
	public void Login() throws InterruptedException, IOException {
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/form/div[2]/div[2]/img")).click();//inspected the calender text box
		//used explicit wait for the visibility of my calender
		
		WebElement cal =driver.findElement(By.id("datepicker2"));
		
		WebDriverWait ewait= new WebDriverWait(driver, 30); 	//used explicit wait for the visibility of my calender
		ewait.until(ExpectedConditions.visibilityOf(cal));
		
		String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText(); // fetching the text of month
		
		
	    String year	= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText(); //fetching the text of year
	    
	    System.out.println(mon);
	    
	   
	    while(!(mon.equals("August")&& year.equals("2024"))) {

	    	driver.findElement(By.xpath("//a[@data-handler='next']")).click();

	    	mon = driver.findElement(By.className("ui-datepicker-month")).getText();

	    	year = driver.findElement(By.className("ui-datepicker-year")).getText();

	    	}
	}@AfterTest
	public void af() {
		driver.close();
	}
}
