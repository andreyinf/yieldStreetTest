package com.yield.yieldTest;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.chrome.ChromeDriver;
import com.yield.yieldTest.CartPage;
import com.yield.yieldTest.CheckoutPage;
import com.yield.yieldTest.Init;
import com.yield.yieldTest.ProductsPage;
import com.yield.yieldTest.SwagLabsLoginPage;

/**
 * YieldStreet Test by Andrey Aires.
 */

public class SwagLabsTest 
{
	SwagLabsLoginPage loginPage = new SwagLabsLoginPage();
	ProductsPage prodPage = new ProductsPage();
	CartPage cartPage = new CartPage();
	CheckoutPage checkoutPage = new CheckoutPage();
    
	@Before
    public void beforeSuite() {
        Init.driver = new ChromeDriver();
        Init.getDriver().manage().window().maximize();
        Init.getDriver().get("https://www.saucedemo.com/");
    }

    @After
    public void afterSuite() {
        Init.driver.quit();
    }
	
	@Test
	@Order(1) 
	public void TestSwagLabLoginLocked() {
	  loginPage.UserNameField("locked_out_user");
	  loginPage.PasswordField("secret_sauce"); loginPage.LoginButton();
	  loginPage.justWait(); assertTrue(loginPage.IsTheUserLockedOut()); 
	}
	 
    @Test
	@Order(2) 
    public void TestSwagLabPurchase() 
    { 
	  loginPage.UserNameField("standard_user");
	  loginPage.PasswordField("secret_sauce"); loginPage.LoginButton();
	  loginPage.justWait(); prodPage.AddAllTShirtsToCart(); cartPage.GoToCart();
	  cartPage.Checkout(); checkoutPage.FillUserData("Andrey", "Aires", "900000");
	  checkoutPage.ContinueButton(); checkoutPage.FinishPurchase();
	  assertTrue(checkoutPage.IsThePurchaseConfirmed()); 
	}
		
	@Test
	@Order(3) 
	public void TestLoadImages() throws IOException 
	{ 
	  loginPage.UserNameField("problem_user");
	  loginPage.PasswordField("secret_sauce"); loginPage.LoginButton();
	  loginPage.justWait(); assertTrue(prodPage.CheckImages()); 
	}
	 
}