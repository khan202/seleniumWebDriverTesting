package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowResize {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://google.com");
		driver.manage().window().maximize();
	   Dimension size = driver.manage().window().getSize();
	   System.out.println(size);
	   int maxSize = size.getHeight();
	 
	   for (int i=300; i<=maxSize; i++) {  //1050, 807//1552,842
		int height = i+i;
		   int width =i+i;		  
		   System.out.println("height :"+height +"  width is :"+width);
		
		   Dimension d = new Dimension(height,width);
		   driver.manage().window().setSize(d);	   
		
	}
	   System.out.println("maximum Size reached");

}
	}
