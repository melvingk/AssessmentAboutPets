package com.qa.AssessmentPet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

		
		@FindBy (xpath= "/html/body/app-root/div[1]/nav/div/ul/li[1]/a")
		private WebElement homeSelect;
		
		public void selecthome() {
			homeSelect.click();
			
		}
		@FindBy (xpath= "/html/body/app-root/div[1]/nav/div/ul/li[3]/a")
		private WebElement vetSelect;
		
		public void selectvet() {
			vetSelect.click();
		}
		@FindBy (xpath= "/html/body/app-root/div[1]/nav/div/ul/li[3]/ul/li[1]/a")
		private WebElement vetAllSelect;
		
		public void selectAllvet() {
			vetAllSelect.click();
		}
		
			
			
		@FindBy (xpath= "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
		private WebElement ownerAllSelect;
		
		public void selectAllowner() {
			ownerAllSelect.click();	
		
		}
		
	}

		
