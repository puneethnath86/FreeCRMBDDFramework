Feature: Free CRM Create Deals Data Feature using MAP concept

Scenario: Free CRM Create new deals Test Scenarios using MAP concept

Given user is already on Login page
When title of Login page is Free CRM
Then user enters username and the password
		| username | password |
		| puneeth297@gmail.com | Krishna123 |

Then user clicks on the login button
And user is on Homepage
Then user hovers on deals icon and clicks
Then user clicks on New button
And user will enter deal details
		| dealtitle | amount | probablity | commission |
		| TestDeal_06_27_1 | 10000 | 80 | 20 |
		| TestDeal_06_27_2 | 20000 | 70 | 30 |
		| TestDeal_06_27	_	3 | 30000 | 60 | 35 |

#And clicks on Save
Then user navigates to home page
Then the created deals can be validated on deals activity
Then user closed browser	