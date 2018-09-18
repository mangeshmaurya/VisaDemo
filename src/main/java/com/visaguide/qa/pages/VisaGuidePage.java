package com.visaguide.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.visaguide.qa.TestBase.TestBase;

public class VisaGuidePage extends TestBase{
	@FindBy(xpath= "//*[@id='ember511']/input")
	static
	private WebElement tocountry;
	
	@FindBy(xpath="//*[@id='ember762']/input")
	static
	private WebElement fromcountry;
	
	@FindBy(xpath="//*[@id='ember763']/input")
	static
	private WebElement purpose;
	
	@FindBy(id="btn-login")
	static
	private WebElement getstarted;
	
	@FindBy(xpath="//*[@id='ember424']/div[6]/div/div/h1")
	static
	private WebElement visatext;
	
	@FindBy(css="#ember424 > div.front-page > div:nth-child(7) > h1")
	static
	private WebElement visareqtext;
	
	@FindBy(xpath="//span[@class='message' and contains(text(), 'No visa needed to roam around in the country you are already in')]")
	static
	private WebElement samecountry;
	
	public VisaGuidePage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public static String validatevisa(){
		String str= visatext.getText();
		return str;
		
	}
	
	public static String validatevisarequired(){
		String str= visareqtext.getText();
		return str;
		
	}
	
	public static String validatevisasamecountry(){
		String str= samecountry.getText();
		return str;
		
	}
	
	public static void getstarted(String from, String to, String purp){
		tocountry.sendKeys(from);
		fromcountry.sendKeys(to);
		purpose.sendKeys(purp);
		getstarted.click();
		//return new HomePage();
		
		
	}
}
