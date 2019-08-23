package org.mavan.MavanC;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Maplist {
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
	public void user_enter_username_and_password(DataTable map) {
	/*	Map<String, String> datas = map.asMap(String.class, String.class);
		d.findElement(By.id("email")).sendKeys(datas.get("username"));
		d.findElement(By.id("pass")).sendKeys(datas.get("password"));
	*/
		List<Map<String, String>> datas = map.asMaps(String.class, String.class);
		d.findElement(By.id("email")).sendKeys(datas.get(0).get("username"));
		d.findElement(By.id("pass")).sendKeys(datas.get(0).get("password"));
	
	}

	@When("^User enter firstname,lastname and phoneno$")
	public void user_enter_firstname_lastname_and_phoneno(DataTable map) {
	/*	Map<String, String> datas = map.asMap(String.class, String.class);

		d.findElement(By.name("firstname")).sendKeys(datas.get("firstname"));
		d.findElement(By.name("lastname")).sendKeys(datas.get("lastname"));
		d.findElement(By.name("reg_email__")).sendKeys(datas.get("phoneno"));
*/
		List<Map<String, String>> datas = map.asMaps(String.class, String.class);
		d.findElement(By.name("firstname")).sendKeys(datas.get(0).get("firstname"));
		d.findElement(By.name("lastname")).sendKeys(datas.get(1).get("lastname"));
		d.findElement(By.name("reg_email__")).sendKeys(datas.get(0).get("phoneno"));
		
		
	}

	@When("^user click register button$")
	public void user_click_register_button() {
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
		d.quit();

	}

}
