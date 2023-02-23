package DataDriven;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loginDataDriven {
	WebDriver driver;
	@BeforeTest
	public void openbrowser(){
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	
	@Test	
	public void testfb() throws IOException, InterruptedException{
		String [][] dataip = FetchDataExcel.readexcel("TestData", "Data");
		
		for(int i=1; i<dataip.length ; i++){//to avoid the heading
			String user = dataip[i][0];
			String pass = dataip[i][1];
			
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(user);
		System.out.println(user);
		driver.findElement(By.name("pass")).sendKeys(pass);
		//driver.findElement(By.name("login")).click();
		//driver.findElement(By.className("_9ai5")).click();
		WebElement fplink=driver.findElement(By.linkText("Forgotten password?"));
		fplink.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().back();
		}
	}
	@AfterTest
	public void close(){
		driver.close();
	}}

