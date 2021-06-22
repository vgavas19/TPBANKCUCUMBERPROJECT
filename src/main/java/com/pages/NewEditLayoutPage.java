package com.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class NewEditLayoutPage {

	private WebDriver driver=null;

	private By cardtype=By.name("LE_PRODUCT");

	private By leadsource=By.name("LE_LEADSOURCE");

	private By branch=By.xpath("//a[@data-autoid='LE_TERRITORY_srch']");

	private By Branchsearchgridbox=By.name("Grid_SearchTextBox");

	private By FirstRecordOfBranchSearch=By.xpath("//div[@data-autoid='Name_0']");

	private By StatusCode=By.name("LE_STATUSCODE");

	private By Lastname=By.name("LASTNAME");

	private By Mobile=By.name("LE_MOBILE");

	private By email=By.name("LE_EMAIL");

	private By NationalID=By.name("cust_56");

	private By City=By.name("cust_567");

	private By Savebutton=By.xpath("//span[contains(text(),'Save')]");

	private By Custdedupetext=By.xpath("//div[@data-autoid='ded_msg']");

	private By leaddedupe=By.xpath("//div[@data-autoid='ded_msg']");

	private By Ignorecreate=By.xpath("//button[contains(text(),'Ignore And Create')]");

	private By dedupeupdatecheckbox=By.xpath("//label[@for='checkbox0']");

	private By updatebutton=By.xpath("//button[contains(text(),'Update')]");

	private By new_button=By.xpath("//label[contains(text(),'New')]");

	private By khoanVay=By.xpath("//span[contains(text(),'Khoản vay')]");

	private By Leadid=By.xpath("//label[contains(text(),'Lead ID')]/following-sibling::div");

	private By OKbutton=By.xpath("//button[contains(text(),'Ok')]");

	private By LeadID=By.xpath("//label[contains(text(),'Lead ID')]/following-sibling::div");

	public NewEditLayoutPage(WebDriver driver) {


		this.driver=driver;

	}

	public void entercardtype(String cardt) throws Exception {

		Select card=new Select(driver.findElement(cardtype));
		Thread.sleep(2000);

		card.selectByVisibleText(cardt);

	}

	public void enterleadsource(String LS) throws Exception {

		Select leads=new Select(driver.findElement(leadsource));

		Thread.sleep(2000);

		leads.selectByVisibleText(LS);
	}

	public void enterBranch(String city1) throws InterruptedException {


		Thread.sleep(3000);
		driver.findElement(branch).click();
		Thread.sleep(3000);
		String parentwindow=driver.getWindowHandle();

		Set window=driver.getWindowHandles();

		Iterator i=window.iterator();

		while(i.hasNext()) {

			String popupwindow=(String) i.next();
			driver.switchTo().window(popupwindow);
			System.out.println("while loop");
			Thread.sleep(3000);

			driver.findElement(Branchsearchgridbox).sendKeys(city1+Keys.ENTER);

			Thread.sleep(3000);
			driver.findElement(FirstRecordOfBranchSearch).click();

		}
		driver.switchTo().window(parentwindow);
		System.out.println("while loop completed");
	}

	public void enterstatuscode(String SC) throws Exception {

		Select stcode=new Select(driver.findElement(StatusCode));

		Thread.sleep(2000);

		stcode.selectByVisibleText(SC);

	}

	public void enterlastname(String lname) {

		driver.findElement(Lastname).sendKeys(lname);
	}

	public void entermobile(String mob) {

		driver.findElement(Mobile).sendKeys(mob);
	}

	public void enteremail(String mail) {

		driver.findElement(email).sendKeys(mail);
	}

	public void enternationalID(String natID) {

		driver.findElement(NationalID).sendKeys(natID);
	}

	public void entercity(String thin) throws Exception {
		Select thinn=new Select(driver.findElement(City));

		Thread.sleep(2000);

		thinn.selectByVisibleText(thin);
	}

	public void clicksavebutton() {

		driver.findElement(Savebutton).click();
	}

	public void servicepopup() throws Exception {

		try {
			Thread.sleep(2000);

			for(String winHandle : driver.getWindowHandles()){

				driver.switchTo().window(winHandle);}

			Thread.sleep(2000);

			driver.findElement(OKbutton).click();
		}
		catch(Exception e)
		{
			e.getMessage();
			e.getStackTrace();

		}

	}

	public void dedupepopup_ignorecreate() throws Exception {

		try
		{
			String parentwindow=driver.getWindowHandle();

			Set window=driver.getWindowHandles();

			Iterator i=window.iterator();

			while(i.hasNext()) {

				String popupwindow=(String) i.next();
				driver.switchTo().window(popupwindow);
				System.out.println("while loop");
				Thread.sleep(3000);

			}
			Thread.sleep(5000);

			WebElement element1=driver.findElement(leaddedupe);
			WebElement element= driver.findElement(Custdedupetext);


			if (element1.equals(element)) {
				System.out.println("Inside If");
				driver.findElement(Ignorecreate).click();

			} else {
				System.out.println("Inside else");
				driver.findElement(Ignorecreate).click();
			}
			driver.switchTo().window(parentwindow);

			System.out.println("while loop completed");
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());

			System.out.println(exp.getStackTrace());

		}

	}	
	public void updatelead() throws Exception {

		try {

			String parentwindow=driver.getWindowHandle();

			Set window=driver.getWindowHandles();

			Iterator i=window.iterator();

			while(i.hasNext()) {

				String popupwindow=(String) i.next();
				driver.switchTo().window(popupwindow);
				System.out.println("while loop");
				Thread.sleep(3000);

			}
			Thread.sleep(5000);

			WebElement element1=driver.findElement(leaddedupe);
			WebElement element= driver.findElement(Custdedupetext);

			Thread.sleep(2000);

			if (element1.equals(element)) {
				System.out.println("Inside If");
				driver.findElement(dedupeupdatecheckbox).click();
				Thread.sleep(2000);

				driver.findElement(updatebutton).click();;

			} else {
				System.out.println("Inside else");
				driver.findElement(dedupeupdatecheckbox).click();
				Thread.sleep(2000);

				driver.findElement(updatebutton).click();;
			}
			driver.switchTo().window(parentwindow);

			System.out.println("while loop completed");
			Thread.sleep(2000);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());

			System.out.println(exp.getStackTrace());
		}
	}


	public void newButton() {
		By new_button=By.xpath("//label[contains(text(),'New')]");
		driver.findElement(new_button).click();

	}

	public void select_layout()  {

		By selectLayout=By.xpath("//span[contains(text(),'Khoản vay')]");
		driver.findElement(selectLayout).click();
	}

	public String getLeadID(){
		
		String leadID=driver.findElement(LeadID).getText();
		
		System.out.println(leadID);
		
		return driver.findElement(LeadID).getText();
	} 
}


