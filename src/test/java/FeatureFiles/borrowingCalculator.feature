# This feature file consists of Borrowing Calculator scenarios
# @Author: Muthu Kumar.C

@Calculate
Feature: Borrowing calculator

  Scenario Outline: I want to estimate how much I may be able to borrow based on my current income and existing financial commitments
    Given I am in borrowing calculator page
    When I fill my details "<Applicant_Type>" "<Dependants>" "<Purpose_Of_Buy>"
    And I fill my earnings details "<Income>" "<Other_Income>"
    And I fill my expenses "<Expense>" "<Home_Loan_Repayment>" "<Other_Loan_Payment>" "<Commitments>" "<CreditCard_Limit>"
    And I click on work out borrow button
    Then I should get borrowing estimate of "<Estimate>"

    Examples:
    |Applicant_Type|Dependants|Purpose_Of_Buy|Income|Other_Income|Expense|Home_Loan_Repayment|Other_Loan_Payment|Commitments|CreditCard_Limit|Estimate|
    |Single        |0         |Live          |80000 |10000      |500    |0                |100             |0           |10000          |470000        |

  Scenario Outline: I want to clear all the entered loan details
    Given I am in borrowing calculator page
    When I fill my details "<Applicant_Type>" "<Dependants>" "<Purpose_Of_Buy>"
    And I fill my earnings details "<Income>" "<Other_Income>"
    And I fill my expenses "<Expense>" "<Home_Loan_Repayment>" "<Other_Loan_Payment>" "<Commitments>" "<CreditCard_Limit>"
    And I click on work out borrow button
    And I click on start over button
    Then All the fields gets cleared

    Examples:
      |Applicant_Type|Dependants|Purpose_Of_Buy|Income|Other_Income|Expense|Home_Loan_Repayment|Other_Loan_Payment|Commitments|CreditCard_Limit|Estimate|
      |Joint         |2         |Investment    |80000 |10000       |500    |100                |100               |100        |10000           |479000  |

  Scenario Outline: I want to estimate borrow by filling only living expenses and leaving all other fields as zero
    Given I am in borrowing calculator page
    And I fill only living expenses "<Expense>"
    And I click on work out borrow button
    Then I should not get estimation and get valid proper error message

    Examples:
      |Expense|
      |1      |