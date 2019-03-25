package com.sicredi.sicrediTest;

/**
 * This is the test workflow
 * Sicredi Test by Andrey Aires
 */

public class Workflow {
	
	Page app = new Page();
	
	//public Workflow initialize(){
		
	//	app.begin();
	//	return this;
	//}
	
	public Boolean IsTheCustomerCreated(){
		return app.validateCustomerCreation().contains("Your data has been successfully stored into the database");
	}
	
	public Boolean IsTheConfirmationMessageDisplayed(){
		return app.validateDeleteConfirmationQuestion().contains("Are you sure that you want to delete this 1 item?");
	}
	
	public Boolean IsTheCustomerDeleted(){
		return app.validateCustomerDeleted().contains("Your data has been successfully deleted from the database.");
	}
	
	public void setup(){
		app.setup();
	}
	
	public void teardown(){
		app.teardown();
	}
	
	public void goToUrl(){
		app.goToUrl();
	}
	
	public void selectVersion(){
		app.selectVersion("Bootstrap V4 Theme");
	}
	
	public void addNewCustomer(){
		app.addCustomerButton();
		app.nameField("Teste Sicredi");
		app.lastNameField("Teste");
		app.contactFirstNameField("Andrey");
		app.foneField("51 9999-9999");
		app.addressLineField1("Av Assis Brasil, 3970");
		app.addressLineField2("Torre D");
		app.cityField("Porto Alegre");
		app.stateField("RS");
		app.postalCodeField("91000-000");
		app.countryField("Brasil");
		app.fromEmployeer("Fixter");
		app.creditLimitField("200");
	}
	public void saveCustomer(){
		app.saveButton();
	}
	
	public void backToList(){
		app.backToList();
	}
	
	public void deleteCustomer(){
		app.searchForName("Teste Sicredi");
		app.selectRow();
		app.deleteRow();
	}
	public void clickToConfirmDelete(){
		app.confirmDelete();
	}
	
	
}
