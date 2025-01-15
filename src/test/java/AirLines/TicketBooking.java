package AirLines;

import static org.junit.Assert.assertEquals;


//import java.awt.AWTException;

//import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

//import org.junit.After;
import org.junit.AfterClass;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//import com.google.gson.annotations.Until;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class TicketBooking {
	public static WebDriver driver;
	@BeforeClass
	public static void lanughUrl() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("disable-popups");
		options.addArguments("disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://www.easemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	@Test
	public void Method1() {
		driver.findElement(By.xpath("//span[text()='Flights']")).click();
	}
	@Test
	public void method2() {
    driver.findElement(By.xpath("//div[@class='innerspcr']//following::input[@id='FromSector_show']")).click();
    WebElement source = driver.findElement(By.xpath("//input[@id='a_FromSector_show']"));   
   source.sendKeys("bangalore");
	}
	
	@Test
	public void method3() {
		driver.findElement(By.xpath("//input[@id='Editbox13_show']")).click();
		WebElement Dest = driver.findElement(By.xpath("//input[@id='a_Editbox13_show']"));
		Dest.sendKeys("Chennai");
		String value = Dest.getAttribute("value");
		System.out.println(value);
		}
	@Test
	public void method4() {
		List <WebElement> link = driver.findElements(By.tagName("link"));
		for (int i=0; i<=link.size()-1; i++) {
			WebElement urls = link.get(i);
			String links = urls.getAttribute("href");
			System.out.println(links);
		}
		}

        @Test
        public void method5() {
        	driver.findElement(By.xpath("//li[@id='rtrip']")).click();
        }
        @SuppressWarnings("deprecation")
		@Test
        public void method6() {
        	WebElement text = driver.findElement(By.xpath("//div[text()='  Exclusive Offers']"));
        	String Actualtext = text.getText();
        	String Expectedtext = " Exclusive Offers";
        	Assert.assertEquals(Actualtext.trim(), Expectedtext.trim());
        	System.out.println(Actualtext);
        }
        @SuppressWarnings("deprecation")
		@Test
        public void method7() {
        	WebElement text = driver.findElement(By.xpath("//h1[text()='Search  Lowest Price']"));
        	String Actualtext = text.getText();
        	String Exceptedtext = ("Search  Lowest Price");
        	Assert.assertEquals(Actualtext.startsWith("Search"), Exceptedtext.startsWith("Search"));
        	System.out.println("Assert Passed");
        }
	    
	@AfterClass
	public static void close () {
		driver.quit();
	}

}
