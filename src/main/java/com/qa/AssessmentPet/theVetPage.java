package com.qa.AssessmentPet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class theVetPage {
	
	@FindBy (id= "lastName")
	private WebElement nameField;

	@FindBy (xpath= "*[@id=\"vet_form\"]/div[5]/div/button[2]")
	private WebElement saveButton;
	
	public void change(String text) {
		nameField.sendKeys(text);
		saveButton.submit();
	}
}

