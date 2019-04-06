package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIframe {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_scripts_intro");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		/*
		 * List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
		 * System.out.println(iframe.size()+"and"+iframe.get(index));
		 * driver.switchTo().frame(iframe.get(0));
		 */
		driver.findElement(By.xpath("/html/body/button")).click();
	}

}
