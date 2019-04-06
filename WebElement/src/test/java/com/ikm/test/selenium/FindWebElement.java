package com.ikm.test.selenium;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    //Implicit wait implementation..one time for entire program
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		/*Explicit wait implementation..need to call specifically when required
		
		WebDriverWait wait = new WebDriverWait(driver, 20);*/
		
        /*Fluent wait implementation*/
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(10))
		.pollingEvery(Duration.ofSeconds(10))
		.withMessage("User Defined timeout after 30sec")
		.ignoring(NoSuchElementException.class); //Fluent wait implementation

		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("khan202");
		//driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys(Keys.ENTER);
		
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input"))).sendKeys("sdfsdfsdfsdf");
		//driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("ssdsafsefsdf");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span"))).click();
		//driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\\\"view_container\\\"]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div[2]/div[2]/content")));
		System.out.println(driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/content/section/div/content/div[1]/div[2]/div[2]/content")).getText());
	
	}

}
