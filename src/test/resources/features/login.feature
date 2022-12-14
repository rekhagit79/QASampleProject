

Feature: Validate Login functionality	
		@Test
	Scenario Outline: Validate with valid username and valid password		
		Given user has launched the browser
		When user opens the application url "<url>"					 
		And user enters the userid as "<username>" and password "<password>"																	
		And user clicks the login button
		Then user is successfully logged into application with title "<title>"
		And user is logged out
							
		Examples:
		|username|password|url																						|title						|					
	  |Rekha	 |demo    |https://parabank.parasoft.com/parabank/index.htm|Accounts Overview|
	
	@Excel
	Scenario Outline: Validate with valid username and valid password with excel data	
		Given data is loaded for scenario "<TC_id>"	
		And user has launched the browser
		When user opens the application url					 
		And user enters the userid and password																	
		And user clicks the login button
		Then user is successfully logged into application with title title
		And user is logged out
							
		Examples:
		|TC_id|url																						|	
		|TC_001|https://parabank.parasoft.com/parabank/index.htm|				
	  |TC_002|https://parabank.parasoft.com/parabank/index.htm|
	
	
	
#	Scenario Outline: Validate with login page for invalid credentials
#		Given user enters the userid as "<username>"	and password "<password>"
#		When user clicks the login button
#		Then user should see the error message "<ErrorMessage>"
#	
#		
#		Examples: 
#		|username|password|ErrorMessage|
#		|Rekha	|					|Please enter a username and password|												
#		|				|demo			|Please enter a username and password|
#		|				|					|Please enter a username and password|
	