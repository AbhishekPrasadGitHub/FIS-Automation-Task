package com.fis.ui.tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EbayTest {
	
	WebDriver driver;
	WebDriverWait wait;

	// Verify ebay item added to cart
	@Test
	public void verifyItemAddedToCart() {

		try {
			driver.get("https://www.ebay.com/");
			WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));
			searchBox.sendKeys("book");
			searchBox.submit();
			String ebayMainWindow = driver.getWindowHandle();

			WebElement firstBook = wait
					.until(ExpectedConditions.elementToBeClickable((By.xpath("(//span[@role='heading'])[3]"))));
			firstBook.click();

			Set<String> ebayWindowHandles = driver.getWindowHandles();

			for (String handle : ebayWindowHandles) {
				if (!handle.equals(ebayMainWindow)) {
					driver.switchTo().window(handle);
					break;
				}
			}

			WebElement addToCart = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Add to cart']")));
			addToCart.click();
			String cartItem = driver.findElement(By.xpath("//span[text() = '1']")).getText();

			assertEquals(cartItem, "1");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}


}
