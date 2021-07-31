package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Step1: Setup the chrome driver
		WebDriverManager.chromedriver().setup();
		//String property = System.getProperty("webdriver.chrome.driver","path");
		//System.out.println(property);
		//Step2: Instantiate the driver and launch the browser
		ChromeDriver driver= new ChromeDriver();
		//Step3: Load the URL using get method
		driver.get("https://acme-test.uipath.com/login");
		//Step4: Maximize the window
		driver.manage().window().maximize();
		//inspect the web elements email and password and enter the values
		WebElement field1 = driver.findElementById("email");
		field1.sendKeys("kumar.testleaf@gmail.com");
		//WebElement field2= driver.findElement(By.id("password"));
		//field2.sendKeys("leaf@12");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		String loginTitle="ACME System 1 - Log In"; 
		System.out.println(loginTitle);
		String logTitle=driver.getTitle();
		System.out.println(logTitle);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String pageTitle="ACME System 1 - Dashboard";
		String pgeTitle=driver.getTitle();
		
		if (pageTitle.equals(pgeTitle)) 
		{
			System.out.println("Page landed up correctly");
		System.out.println("Title of the page is: "+pgeTitle);
		}
			else
				System.out.println("Page not loaded correctly");
		
		driver.findElementByLinkText("Log Out").click();
		driver.close();
		
	
	}

}
