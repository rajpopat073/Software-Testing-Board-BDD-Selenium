Feature: Account Creation on SofwareTestingBoard

  Scenario Outline: Successful Login
    Given the user is on the Home page
    When the user click on sigin button
    And the user enters "<Email>" in email
    And the user enters "<Password>" in password
    And the user clicks on the Sign in button
    Then the user should be able to LogIn and the user is redirected to the Home Page
    And the user should able to see "<FirstName>" "<LastName>" on Home Page

    Examples: 
      | FirstName | LastName | Email                         | Password    |
      | John      | Doe213   | kohd1n1344.do77189e2@test.com | Pas2sword1! |

  Scenario Outline: Invalid User name or password OR Empty username and password
    Given the user is on the Home page
    When the user click on sigin button
    And the user enters "<Email>" in email
    And the user enters "<Password>" in password
    And the user clicks on the Sign in button
    Then the error messages "<message>" is displayed for the field "<field>" on "SignIn" page

    Examples: 
      | Email        | Password    | field | message                                                                                                     |
      | test.com     | Pas2sword1! | email | Please enter a valid email address (Ex: johndoe@domain.com).                                                |
      |              |             | email | This is a required field.                                                                                   |
      | test@abc.com | Pas2sword1! |       | The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later. |
