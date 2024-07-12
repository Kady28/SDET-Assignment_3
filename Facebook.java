package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {


WebDriver driver;

	
	@BeforeTest(enabled = true)
	public void bt() throws InterruptedException {
     
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/signup");
		
		driver.manage().window().maximize();
		
	}
	@Test(enabled = true)
	public void Login() throws InterruptedException, IOException {
		//i want to signup to facebook
		//first name
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("virat");
		//last name
    	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("kohli");
    	//email address
    	driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("kohli@gmail.com");
    	//password
    	driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("kohli@123*#");
    	
    	Thread.sleep(2000);
    	//Re-enter email address
    	driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("kohli@gmail.com");
    	driver.findElement(By.xpath("//select[@id='day']")).click();
    	driver.findElement(By.xpath("//*[@id=\"day\"]/option[5]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//select[@id='month']")).click();
    	driver.findElement(By.xpath("//*[@id='month']/option[11]")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//select[@id='year']")).click();
    	driver.findElement(By.xpath("//*[@id=\"year\"]/option[37]")).click();
    	Thread.sleep(2000);
    	//click on male button
    	driver.findElement(By.xpath("//label[text()='Male']")).click();
    	//click on signup
    	driver.findElement(By.name("websubmit")).click();


		
		
		
		

   }
	@AfterTest
	public void af() {
		driver.close();
	}
}
