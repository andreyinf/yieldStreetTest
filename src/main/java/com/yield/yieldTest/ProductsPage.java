package com.yield.yieldTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * YieldSreet Test by Andrey Aires
 */

public class ProductsPage
{
	
    public void AddAllTShirtsToCart() {
    	
    	//To add all products in a list to be added to cart
		/*
		 * List <WebElement> Element =
		 * Init.getDriver().findElements(By.cssSelector(".inventory_item"));
		 * System.out.println("NUMBER OF ITEMS: " + Element.size());
		 * * for (int i = 1; i <= Element.size(); i++) {
		 * Init.getDriver().manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		 * WebElement addButton = Init.getDriver().findElement(By.xpath(
		 * "//*[@id=\'inventory_container\']/div/div["+i+"]/div[3]/button"));
		 * addButton.click(); }
		 */
    	
    	//Adding only the specific t-shirts
		 Init.getDriver().manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		 Init.getDriver().findElement(By.xpath("//*[@id=\'inventory_container\']/div/div[3]/div[3]/button")).click(); 
		 Init.getDriver().findElement(By.xpath("//*[@id=\'inventory_container\']/div/div[6]/div[3]/button")).click(); 
		  
    }
    
    public boolean CheckImages() throws IOException {
    	
    	List<WebElement> links = Init.getDriver().findElements(By.tagName("img"));
    	boolean var = false;
    	for(WebElement ele:links){
            URL obj = new URL(ele.getAttribute("src"));
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            if (String.valueOf(con.getResponseCode()).equals("200")){
				System.out.println("Image @ url " + ele.getAttribute("src") + " exists at server");
				var = true;
			}
			else 
				System.out.println("Image @ url " + ele.getAttribute("src") + " does not exists at server");
        }
    	return var;
    }
    	
    
    public void justWait() {
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    } 
 
}

