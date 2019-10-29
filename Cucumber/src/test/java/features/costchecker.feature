Feature: Validate that NHS costs is free when condition are met
	Costs Checking for Wales customer
    As a person from Wales
    I need to know what help I can get with my NHS costs
    So that I can get the treatment I need

Scenario: You or your partner get qualifying universal credit you get help paying NHS costs

Given I am on NHS cost checking portal
    When I start my journey to get NHS costs
    And for "Which country do you live in?" "WALES" and click next
    And enter dd as "20" mm as "05" yy as "1989" for What is your date of birth and navigate to next screen
    And select "Yes" for "Do you live with a partner?" question and navigate to next screen
    And choose "Yes" for "Do you or your partner claim any benefits or tax credits?" question and navigate to next screen
    And set "Yes, we receive Universal Credit payments" for question "Do you or your partner get paid Universal Credit?" navigate to next screen
    And user slects "Yes" for "As part of your joint Universal Credit, do you have any of these?" question and navigate to next screen
    And User selects "Yes" for take-home pay of £935 or less in your last Universal Credit period and click next
    Then user should get only NHS prescriptions as free 
    
Scenario: You or your partner get qualifying universal credit you get help paying NHS costs

Given I am on NHS cost checking portal
    When I start my journey to get NHS costs
    And for "Which country do you live in?" "WALES" and click next
    And enter dd as "20" mm as "05" yy as "1989" for What is your date of birth and navigate to next screen
    And select "Yes" for "Do you live with a partner?" question and navigate to next screen
    And choose "Yes" for "Do you or your partner claim any benefits or tax credits?" question and navigate to next screen
    And set "No, we get a different benefit" for question "Do you or your partner get paid Universal Credit?" navigate to next screen 
    And check screen "While you and your partner are waiting on a Universal Credit decision" displayed and navigate to next screen
    And Select Income Support for Do you or your partneet any of these benefits and navigate to next screen
    Then user should get You or your partner's Income Support entitles you to help with NHS costs Page
   
    
    
 