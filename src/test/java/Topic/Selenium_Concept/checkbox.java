package Topic.Selenium_Concept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkbox {
	public static void main(String args[]) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement values: checkboxes) {
			if(values.getAttribute("value").equalsIgnoreCase("option3")){
				values.click();
				break;
			}
		}
		
		for(WebElement values: checkboxes) {
			if(values.getAttribute("value").equalsIgnoreCase("option2"))
				//System.out.println(); 
			Assert.assertFalse(values.isSelected());
		}
	}
}
