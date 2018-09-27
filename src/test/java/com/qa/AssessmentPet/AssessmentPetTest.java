package com.qa.AssessmentPet;



import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.Assert.*;


import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.RestAssured. *;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;



public class AssessmentPetTest {
	
	private RequestSpecification setup;
	private Response response;
	private ValidatableResponse valid;
	WebDriver driver= null;
	ExtentTest test;
	ExtentReports report = ConstantAssess.report; 

	
	@Before
	public  void setup() {
		
	System.setProperty("webdriver.chrome.driver", 
				"C:/Users/Admin/Desktop/testing exe/chromedriver.exe");

	}
	
	@Given("^a vet$")
	public void a_vet()  {
	 
		setup = RestAssured.given().contentType(ContentType.JSON);
		test = report.startTest("The start of the Test");
		driver = new ChromeDriver();
		driver.get(ConstantAssess.websiteURL1);	
	}

	@When("^I click on some records$")
	public void i_click_on_some_records()  {
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);   
		home.selectvet();
		
		HomePage select = PageFactory.initElements(driver, HomePage.class);   
		select.selectAllowner();
		
		response  = setup.when().get(ConstantAssess.websiteURL);	// gets the link and the page stuff
		System.out.println(response.asString());
		
		
	}

	@Then("^I can see the care available for animals$")
	public void i_can_see_the_care_available_for_animals()  {
	    
		 ownersPage name = PageFactory.initElements(driver, ownersPage.class);   
		 assertEquals("Veterinarians", name.vetName().getText());
		 test.log(LogStatus.PASS,"all available information is here");
		
		 valid = response.then().statusCode(200);
	}

	@Given("^an admin$")
	public void an_admin()  {
		
		setup = given().header("Content-Type", "application/json;charset=UTF-8");
		
		HomePage home = PageFactory.initElements(driver, HomePage.class);   
		home.selectvet();
		
	}

	@When("^I update a record$")
	public void i_update_a_record() {
	
		vetPage name = PageFactory.initElements(driver, vetPage.class);   
		name.vetButton();
		
		theVetPage change = PageFactory.initElements(driver, theVetPage.class); 
		change.change("Midas");
		
		JSONObject vets = new JSONObject();

		JSONObject speciality = new JSONObject();

		JSONArray specialties = new JSONArray();
		
		specialties.put(speciality);
		
//		 "id": 2,
//		    "firstName": "Helen",
//		    "lastName": "Leary",
//		    "specialties": [
//		      {
//		        "id": 1,
//		        "name": "radiology"
//		
		vets.put("id", 2);
		vets.put("firstName", "Helen");
		vets.put("lastName", "Kevin");
		vets.put("specialties", specialties);
		
		speciality.put("id", 3);
		speciality.put("name", "dentistry");

		baseURI = ConstantAssess.websiteURL;
		setup = given().header("Content-Type", "application/json").body(vets.toString());
	
		response = setup.when().put("/3");
		
	  
	}

	@Then("^the updated details are now shown$")
	public void the_updated_details_are_now_shown() throws Throwable {
	   
	
		vetPage name = PageFactory.initElements(driver, vetPage.class);   
		assertEquals("Midas", name.vetName().getText());
		valid= response.then().statusCode(204);
//		if(response.getStatusCode()==200)
//		{
//		test.log(LogStatus.PASS,"details updated");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL,"details updated");
//		}
//		
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		
	}

	@When("^I delete a animal$")
	public void i_delete_a_animal() {
		
		baseURI = ConstantAssess.websiteURL + "/pets";
		setup = given().header("Content-Type", "application/json;charset=UTF-8").body("id");
		response = setup.when().delete("/13");
		 
		//valid  = response.then().body("response body",equalTo("not content"));
	}

	@Then("^emails arent sent to deceased animal owners$")
	public void emails_arent_sent_to_deceased_animal_owners()  {
	   
	
		valid = response.then().statusCode(204);
		test.log(LogStatus.PASS,"details deleted");

	
	}

	@When("^I add new records$")
	public void i_add_new_records()  {
		
		JSONObject vets = new JSONObject();

		JSONObject speciality = new JSONObject();

		JSONArray specialties = new JSONArray();
		
		specialties.put(speciality);
		
//		 "id": 2,
//		    "firstName": "Helen",
//		    "lastName": "Leary",
//		    "specialties": [
//		      {
//		        "id": 1,
//		        "name": "radiology"
//		
		vets.put("id", 7);
		vets.put("firstName", "Big Man");
		vets.put("lastName", "Melvin");
		vets.put("specialties", specialties);
		
		speciality.put("id", 2);
		speciality.put("name", "surgery");

	
		baseURI = ConstantAssess.websiteURL;
		setup = given().header("Content-Type", "application/json;charset=UTF-8").body(vets.toString());
		response = setup.when().post(ConstantAssess.websiteURL);
		
		System.out.println(response.asString());

	}

	@Then("^the records are correct$")
	public void the_records_are_correct()  {
	    
		 valid = response.then().statusCode(201);
		 test.log(LogStatus.PASS,"details added");
	}

	@When("^I add new owners to the records$")
	public void i_add_new_owners_to_the_records()  {
	    
		JSONObject owner = new JSONObject();

		JSONObject pet = new JSONObject();

		JSONArray pets = new JSONArray();
		
		JSONObject visit = new JSONObject();
		
		JSONArray visits = new JSONArray();

		JSONArray types = new JSONArray();
		
		JSONObject type = new JSONObject();
		
		
		pets.put(pet);
		visits.put(visit);
		types.put(type);
		
		
//			  "address": "14",
//			  "city": "london",
//			  "firstName": "tim",
//			  "id": 1,
//			  "lastName": "hey",
//			  "pets": [
//			    {
//			      "birthDate": "2018-09-27T08:57:04.061Z",
//			      "id": 0,
//			      "name": "string",
//			      "owner": {},
//			      "type": {
//			        "id": 0,
//			        "name": "string"
//			      },
//			      "visits": [
//			        {
//			          "date": "yyyy/MM/dd",
//			          "description": "string",
//			          "id": 0,
//			          "pet": {}
//			        }
//			      ]
//			    }
//			  ],
//			  "telephone": "string"
//			}
//		
		owner.put("address", "avenue");
		owner.put("city", "Little Man");
		owner.put("firstName", "snitch");
		owner.put("id", 5);
		owner.put("lastName", "Mcgee");
		owner.put("pets", pets );
		owner.put("telephone", "47855488");
		
		
		pet.put("birthDate", "2018-09-27T08:57:04.061Z");
		pet.put("id", 2);
		pet.put("name", "bruno dog");
		pet.put("owner",5);
		pet.put("type",types );
		pet.put("visits", visits);
		
		
		visit.put("date", "2018/11/05");
		visit.put("description", "something");
		visit.put("id", 5);
		visit.put("pet", 0);

		type.put("id", 5);
		type.put("name", "dog");
		
		
		baseURI ="http://10.0.10.10:9966/petclinic/api/owners";
		setup = given().header("Content-Type", "application/json;charset=UTF-8").body(owner.toString());
		response = setup.when().put("http://10.0.10.10:9966/petclinic/api/owners");
		System.out.println(response);

	}

	@Then("^the details show the change$")
	public void the_details_show_the_change()  {
		
		valid = response.then().statusCode(201);
		test.log(LogStatus.PASS,"details have been changed");
	   
	}

	@After()
	public void teardown() throws InterruptedException
		{ 
			
			//Thread.sleep(3000);
			driver.close();
			driver.quit();
			report.endTest(test);
			report.flush();
	
		}

	

}
