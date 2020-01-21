package com.yield.yieldTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is the page object mapping the page elements!
 * YieldStreet Test by Andrey Aires
 */

public class SwagLabsLoginPage 
{
	
    public void UserNameField(String userName){
    	WebElement userNameFieldElement = Init.getDriver().findElement(By.id("user-name"));
    	userNameFieldElement.sendKeys(userName);
    }
    
    public void PasswordField(String password){
    	WebElement passwordFieldElement = Init.getDriver().findElement(By.id("password"));
    	passwordFieldElement.sendKeys(password);
    }
    
    public void LoginButton(){
    	WebElement loginButtonElement = Init.getDriver().findElement(By.xpath("//input[@value='LOGIN']"));
    	loginButtonElement.click();
    }
    
	
    public boolean IsTheUserLockedOut() {
    	WebElement lockedOutElement = Init.getDriver().findElement(By.xpath("//*[@id='login_button_container']/div/form/h3"));
    	System.out.println("ERROR MESSAGE: " + lockedOutElement.getText());
    	return lockedOutElement.getText().contains("Sorry, this user has been locked out.");
    }
   
    public void WaitForPageLoad() {
    	 WebDriverWait wait = new WebDriverWait(Init.getDriver(), 10);
    	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
    }
    
    public void justWait() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    
}
