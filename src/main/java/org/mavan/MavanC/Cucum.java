package org.mavan.MavanC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cucum {
	WebDriver d;
	@Given("^Use launches the facebook page$")
	public void use_launches_the_facebook_page()  {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\SWATHY\\eclipse-workspace\\Maven\\MavanC\\driver\\chromedriver.exe"); 
	    d=new ChromeDriver();
	    d.get("https://www.facebook.com/");
	}

	@Given("^User check the current url and title page$")
	public void user_check_the_current_url_and_title_page()  {
	    String url = d.getCurrentUrl();
	    System.out.println(url);
	    String t = d.getTitle();
	    System.out.println(t);
	    
	}

	@When("^User enter username$")
	public void user_enter_username()  {
	    d.findElement(By.id("email")).sendKeys("swathyarun");
	    
	}

	@When("^User enter password$")
	public void user_enter_password()  {
		d.findElement(By.id("pass")).sendKeys("arun");
	    
	    
	}

	@When("^User click login button$")
	public void user_click_login_button()  {
	    d.findElement(By.id("loginbutton")).click();
	    
	}

	@Then("^User check the navigate url$")
	public void user_check_the_navigate_url()  {
	    String url = d.getCurrentUrl();
	    System.out.println(url);
	}

	@Then("^user close the broser$")
	public void user_close_the_broser()  {
	    
d.close();	    
	}



}
