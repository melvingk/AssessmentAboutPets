package com.qa.AssessmentPet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ownersPage {

	@FindBy (xpath= "/html/body/app-root/app-owner-list/div/div/h2")
	private WebElement ownerName;
	
	public WebElement vetName() {
		return ownerName;

}
}
