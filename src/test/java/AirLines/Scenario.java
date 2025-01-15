package AirLines;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver ();
		  driver.get("https://demo.automationtesting.in/Alerts.html");
		  
		  //Alert Interface 
		  driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
		  driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		  Alert alert = driver.switchTo().alert();
		  String AlertText = alert.getText();
		  String[] words = AlertText.split(" ");
		  for (String word: words) {
			//  System.out.println(word);
			  
			  if (word.equalsIgnoreCase("your")) {
				  System.out.println(word);
				  break;
			  }
		  }
		  alert.accept();
		  driver.quit();
		  
		  
	}

}
