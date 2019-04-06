package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		WebElement electronics = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[1]/span"));
		
		Actions action = new Actions(driver);
		action.moveToElement(electronics).perform();
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[2]/a")).click();
		
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]"));
		int width =  mainSlider.getSize().width/2;
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div/div/div[1]/div/div[1]/div/section[2]/div[3]/div[1]/div[2]/div"));
		action.dragAndDropBy(slider, width, 0).perform();
		
			
		
	}

}
