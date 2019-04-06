package com.ikm.test.selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropDowns {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    //Implicit wait implementation..one time for entire program
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"lang-chooser\"]/div[1]/div[1]/div[8]/content"))).sendKeys("Dansk");
      
		//whenever you work with dropdown don't use sendkeys instead we use select class
		//driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")).sendKeys("Espanol");
		
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		
		Select select =  new Select(dropdown);// pass the Web element for the select constructor 
		select.selectByVisibleText("Eesti");
		//select.selectByValue("hi");
		//System.out.println(select.getOptions());
		//System.out.println(select.getAllSelectedOptions());
		
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		System.out.println(values.size());
		//System.out.println(values.get(8).getText());
		for (int i=0; i<values.size(); i++) {
			
			//System.out.println(values.get(i).getText());
			System.out.println(values.get(i).getAttribute("lang"));
		}
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[6]/div[3]"));
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		System.out.println();
		System.out.println("total links are "+links.size());
		for (WebElement link : links) {
			System.out.println(link.getText()+"URL is .."+ link.getAttribute("href"));
		}
		
	
		
		
	}

}
