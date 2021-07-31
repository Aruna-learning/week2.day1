package week2.day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentTwoCreateLeads {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
	//Launch leaftaps URL and login using username and password
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
	//click the CRM/SFA link in the dashboard followed by Leads and Create Leads page
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
	//inspect all create leads page fields via Locators
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		String firstNametoEnter="Aruna";
		driver.findElementById("createLeadForm_firstName").sendKeys(firstNametoEnter);
		
		driver.findElementById("createLeadForm_lastName").sendKeys("Srinivasan");
		driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Arun");
		driver.findElementById("createLeadForm_lastNameLocal").sendKeys("Srini");
		driver.findElementById("createLeadForm_personalTitle").sendKeys("Mrs");
		driver.findElementById("createLeadForm_birthDate").sendKeys("03/27/86");
		driver.findElementById("createLeadForm_generalProfTitle").sendKeys("Test Lead");
		driver.findElementById("createLeadForm_departmentName").sendKeys("QA");
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("10000");
		driver.findElementById("createLeadForm_numberEmployees").sendKeys("10");
		driver.findElementById("createLeadForm_sicCode").sendKeys("abc");
		driver.findElementById("createLeadForm_tickerSymbol").sendKeys("R");
		driver.findElementById("createLeadForm_description").sendKeys("This is a test description");
		driver.findElementById("createLeadForm_importantNote").sendKeys("This is an Important Notice");
	//Inspect all web elements in Contact Information by XPath
		WebElement countryCode=driver.findElementById("createLeadForm_primaryPhoneCountryCode");
	//Clear the default country code value 1
		countryCode.clear();
		Thread.sleep(2000);
	//passing the new country code value using sendkeys method
		countryCode.sendKeys("2");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneAreaCode']").sendKeys("044");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneNumber']").sendKeys("8786");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneExtension']").sendKeys("9798979");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneAskForName']").sendKeys("Aruna");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryEmail']").sendKeys("sampath.aruna@gmail.com");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryWebUrl']").sendKeys("www.google.com");
	//Inspect all web elements in Primary Address section by locators/xpath
		driver.findElementById("createLeadForm_generalToName").sendKeys("Aruna Srinivasan");
		driver.findElementByXPath("//input[@name='generalAttnName']").sendKeys("Aruna Sri");
		driver.findElementByXPath("//input[@name='generalAddress1']").sendKeys("15,Srisailam");
		driver.findElementByXPath("//input[@name='generalAddress2']").sendKeys("Elagovan Street");
		driver.findElementByXPath("//input[@id='createLeadForm_generalCity']").sendKeys("Chennai City");
		driver.findElementById("createLeadForm_generalPostalCode").sendKeys("73");
		driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("600073");
	//inspecting drop down field and selecting a value from the list
		WebElement dd1=driver.findElementById("createLeadForm_generalCountryGeoId");
		Select drpDwn1=new Select(dd1);
		drpDwn1.selectByIndex(2);
	//final submit in the Create Leads screen
		driver.findElementByClassName("smallSubmit").click();
	//getting the text entered in first name field and displaying it. 
	//also compare whether the correct text value is printed using if condition
		String fName = driver.findElementById("viewLead_firstName_sp").getText();
		System.out.println("The first name is: "+fName);
		
		if (firstNametoEnter.equals(fName))
			System.out.println("Correct Name");
		else
			System.out.println("Wrong name");
	//Verifying the title of the page and printing to confirm whether the landing page is correct	
		String newTitle="View Lead | opentaps CRM";
		String newpTitle=driver.getTitle();
		
		if (newTitle.equals(newpTitle)) 
		{
			System.out.println("Page landed up correctly");
		System.out.println("Title of the page is: "+newpTitle);
		}
			else
				System.out.println("Page not loaded correctly");
		
		
	}
}
