# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As an api user I want to retrieve some spring boot followers user

  Scenario: Get the oldest user accounts with zero followers
    Given url microserviceUrl
    And path '/followers'
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation
    * def followerSchema = {  id : '#string',login : '#string',  html_url : '#string'}
     # The response should have an array of 2 quote objects
    And match response == '#[2] followerSchema'

