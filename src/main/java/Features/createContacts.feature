Feature: Free CRM Create Contacts Feature

#With EXAMPLES keyword
Scenario Outline: Free CRM Create Contacts Test Scenarios outline

Given user is on Login page of "https://ui.cogmento.com/"
When title of the Login page is Free CRM
Then user will enter "<username>" and the "<password>"
And user will click on the login button
Then user is navigated to the Homepage
And user hovers and clicks on contacts icon
Then Contacts page is displayed to the user
Then user will be clicking on New button
And user will enter new user details to be created "<firstname>" and "<lastname>"
And clicks on Save
Then the created contacts can be validated on Contacts activity
#Then user closes the browser



Examples:
	| username             | password   | firstname | lastname   |
	| puneeth297@gmail.com | Krishna123 | Demo_FN_06_27_1 | Test_LN_06_27_1 |
	| puneeth297@gmail.com | Krishna123 | Demo_FN_06_27_2 | Test_LN_06_27_2 |