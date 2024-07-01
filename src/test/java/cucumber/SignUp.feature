Feature: Account Creation on SofwareTestingBoard

  Scenario Outline: Successful Account Creation
    Given the user is on the Home page
    When the user click on create account button
    When the user enters "<FirstName>" as first name
    And the user enters "<LastName>" as last name
    And the user enters "<Email>" as email
    And the user enters "<Password>" as password
    And the user enters "<ConfirmPassword>" as confirm password
    And the user clicks on the Create an Account button
    Then the account should be created successfully, and the user is redirected to the Account Page
    And the user should able to see Account information "<FirstName>" "<LastName>" "<Email>"

    Examples: 
      | FirstName | LastName | Email                                 | Password    | ConfirmPassword |
      | John      | Doe213   | kodd365hd1nh1344WW.do77189e2@test.com | Pas2sword1! | Pas2sword1!     |

  Scenario Outline: Successful Account Creation for special character in name and last name
    Given the user is on the Home page
    When the user click on create account button
    When the user enters "<FirstName>" as first name
    And the user enters "<LastName>" as last name
    And the user enters "<Email>" as email
    And the user enters "<Password>" as password
    And the user enters "<ConfirmPassword>" as confirm password
    And the user clicks on the Create an Account button
    Then the error messages "message" is displayed for the field "<field>" on "Sign Up" page

    Examples: 
      | FirstName | LastName | Email                         | Password    | ConfirmPassword | field     | message                  |
      | @John     | Doe21    | abohd1n344.do77189e2@test.com | Pas2sword1! | Pas2sword1!     | firstname | First Name is not valid! |
      | John      | Do!e21   | abohd1n344.do77189e2@test.com | Pas2sword1! | Pas2sword1!     | firstname | Last Name is not valid!  |

  Scenario Outline: Successful Account Creation with Capital letter of email
    Given the user is on the Home page
    When the user click on create account button
    When the user enters "<FirstName>" as first name
    And the user enters "<LastName>" as last name
    And the user enters "<Email>" as email
    And the user enters "<Password>" as password
    And the user enters "<ConfirmPassword>" as confirm password
    And the user clicks on the Create an Account button
    Then the account should be created successfully, and the user is redirected to the Account Page
    And the user should able to see Account information "<FirstName>" "<LastName>" "<Email>"

    Examples: 
      | FirstName | LastName | Email                     | Password    | ConfirmPassword | field            |
      | John1     | Doe22    | AABABSBBCCCDD@EXAMPLE.COM | Pas2sword1! | Pas2sword1!     | confrim password |

  Scenario Outline: Leave all input fields empty
    Given the user is on the Home page
    When the user click on create account button
    When the user enters "<FirstName>" as first name
    And the user enters "<LastName>" as last name
    And the user enters "<Email>" as email
    And the user enters "<Password>" as password
    And the user enters "<ConfirmPassword>" as confirm password
    And the user clicks on the Create an Account button
    Then the error messages "This is a required field." are displayed for the empty mandatory fields on "Sign Up" page

    Examples: 
      | FirstName | LastName | Email | Password | ConfirmPassword |
      |           |          |       |          |                 |

  Scenario Outline: Invalid email
    Given the user is on the Home page
    When the user click on create account button
    When the user enters "<FirstName>" as first name
    And the user enters "<LastName>" as last name
    And the user enters "<Email>" as email
    And the user enters "<Password>" as password
    And the user enters "<ConfirmPassword>" as confirm password
    And the user clicks on the Create an Account button
    Then the account should be created successfully, and the user is redirected to the Account Page
    Then the error messages "Please enter a valid email address (Ex: johndoe@domain.com)." is displayed for the field "<field>" on "Sign Up" page

    Examples: 
      | FirstName | LastName | Email             | Password    | ConfirmPassword | field |
      | John      | Doe21    | invalidemail      | Pas2sword1! | Pas2sword1!     | email |
      | John      | Doe21    | @invalidemail.com | Pas2sword1! | Pas2sword1!     | email |
      | John      | Doe21    | invalidemail@     | Pas2sword1! | Pas2sword1!     | email |

  Scenario Outline: Password & Confirm password mismatch
    Given the user is on the Home page
    When the user click on create account button
    When the user enters "<FirstName>" as first name
    And the user enters "<LastName>" as last name
    And the user enters "<Email>" as email
    And the user enters "<Password>" as password
    And the user enters "<ConfirmPassword>" as confirm password
    And the user clicks on the Create an Account button
    Then the error messages "Please enter the same value again." is displayed for the field "<field>" on "Sign Up" page

    Examples: 
      | FirstName | LastName | Email                        | Password    | ConfirmPassword | field           |
      | John      | Doe21    | johd1n344.do77189e2@test.com | Pas2sword1! | Pas2sword1      | confirm pasword |

  Scenario Outline: Password check - length, weak
    Given the user is on the Home page
    When the user click on create account button
    When the user enters "<FirstName>" as first name
    And the user enters "<LastName>" as last name
    And the user enters "<Email>" as email
    And the user enters "<Password>" as password
    And the user enters "<ConfirmPassword>" as confirm password
    And the user clicks on the Create an Account button
    Then the error messages "<message>" is displayed for the field "<field>" on "Sign Up" page

    Examples: 
      | FirstName | LastName | Email                        | Password     | ConfirmPassword | field    | message                                                                                                                                 |
      | John      | Doe21    | johd1n344.do77189e2@test.com |      1234567 |         1234567 | password | Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.                      |
      | John      | Doe21    | johd1n344.do77189e2@test.com |     12345678 |        12345678 | password | Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters. |
      | John      | Doe21    | johd1n344.do77189e2@test.com | 1234567as    | 1234567as       | password | Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters. |
      | John      | Doe21    | johd1n344.do77189e2@test.com | abcdefghijkl | abcdefghijkl    | password | Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters. |

  Scenario Outline: Account already present
    Given the user is on the Home page
    When the user click on create account button
    When the user enters "<FirstName>" as first name
    And the user enters "<LastName>" as last name
    And the user enters "<Email>" as email
    And the user enters "<Password>" as password
    And the user enters "<ConfirmPassword>" as confirm password
    And the user clicks on the Create an Account button
    Then the error messages "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account." is displayed for the field "<field>" on "Sign Up" page

    Examples: 
      | FirstName | LastName | Email                        | Password    | ConfirmPassword | field |
      | John      | Doe21    | johd1n344.do77189e2@test.com | Pas2sword1! | Pas2sword1!     |       |
