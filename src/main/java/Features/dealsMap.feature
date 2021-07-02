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
		| TestDeal_07_02_1 | 14320 | 40 | 10 |
		| TestDeal_07_02_2 | 26420 | 50 | 70 |
		| TestDeal_07_02_3 | 39060 | 60 | 55 |

#And clicks on Save
Then user navigates to home page
Then the created deals can be validated on deals activity
Then user closed browser	