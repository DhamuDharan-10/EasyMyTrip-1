package AirLines;

import java.awt.Robot;

import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing {
	public static void main (String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
	    option.addArguments("disable-popups");
		option.addArguments("disable-notifiacation");
		option.addArguments("start-maximize");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.flipkart.com/");
		WebElement duplicate = driver.findElement(By.xpath("//tagname[@atrributename='attributevalue']"));
		List<WebElement> duplicates = driver.findElements(By.id("valueof the id"));
		Actions mouse = new Actions (driver);
		mouse.moveToElement(duplicate);
		mouse.click(duplicate);
	 // mouse.dragAndDrop(src, des);
		mouse.doubleClick();
		mouse.contextClick();
		try {
			Robot Key = new Robot();
			Key.keyPress(KeyEvent.VK_DOWN);
			Key.keyRelease(KeyEvent.VK_DOWN);
		
		Select drops = new Select (duplicate);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		TakesScreenshot capture = (TakesScreenshot) driver;
		File src = capture.getScreenshotAs(null);
		File des = new File ("path.format");
		FileUtils.copyFile(src, des);
		Alert noti = driver.switchTo().alert();
		noti.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
