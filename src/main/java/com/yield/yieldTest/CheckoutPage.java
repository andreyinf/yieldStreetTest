package com.yield.yieldTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
	
	static WebElement FirstName() {
		return Init.getDriver().findElement(By.id("first-name"));
	}
	static WebElement LastName() {
		return Init.getDriver().findElement(By.id("last-name"));
	}
	static WebElement PostalCode() {
		return Init.getDriver().findElement(By.id("postal-code"));
	}
	
	public void ContinueButton() {
		Init.getDriver().findElement(By.xpath("//input[@value='CONTINUE']")).click();
	}
	
	public void FillUserData(String fName, String lName, String zipCode) {
		FirstName().sendKeys(fName);
		LastName().sendKeys(lName);
		PostalCode().sendKeys(zipCode);
	}
	
	public void FinishPurchase() {
		
		Init.getDriver().findElement(By.xpath("//*[@id=\'checkout_summary_container\']/div/div[2]/div[8]/a[2]")).click();
		
	}
	
	public boolean IsThePurchaseConfirmed() {
		
		WebElement confirmation = Init.getDriver().findElement(By.cssSelector("#checkout_complete_container > h2"));
		return confirmation.getText().contains("THANK YOU FOR YOUR ORDER");	
	}

}
