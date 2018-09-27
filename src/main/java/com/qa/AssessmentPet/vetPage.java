package com.qa.AssessmentPet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class vetPage {
	
	@FindBy (xpath= "/html/body/app-root/app-vet-list/div/div/h2")
	private WebElement vetName;
	
	public WebElement vetName() {
		return vetName;
	}
	

	@FindBy (xpath= "//*[@id=\"vets\"]/tbody/tr[1]/td[3]/button[1]")
	private WebElement vetButton;
	
	public void vetButton() {
	 vetButton.click();	

}
}

