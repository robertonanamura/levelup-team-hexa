Feature: Move in a direction

    I want to move my character. If they attempt to move past a boundary, the results in no change in position.

    Scenario Outline: Move in a direction 
    Given the character starts at position with XCoordinate <startingPositionX>
    And starts at YCoordinate <startingPositionY>
    And the player choses to move in <direction>
    When the character moves
    Then the character is now at position with XCoordinate <endingPositionX>
    And YCoordinate <endingPositionY>

    Examples:
    |startingPositionX | startingPositionY | direction | endingPositionX | endingPositionY |
    |5|8|N|5|9|
    |9|9|S|9|8|
    |1|4|W|0|4|
    |1|4|E|2|4|
    |3|9|S|3|8|
