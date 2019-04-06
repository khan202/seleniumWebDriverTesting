package com.ikm.test.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// Implicit wait implementation..one time for entire program
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
		driver.manage().window().maximize();
		
		List<WebElement> rowsNum = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
		List<WebElement> colsNum = driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[1]/td"));
		System.out.println("Total number of rows "+rowsNum.size());
		System.out.println("Total number of cols "+colsNum.size());
		
		for (int rows=1; rows<=rowsNum.size();rows++) {
			for (int cols=1; cols<=colsNum.size(); cols++) {
				System.out.print(driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+rows+"]/td["+cols+"]")).getText()+"\t");
				}
			System.out.println();
		}

	}

}
