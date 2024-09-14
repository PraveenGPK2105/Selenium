package Topic.Selenium_Concept;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenlinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		List<String>urlList= new ArrayList<String>();
		
		for(WebElement e : links) {
			 String url=e.getAttribute("href");
			 urlList.add(url);
		}
		
		urlList.parallelStream().forEach(e->checkResponseCode(e));
	}
	
	public static void checkResponseCode(String link)  {
		
	try {
		URI uri=new URI(link);
		
		URL url= uri.toURL();
		
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setConnectTimeout(5000);
		httpURLConnection.connect();
		
		if(httpURLConnection.getResponseCode()>=400) {
			System.out.println(link +"---->"+ httpURLConnection.getResponseMessage() + " is a broken link");
		}
		
		else {
			System.out.println(link +"---->"+ httpURLConnection.getResponseMessage() );
		}
	}
	catch(Exception e) {
		
	}

	}
}
