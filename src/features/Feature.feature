Feature: feature test

	Scenario: Searching for Partners of EPAM
		When I move to "About"
		And I click on "Partners"
		Then I see a partners of EPAM

	Scenario: Searching for automation
		When I press the search button
		And I type a "automation"
		Then I see a list of dishes that have the word "automation"

	Scenario: Searching for "Our work"
		Given  I have changed the language of the site to Russian
		When I'm moving to "Решения и проекты"
		Then I see a list of articles that have the sentense "Решения и проекты"

Scenario: Reading the article
	Given I have changed the language of the site to English
	When I click on Careers
	Then I should see article "Work with us"

Scenario: Route to SolutionHub
	Given that I'm on the "How Do We Do It" page
	When I click on the words "our own IP"
	Then I go to the SolutionHub page

Scenario: Customer solution article
	Given that I am on the page "Our work"
	When I click on "Healthcare"
	And I click on "Learn more" for UnitedHealthcare
	Then I go to the solution page for this client

Scenario: Following a link instagram
	When I click "About"
	And I click "Instagram" logo
	Then I go to the  instagram page

Scenario: Going home
	Given I am on the "Services" page
	When I click on "Epam"
	Then I go to the main page