Feature: Testing Pet Clinic

Scenario: U1
Given a vet
When I click on some records
Then I can see the care available for animals

	

Scenario: U2
Given an admin
When I update a record
Then the updated details are now shown

	

Scenario: U3
Given an admin  
When I delete a animal   
Then emails arent sent to deceased animal owners
	
	

Scenario: U4
Given an admin 
When I add new records  
Then the records are correct
	

	
Scenario: U5
Given an admin   
When I add new owners to the records
Then the details show the change

 
 
 


 