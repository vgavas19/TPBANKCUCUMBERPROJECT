package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	private By username=By.id("TxtName");

	private By password=By.id("TxtPassword");

	private By loginbutton=By.name("command");

	private By forgotPwdLink=By.xpath("//a[@id='forgot-pass']");
	
	private By NewButton=By.xpath("//label[contains(text(),'New')]");
	
	private By leadsText=By.xpath("//div[@title='Leads']");


	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public Boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUsername(String uname) {

		driver.findElement(username).sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clicklogin() {
		driver.findElement(loginbutton).click();
	}
	
	public void verifyLandingPage() {
		
		WebElement newButton=driver.findElement(NewButton);
		
		if(newButton.isDisplayed()) {
			System.out.println("New Button found");
		}
		else {
			System.out.println("New Button not found");
		}
	}
	
	public void leadsText() {
		
		WebElement textAsLeads=driver.findElement(leadsText);
		
		if(textAsLeads.isDisplayed()){
			System.out.println("Text 'Leads' found");
		}
		else {
			System.out.println("Text 'Leads' not found");
		}
	}
	
	public LeadsLandingPage doLogin(String un,String pwd) {
		System.out.println("login with:" + un + "and" + pwd);
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginbutton).click();
		return new LeadsLandingPage(driver);
		
	}
}
