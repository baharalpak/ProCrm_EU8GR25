@wipBahar
Feature: SCRUM-897

  As a user, I should be able to send messages by clicking on Message tab under Active Stream.

  @SCRUM-901 @BUG
  Scenario Outline: User should be able to insert videos by clicking on the video icon and entering the YOUTUBE video URL.
    Given "<user>" user is on homepage
    When User clicks Message button.
    And User clicks Insert video icon.
    * User fills Video source box with "https://www.youtube.com/watch?v=ewrBalT_eBM".
    Then Verify that user can add video.

    Examples:
      | user      |
      | hr        |
      | marketing |
      | helpdesk  |

  @SCRUM-902 @BUG
  Scenario Outline: User should be able to insert videos by clicking on the video icon and entering the VIMEO video URL.
    Given "<user>" user is on homepage
    When User clicks Message button.
    And User clicks Insert video icon.
    * User fills Video source box with "https://vimeo.com/259411563".
    Then Verify that user can add video.

    Examples:
      | user      |
      | hr        |
      | marketing |
      | helpdesk  |

  @SCRUM-903
  Scenario Outline: User should be able to create a quote by clicking on the Comma icon.
    Given "<user>" user is on homepage
    When User clicks Message button.
    And User clicks Comma icon.
    * User fills Quote box with a quote.
    * User clicks Send button.
    Then Verify that user can "create quote".

    Examples:
      | user      |
      | hr        |
      | marketing |
      | helpdesk  |

  @SCRUM-904
  Scenario Outline: User should be able to add mention by clicking on the Add mention icon.
    Given "<user>" user is on homepage
    When User clicks Message button.
    And User clicks Add mention icon.
    * User fills Message Title which is mandatory field with a message title.
    * User clicks on Add more link.
    * User clicks Employees and Departments.
    * User adds mentions below.
      | hr1@cybertekschool.com         |
      | helpdesk19@cybertekschool.com  |
      | marketing37@cybertekschool.com |
      | hr83@cybertekschool.com        |
      | helpdesk31@cybertekschool.com  |
      | marketing59@cybertekschool.com |
    * User clicks Send button.
    Then Verify that user can "add mention".

    Examples:
      | user      |
      | hr        |
      | marketing |
      | helpdesk  |


  @SCRUM-905
  Scenario Outline: User should be able to send a message.
    Given "<user>" user is on homepage
    When User clicks Message button.
    And User fills Message Title which is mandatory field with a message title.
    * User clicks Send button.
    Then Verify that user can "send a message".

    Examples:
      | user      |
      | hr        |
      | marketing |
      | helpdesk  |

  @SCRUM-906
  Scenario Outline: User CAN NOT send a message without filling mandatory fields. (Negative)
    Given "<user>" user is on homepage
    When User clicks Message button.
    And User clicks Send button.
    Then Verify that user CAN NOT send a message.

    Examples:
      | user      |
      | hr        |
      | marketing |
      | helpdesk  |

  @SCRUM-914
  Scenario Outline: User should be able to click on upload files icon to upload files and pictures from local disks.
    Given "<user>" user is on homepage
    When User clicks Message button.
    And User clicks Upload Files icon.
    * User uploads "the FILE/PICTURE" to Upload files and images box.
    Then Verify that user can upload the "FILE/PICTURE".

    Examples:
      | user      |
      | hr        |
      | marketing |
      | helpdesk  |

  @SCRUM-916
  Scenario Outline: User should be able to attach link by clicking on the link icon.
    Given "<user>" user is on homepage
    When User clicks Message button.
    And User clicks Link icon.
    * User attach the link to Link URL Box.
    * User clicks Save button.
    * User clicks Send button.
    Then Verify that user can "attach link".

    Examples:
      | user      |
      | hr        |
      | marketing |
      | helpdesk  |

  @SCRUM-917
  Scenario Outline: User should be able to add List of users from selecting multiple contacts from Employees and Departments contact lists.
    Given "<user>" user is on homepage
    When User clicks Message button.
    And User fills Message Title which is mandatory field with a message title.
    * User clicks on Add more link.
    * User adds List of users from selecting multiple contacts below.
      | hr1@cybertekschool.com         |
      | helpdesk19@cybertekschool.com  |
      | marketing37@cybertekschool.com |
      | hr83@cybertekschool.com        |
      | helpdesk31@cybertekschool.com  |
      | marketing59@cybertekschool.com |
    * User clicks Send button.
    Then Verify that users are added.

    Examples:
      | user      |
      | hr        |
      | marketing |
      | helpdesk  |

