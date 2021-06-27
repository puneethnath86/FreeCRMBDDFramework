Feature: Free CRM Create Deals Data Feature

Scenario: Free CRM Create new deals Test Scenarios

Given user is already on Login page
When title of Login page is Free CRM
Then user enters username and the password
| puneeth297@gmail.com | Krishna123 |

Then user clicks on the login button
And user is on Homepage
Then user hovers on deals icon and clicks
And deals page is displayed
Then user clicks on New button
And user will enter deal details
| TestDeal_1 | 10000 | 80 | 20 |

And clicks on Save
Then user navigates to home page
Then the created deals can be validated on deals activity
Then user closes the browser