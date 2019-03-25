package com.sicredi.sicrediTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * This is the page object mapping the page elements!
 * Sicredi Test by Andrey Aires
 */

public class Page 
{
	public WebDriver driver = new ChromeDriver();
	
    public static void main( String[] args )
    {
        
    }
    public void selectVersion(String option){
    	WebElement version = driver.findElement(By.id("switch-version-select"));
    	Select oSelect = new Select(version);
    	oSelect.selectByVisibleText(option);
    	justWait();
    }
    public void addCustomerButton(){
    	WebElement addButton = driver.findElement(By.cssSelector("i.el.el-plus"));
    	addButton.click();
    	justWait();
    }
    public void nameField(String name){
    	WebElement nField = driver.findElement(By.id("field-customerName"));
    	nField.sendKeys(name);
    }
    public void lastNameField(String lastName){
    	WebElement lastField = driver.findElement(By.id("field-contactLastName"));
    	lastField.sendKeys(lastName);
    }
    public void contactFirstNameField(String contactName){
    	WebElement contactField = driver.findElement(By.id("field-contactFirstName"));
    	contactField.sendKeys(contactName);
    }
    public void foneField(String fone){
    	WebElement fField = driver.findElement(By.id("field-phone"));
    	fField.sendKeys(fone);
    }
    public void addressLineField1(String addressLine1){
    	WebElement addressLField1 = driver.findElement(By.id("field-addressLine1"));
    	addressLField1.sendKeys(addressLine1);
    }
    public void addressLineField2(String addressLine2){
    	WebElement addressLField2 = driver.findElement(By.id("field-addressLine2"));
    	addressLField2.sendKeys(addressLine2);
    }
    public void cityField(String city){
    	WebElement cField = driver.findElement(By.id("field-city"));
    	cField.sendKeys(city);
    }
    public void stateField(String state){
    	WebElement sField = driver.findElement(By.id("field-state"));
    	sField.sendKeys(state);
    }
    public void postalCodeField(String postalCode){
    	WebElement pField = driver.findElement(By.id("field-postalCode"));
    	pField.sendKeys(postalCode);
    }
    public void countryField(String country){
    	WebElement cField = driver.findElement(By.id("field-country"));
    	cField.sendKeys(country);
    }
    public void fromEmployeer(String option){
    	driver.findElement(By.xpath("//*[@id='field_salesRepEmployeeNumber_chosen']")).click();
    	List <WebElement> employeer = driver.findElements(By.xpath("//*[@id='field_salesRepEmployeeNumber_chosen']/div/ul/li"));
    	for (int i=0;i<employeer.size();i++){
    		if (employeer.get(i).getText().contains("Fixter")) employeer.get(i).click();
    	}
    	justWait();
    }
    public void creditLimitField(String creditLimit){
    	WebElement creditLField = driver.findElement(By.id("field-creditLimit"));
    	creditLField.sendKeys(creditLimit);
    }
    public void saveButton(){
    	WebElement sButton = driver.findElement(By.id("form-button-save"));
    	sButton.click();
    	justWait();
    }
    public String validateCustomerCreation(){
    	WebElement message = driver.findElement(By.id("report-success"));
    	System.out.println(message.getText());
    	String text = message.getText();
    	return text;
    }
    
    public void backToList(){
    	driver.findElement(By.xpath("//*[@id='report-success']/p/a[2]")).click();
    	justWait();
    }
    public void searchForName(String name){
    	driver.findElement(By.cssSelector("i.el.el-search")).click();
    	justWait();
    	WebElement searchField = driver.findElement(By.xpath("//*[@id='gcrud-search-form']/div[1]/div[2]/a[3]/input"));
    	searchField.sendKeys(name);
    	searchField.sendKeys(Keys.RETURN);
    	justWait();
    }
    public void selectRow(){
    	driver.findElement(By.cssSelector("input.select-row")).click();
    }
    public void deleteRow(){
    	driver.findElement(By.cssSelector("a.btn.btn-outline-dark.delete-selected-button")).click();
    	justWait();
    }
    public String validateDeleteConfirmationQuestion(){
    	WebElement message = driver.findElement(By.cssSelector("p.alert-delete-multiple-one"));
    	System.out.println(message.getText());
    	String text = message.getText();
    	return text;
    }
    public String validateCustomerDeleted(){
    	WebElement message = driver.findElement(By.cssSelector(".alert.alert-success.growl-animated.animated.bounceInDown"));
    	System.out.println(message.getText());
    	String text = message.getText();
    	return text;
    }
    
    public void confirmDelete(){
    	driver.findElement(By.cssSelector("button.btn.btn-danger.delete-multiple-confirmation-button")).click();
    	justWait();
    }
    
    public void setup(){	
    	//driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	//driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
    	//System.out.println( "Hello World!" );
    }
    public void teardown(){
    	driver.close();
    }
    public void goToUrl(){
    	driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
    }
    public void justWait() {
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
