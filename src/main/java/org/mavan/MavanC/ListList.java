package org.mavan.MavanC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ListList {
	WebDriver d;

	@Given("^User launch facebook application$")
	public void user_launch_facebook_application() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Prabu\\eclipse-workspace\\maven\\CucumList\\driver\\chromedriver.exe");
		d = new ChromeDriver();
		d.get("https://www.facebook.com/");
	}

	@Given("^User check url and title$")
	public void user_check_url_and_title() {
		String url = d.getCurrentUrl();
		System.out.println(url);
		if (url.contains("facebook")) {
			System.out.println(true);
		} else {
			System.out.println("false");
		}
		String t = d.getTitle();
		System.out.println(t);

	}

	@When("^User enter username \"([^\"]*)\"$")
	public void user_enter_username(String us) {
		WebElement f = d.findElement(By.id("email"));
		f.sendKeys(us);
		String t = f.getAttribute("value");
		System.out.println(t);
	}

	@When("^User enter password \"([^\"]*)\"$")
	public void user_enter_password(String ps) {

		WebElement l = d.findElement(By.id("pass"));
		l.sendKeys(ps);
		String t1 = l.getAttribute("value");
		System.out.println(t1);

	}

	@When("^User click login button$")
	public void user_click_login_button() {
		d.findElement(By.id("loginbutton")).click();

	}

	@Then("^User check navigate correct url or not$")
	public void user_check_navigate_correct_url_or_not() {
		String url = d.getCurrentUrl();
		System.out.println(url);
		if (url.contains("attempt")) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

	@Then("^User close the browser$")
	public void user_close_the_browser() {
		d.close();

	}

}
