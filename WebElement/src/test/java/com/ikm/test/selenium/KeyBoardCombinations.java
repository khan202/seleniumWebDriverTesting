package com.ikm.test.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardCombinations {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("identifierId")).sendKeys("khan202");
		driver.findElement(By.xpath("//*[@id=\"initialView\"]/div[2]")).click();
		Actions action = new Actions(driver);
		//chord to use multiple keys together:
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).perform();
		
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		//can use build() to combine actions together, build will perform the actions first then proceed.
		//action.sendKeys(Keys.chord(Keys.CONTROL+"a")).sendKeys(Keys.chord(Keys.CONTROL+"c")).build().perform();
		
		driver.findElement(By.id("identifierId")).click();		
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
		
	}

}
