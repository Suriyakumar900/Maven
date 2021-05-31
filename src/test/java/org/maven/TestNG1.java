package org.maven;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestNG1 {

	static WebDriver d;
	@BeforeClass
	public static void lunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\eclipse-workspace\\TzMaven\\driver\\chromedriver.exe");
	    d = new ChromeDriver();
		d.get("http://facebook.com/");
	}
		@Before
		public void start() {
		Date t = new Date();
		System.out.println(t);
		}
		
		
		@Test
		public void test() {
			Assert.assertTrue(d.getCurrentUrl().contains("face"));
			Assert.assertTrue(d.getTitle().contains("Face"));
			d.findElement(By.id("email")).sendKeys("suriya");
			WebElement password = d.findElement(By.id("pass"));
			password.sendKeys("123345678");
			Assert.assertEquals(password.getAttribute("value"), "123345678");
			System.out.println("success");
			
		}
		
		@After
		public void end() {
			Date d = new Date();
			System.out.println(d);
		}
		
		@AfterClass
		public static void quit() {
			d.quit();
		}

}


