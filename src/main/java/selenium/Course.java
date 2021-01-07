package selenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Course {
	String url;
	WebDriver driver;
	
	@Before
	public void start() {
		url = "https://iterasys.com.br/";
		System.setProperty(
			"webdriver.chrome.driver", 
			"/home/rafael/eclipse-workspace/selenium/drivers/87/chromedriver"
		);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
	}

	@After
	public void finish() {
		driver.quit();
	}
	
	@Test
	public void consultCourse() {
		driver.get(url);
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("Mantis"));
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.cssSelector("span.comprar")).click();
		
		String title = "Mantis";
		String price = "R$ 49,99";
		
		assertEquals(title, driver.findElement(By.cssSelector("span.item-title")).getText());
		assertEquals(price, driver.findElement(By.cssSelector("span.new-price")).getText());
	}
}
