package AirLines;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HotelBooking {
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@BeforeClass
      public static void UrlLaunching() {
    	  WebDriverManager.chromedriver().setup();
    	  ChromeOptions options = new ChromeOptions();
    	  options.addArguments("start-maximized");
    	  options.addArguments("disable-popups");
    	  options.addArguments("disable-notifications");
    	  driver = new ChromeDriver(options);
    	  driver.get("https://www.easemytrip.com/");
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      }
	  @Test
      public void Method1() {
        List<WebElement> links = driver.findElements(By.tagName("link"));
        for (int i = 0; i < links.size(); i++) { 
            WebElement link = links.get(i);
            String url = link.getText();
            String href = link.getAttribute("href");
            System.out.println(href);
        }
    }
	@Test
	public void Method2() {
		driver.findElement(By.xpath("//span[text()='Hotels']")).click();
	//	driver.findElement(By.xpath("//a[@class='close_o_pp']")).click();
	}
	@Test
	public void method3() throws InterruptedException {
		
		WebElement goa = driver.findElement(By.xpath("//h5[@class='htlnking']/following::a[text()='Goa']"));
	    js.executeScript("arguments[0].scrollIntoView(true)", goa);
	    Thread.sleep(2000);
	    js.executeScript("arguments[0].click()", goa);
	}
	@Ignore
	@Test
	public void method4() {
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement heading = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Hotels in Goa']")));
		String ActualHead = heading.getText();
		String ExceptedHead  = ("hotels in goa");
		assertEquals(ExceptedHead, ActualHead.toLowerCase());
        System.out.println("assert pass");
	}
	@Ignore
	@Test
	public void method5() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btnsrch']")));
		
		search.click();
	}
	@Ignore
	@Test
	public void Method6()  {
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofSeconds(20));
		hold.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@ng-model='Popularity']"))).click();
	
	}
	@AfterClass
	public static void close() {
	driver.quit();
	}
}
