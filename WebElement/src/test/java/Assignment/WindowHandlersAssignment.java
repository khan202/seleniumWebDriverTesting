package Assignment;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlersAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		//driver.manage().window().maximize();
		Set<String> windId = driver.getWindowHandles();
		int size = windId.size();
		System.out.println(size);
		Iterator<String> iterator = windId.iterator();
		String w1 = iterator.next();
		System.out.println(w1);

		for (int i = 2; i <= size; i++) {

			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
			driver.close();
		}

	}

}
