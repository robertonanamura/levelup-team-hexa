Feature: Start Game
![Gamer](images/gamerErin.png)

Start a game for a given Character


Scenario Outline: Start Game
    Given a Character with name <characterName>
    When Player starts the Game
    Then the Game set the map size to <mapSize>
    And the initial positionX is <initialPositionX> 
    And the initial positionY is <initialPositionY>
    And the move count is <initialMoveCount>
    And character name is <characterNameOutput>
    Examples:
        | characterName | characterNameOutput | mapSize | initialPositionX | initialPositionY | initialMoveCount |
        | "Geo" | "Geo" | 100 | 0 | 0 | 0 |
        | "Roy" | "Roy" | 100 | 0 | 0 | 0 |

