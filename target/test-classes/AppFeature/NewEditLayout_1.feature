Feature: New Edit page feature

  Background: 
    Given User has already logged in to the application
      | username | password |
      | test1    | acid_qa  |

  Scenario Outline: New Edit page with different sets of data
    Given user navigates to new edit page
    When user enter the data "<cardt>" and "<LS>" and "<city1>" and "<SC>" and "<lname>" and "<mob>" and "<natID>" and "<thin>"
    And user clicks on save button
    And user clicks on New button

    Examples: 
      | cardt              | LS           | city1    | SC          | lname       | mob        | natID  | thin     |
      | CV mua nhà dài hạn | KH mới tự có | An Giang | 01.New Lead | Testlead110 | 9876544546 | 834813 | An Giang |
      | CV mua nhà dài hạn | KH mới tự có | An Giang | 01.New Lead | Testlead111 | 9876544540 | 834823 | An Giang |
