package Topic.Selenium_Concept;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class calendar {

	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		//Approach 1
		//driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/23/2022");
		
		//Approach 2
		/*String month="May";
		String date="21";
		String year="2023";
		*/
		String month="November";
		String date="21";
		String year="2024";
		
		int years=Integer.parseInt(year);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		//For month and year
		while(true) {
			String mon=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			String yr=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
			int yrs=Integer.parseInt(yr);
			
			if(mon.equals(month) && yr.equals(year)){
				break;
			}
			if(yrs<years) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//Future date
			}
			else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			
			
		}
		//Dates
			List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td"));
			
			for(WebElement dt:allDates) {
				
				if(dt.getText().equals(date)) {
					dt.click();
					break;
				}
			}

	}

}
