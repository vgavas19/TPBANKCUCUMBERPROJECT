package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadsLandingPage {

	private WebDriver driver;
	
	public LeadsLandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getLandingPageTitle() {
		return driver.getTitle();
	}
	
	public void newButton() {
		 By new_button=By.xpath("//label[contains(text(),'New')]");
		 driver.findElement(new_button).click();
		 
	}
	
	public NewEditLayoutPage select_layout(String layoutName)  {

		By selectLayout=By.xpath("//span[contains(text(),'"+layoutName+"')]");
		driver.findElement(selectLayout).click();
		
		return new NewEditLayoutPage(driver);
	}
	
}
