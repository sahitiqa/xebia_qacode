Feature: Checking Mockey API Endpoints

  @smoke
  Scenario Outline: To get and verify the values from the service response
    Given I enter the URL for the service
    When I get the response <Parameter>
    Then I assert for validation <Response> and <Body>

    Examples:
      | Parameter | Response | Body                                                                                                                                                       |
      | /posts/1  | 200      | quia et suscipitsuscipit recusandae consequuntur expedita et cumreprehenderit molestiae ut ut quas totamnostrum rerum est autem sunt rem eveniet architect |
