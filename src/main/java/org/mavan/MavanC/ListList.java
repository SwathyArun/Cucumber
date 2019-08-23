package org.mavan.MavanC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
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

	@Given("^User check the url and title of page$")
	public void user_check_the_url_and_title_of_page() {
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

	@When("^User enter username and password$")
	public void user_enter_username_and_password(DataTable listof) {
//List<String> L = list.asList(String.class);
		// d.findElement(By.id("email")).sendKeys(L.get(0));
		// d.findElement(By.id("pass")).sendKeys(L.get(1));
		List<List<String>> datas = listof.asLists(String.class);
		d.findElement(By.id("email")).sendKeys(datas.get(0).get(1));
		d.findElement(By.id("pass")).sendKeys(datas.get(1).get(0));
	}

	@When("^User enter firstname,lastname and phoneno$")
	public void user_enter_firstname_lastname_and_phoneno(DataTable list) {
		/*
		 * List<String> datas = list.asList(String.class);
		 * d.findElement(By.name("firstname")).sendKeys(datas.get(0));
		 * d.findElement(By.name("lastname")).sendKeys(datas.get(1));
		 * d.findElement(By.name("reg_email__")).sendKeys(datas.get(2));
		 */
		List<List<String>> datas = list.asLists(String.class);
		d.findElement(By.name("firstname")).sendKeys(datas.get(1).get(0));
		d.findElement(By.name("lastname")).sendKeys(datas.get(1).get(1));
		d.findElement(By.name("reg_email__")).sendKeys(datas.get(0).get(2));

	}

	@When("^user click register button$")
	public void user_click_register_button() {
		//WebElement f = d.findElement(By.id("loginbutton"));
WebElement f = d.findElement(By.xpath("//input[@type='submit']"));
		String a = f.getAttribute("value");
		System.out.println(a);
		f.click();
	}

	@Then("^user check navigate url$")
	public void user_check_navigate_url() {
		String url = d.getCurrentUrl();
		System.out.println(url);

	}

	@Then("^User closes the browser$")
	public void user_closes_the_browser() {
		d.close();

	}

}
