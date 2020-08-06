# See
# https://github.com/intuit/karate#syntax-guide
# for how to write feature scenarios
Feature: As an api user I want to retrieve some spring boot followers user

  Scenario: Get the oldest user accounts with zero followers
    Given url microserviceUrl
    And path '/starsval'
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation
    * def stSchema = {  htmlUrl : '#string',watchersCount : '#string',  language : '#string', ,  description : '#string', ,  name : '#string'}
     # The response should have an array of 30 quote objects
    And match response == '#[30] stSchema'

