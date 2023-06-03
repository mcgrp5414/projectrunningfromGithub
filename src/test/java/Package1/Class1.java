package Package1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Class1 {
	WebDriver driver;
	
	@BeforeTest
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\003D2H744\\Full Stack Training\\MavenProject1\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		 
	}
	
	@Test
	public void login() 
	{
	  driver.get("https://fastaglogin.icicibank.com/");
	  driver.findElement(By.xpath("//a[contains(text(),'Customer Login')]")).click();
	  driver.findElement(By.xpath("//input[@id='rdIndividualLogin']")).click();
	  driver.findElement(By.xpath("//input[@id='chkLoginviaUsername']")).click();
	  driver.findElement(By.name("txtUserId")).sendKeys("nagagopal");
	  driver.findElement(By.name("txtPassword")).sendKeys("Mn@309187");
      driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
      String expected = "https://fastaglogin.icicibank.com/CUSTLOGIN/Pages/CustomerService/CustomerAccountSummary.aspx";
      String actual =driver.getCurrentUrl();
      if(actual.equalsIgnoreCase(expected))
      {
    	  System.out.println("Test case Passed");
    	  
      }
      else
      {
    	  System.out.println("test case failed ");
      }
	}
	  
	public void teardown()
	{
		driver.close();
	}
	
	
	

}
