package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment03 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// Implicit wait implementation..one time for entire program
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().maximize();
		String[] r = driver.findElement(By.xpath("//*[@id=\"mathq2\"]")).getText().split(" ");
		System.out.println("the capcha length is:  "+r.length);
		int sum=0;
			
		if (r[1].equals("+")) {			
		sum = Integer.parseInt(r[0])+Integer.parseInt(r[2]);
		}else if (r[1].equals("-")) {
			sum = Integer.parseInt(r[0])-Integer.parseInt(r[2]);
		}else if (r[1].equals("*")) {
			sum = Integer.parseInt(r[0])*Integer.parseInt(r[2]);
		}else if(r[1].equals("/")) {
			sum = Integer.parseInt(r[0])/Integer.parseInt(r[2]);
		}else sum=sum;
					
		System.out.println("the Sum of  "+r[0]+"  and  "+r[2]+"  is: "+sum);
		String key = Integer.toString(sum);
		driver.findElement(By.id("mathuserans2")).sendKeys(key);
		driver.findElement(By.xpath("//*[@id=\"pollform\"]/table/tbody/tr[2]/td/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"pollform\"]/table/tbody/tr[4]/td/div")).click();	
		//int p = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"polldiv\"]/table/tbody/tr/td/table[2]/tbody/tr[2]/td[2]/span/font/optionperc")).getText());
		
	}

}
