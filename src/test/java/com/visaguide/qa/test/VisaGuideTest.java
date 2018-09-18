package com.visaguide.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.visaguide.qa.TestBase.TestBase;
import com.visaguide.qa.pages.VisaGuidePage;

public class VisaGuideTest extends TestBase {
	
	public VisaGuideTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		VisaGuidePage visaguide = new VisaGuidePage();
		
	}
	
	@Test(priority=1)
	public void VisaFreeTest(){
		VisaGuidePage.getstarted(prop.getProperty("tocountry"), prop.getProperty("fromcountry"),prop.getProperty("purpose"));
		String Visatitle=VisaGuidePage.validatevisa();
		System.out.println("From "+prop.getProperty("tocountry")+" To "+prop.getProperty("fromcountry")+" are " +Visatitle);
	
	    Assert.assertEquals(Visatitle, "VISA FREE");
	    System.out.println("Test Case Pass");
				
		
	}
	
	@Test(priority=2)
	public void VisaRequiredTest(){
		VisaGuidePage.getstarted(prop.getProperty("tocountry"), prop.getProperty("fromcountry1"),prop.getProperty("purpose"));
		String Visatitle1=VisaGuidePage.validatevisarequired();
		System.out.println("From "+prop.getProperty("tocountry")+" To "+prop.getProperty("fromcountry1")+" are " +Visatitle1);
	
	    Assert.assertEquals(Visatitle1, "Select visa to proceed");
	    System.out.println("Test Case Pass");
	}
	
	@Test(priority=3)
	public void VisaTestSameCountry(){
		VisaGuidePage.getstarted(prop.getProperty("fromcountry"), prop.getProperty("fromcountry"),prop.getProperty("purpose"));
		String Samecountry=VisaGuidePage.validatevisasamecountry();
		System.out.println("From "+prop.getProperty("fromcountry")+" To "+prop.getProperty("fromcountry")+"  " +Samecountry);
	
	    Assert.assertEquals(Samecountry, "No visa needed to roam around in the country you are already in. :)");
	    System.out.println("Test Case Pass");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
