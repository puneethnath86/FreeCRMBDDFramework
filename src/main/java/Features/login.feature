Feature: Free CRM Login Feature
#With EXAMPLES keyword
Scenario Outline: Free CRM Login Test Scenario

Given user is already on login page of "https://ui.cogmento.com/"
When title of login page is Free CRM
Then user enters "<Username>" and "<password>"
Then user clicks on login button
And user is on homepage
#Then close the browser

Examples:
	| Username | password |
	| puneeth297@gmail.com | Krishna123 |
	| naveenk | test@123 |

#Scenario: user is able to create a new contact
#Given user is already on homepage
#When user is doing mouse hover on contacts link
#And user clicks on New Contact link
#And user enters FN and LN
#And user clicks on save button
#Then verify new contact created