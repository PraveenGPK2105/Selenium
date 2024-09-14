package Topic.Selenium_Concept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement drpdown=driver.findElement(By.id("dropdown-class-example"));
		
		Select drp= new Select(drpdown);
		
		drp.selectByValue("option2");
		drp.selectByVisibleText("Option1");
		List<WebElement> options = drp.getOptions();
		
		for(WebElement value: options) {
			System.out.println(value.getText()); 
		}
		
		//Auto Suggestive dropdown
		
		driver.findElement(By.id("autocomplete")).sendKeys("IND");
		Thread.sleep(3000);
		List<WebElement> drpvalues = driver.findElements(By.cssSelector(".ui-menu-item"));
		
		for(WebElement value: drpvalues) {
			
			if(value.getText().equalsIgnoreCase("India")) {
				value.click();
			}
		}
	}

}
