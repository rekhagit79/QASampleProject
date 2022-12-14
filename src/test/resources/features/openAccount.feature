		
		
	Feature: Validate OpenAccount functionality
		
		#Background: 
		#	Given user has launched the browser
#			And user opens the application url "https://parabank.parasoft.com/parabank/index.htm"									 
#			And user enters the userid as "Rekha" and password "demo"																																
#			And user clicks the login button
#			And user is successfully logged into application with title "AppTitle"
			
											
		@Test
		Scenario Outline: Validate OpenAccout with different account type 
 			Given user has launched the browser
			And user opens the application url "<url>"									 
			And user enters the userid as "<username>" and password "<password>"																																
			And user clicks the login button
			And user is successfully logged into application with title "<title>"
			When the user click the OpenAccount link
			And user selects accout "<AccountType>" 
			And select an existing account
			And user click on Open New Account button
		  Then user can view the new account number
			And user is logged out
			
		  	
		Examples:
				|AccountType |url																					   |username|password|title	         |					
	      |SAVINGS   |https://parabank.parasoft.com/parabank/index.htm|Rekha	  |demo   |Accounts Overview|
				|CHECKING  |https://parabank.parasoft.com/parabank/index.htm|Rekha	  |demo   |Accounts Overview| 




@Excel
		Scenario Outline: Validate OpenAccout with different account type 
 			Given data is loaded for scenario "<TC_id>"	
 			And user has launched the browser
			And user opens the application url 									 
			And user enters the username and password 																														
			And user clicks the login button
			And user is successfully logged into application with title 
			When the user click the OpenAccount link
			And user selects accout AccountType 
			And select an existing account
			And user click on Open New Account button
		  Then user can view the new account number
			And user is logged out
			
		  	
		Examples:
				|TC_id |url																					   |				
	      |TC_001|https://parabank.parasoft.com/parabank/index.htm|
				|TC_002|https://parabank.parasoft.com/parabank/index.htm|  
		
				
#		Scenario Outline: Validate OpenAccout with different account type 
#		
#			Given the user click the OpenAccount link
#			And user selects accout "<AccountType>" 
#			And select an existing account
#			And user click on Open New Account button
#			Then  user can view the new account number
#			
#		  	
#		Examples:
#				|AccountType|url																					   |username|password|title	         |					
#	      |CHECKING   |https://parabank.parasoft.com/parabank/index.htm|Rekha	  |demo   |Accounts Overview|
#				|SAVINGS    |https://parabank.parasoft.com/parabank/index.htm|Rekha	  |demo   |Accounts Overview|
#		
		
		
		
		
		