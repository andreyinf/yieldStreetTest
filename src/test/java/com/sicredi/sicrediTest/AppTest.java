package com.sicredi.sicrediTest;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the Test Class where the tests are created!
 * Sicredi Test by Andrey Aires.
 */

public class AppTest 
{
	Workflow appWorkflow = new Workflow();
    
	@Before
	public void Setup(){
		appWorkflow.setup();
	}
	
	@After
	public void teardown(){
		appWorkflow.teardown();
	}
	
    @Test
    public void createDeleteNewCustomer()
    {
    	appWorkflow.goToUrl();
    	appWorkflow.selectVersion();
    	appWorkflow.addNewCustomer();
    	appWorkflow.saveCustomer();
    	assertTrue( appWorkflow.IsTheCustomerCreated() );
    	
    	appWorkflow.backToList();
    	appWorkflow.deleteCustomer();
    	assertTrue( appWorkflow.IsTheConfirmationMessageDisplayed() );
    	
    	appWorkflow.clickToConfirmDelete();
    	assertTrue( appWorkflow.IsTheCustomerDeleted() );
    }
    
}
