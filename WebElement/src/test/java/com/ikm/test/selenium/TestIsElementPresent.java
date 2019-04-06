package com.ikm.test.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIsElementPresent {
	public static WebDriver driver;

	//public static boolean isElementPresent(String locator) {

	public static boolean isElementPresent(By by) {
		/*
		 * try { driver.findElement(by); return true; } catch (Throwable
		 * t) { return false; }
		 */

		int size = driver.findElements(by).size();
		if (size == 0) {
			return false;
		} else {
			return true;
		}

	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// Implicit wait implementation..one time for entire program
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		// driver.findElement(By.xpath("//*[@id=\\\"searchLanguage\\\"]\""));
		System.out.println(isElementPresent(By.xpath("//*[@id='searchLanguage']")));
	}

}
