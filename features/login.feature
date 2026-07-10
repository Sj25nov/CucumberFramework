Feature: User Login
  Scenario: Successfully Login
     Given the user is on nonprocommerce login page
     When the user gives the valid username and password(username: "test@gmail.com", password: "test@123")
     And the user clicked on login button
     Then the user should be redirected to my account page
     And user should be see the welcome msg
