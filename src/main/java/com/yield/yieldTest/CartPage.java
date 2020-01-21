package com.yield.yieldTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	public WebElement CartIcon() {
		return Init.getDriver().findElement(By.id("shopping_cart_container"));
	}
	
	private WebElement checkoutButton() {
		return Init.getDriver().findElement(By.cssSelector("#cart_contents_container > div > div.cart_footer > a.btn_action.checkout_button"));
	}
	
	public void GoToCart() {
		CartIcon().click();
		WaitForPageLoad();
	}
	
	public void Checkout() {
		
		checkoutButton().click();
		justWait();
		
	}
	
	public void WaitForPageLoad() {
   	 WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10);
   	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart_contents_container")));
   }
	
	public void justWait() {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
}
