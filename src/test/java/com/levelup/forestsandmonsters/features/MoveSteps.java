package com.levelup.forestsandmonsters.features;

import com.levelup.forestsandmonsters.GameController;
import com.levelup.forestsandmonsters.GameControllerMock;
import com.levelup.forestsandmonsters.GameNotStartedException;
import com.levelup.forestsandmonsters.GameController.DIRECTION;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

public class MoveSteps {

    GameControllerMock gc;
    int startX, startY;
    GameController.DIRECTION direction;
    Point currentPosition;
    

    @Given("the character starts at position with XCoordinate {int}")
    public void the_character_starts_at_position_with_x_coordinate(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

        this.startX = int1;
    }
    
    @Given("starts at YCoordinate {int}")
    public void starts_at_y_coordinate(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        this.startY = int1;
    }
    
    @Given("the player choses to move in N")
    public void the_player_choses_to_move_in_n() {
        // Write code here that turns the phrase above into concrete actions
        this.direction = GameController.DIRECTION.NORTH;
    }
    
    @Given("the player choses to move in S")
    public void the_player_choses_to_move_in_s() {
        // Write code here that turns the phrase above into concrete actions
        this.direction = GameController.DIRECTION.SOUTH;
    }
    
    @Given("the player choses to move in W")
    public void the_player_choses_to_move_in_w() {
        // Write code here that turns the phrase above into concrete actions
        this.direction = GameController.DIRECTION.WEST;
    }
    
    @Given("the player choses to move in E")
    public void the_player_choses_to_move_in_e() {
        // Write code here that turns the phrase above into concrete actions
        this.direction = GameController.DIRECTION.EAST;
    }

    @When("the character moves")
    public void the_character_moves() throws GameNotStartedException {
        // Write code here that turns the phrase above into concrete actions
        gc = new GameControllerMock();
        gc.createCharacter("Geo");
        gc.setCharacterPosition(new Point(this.startX, this.startY));
        gc.startGame();
        gc.move(this.direction);
    }
    
    @Then("the character is now at position with XCoordinate {int}")
    public void the_character_is_now_at_position_with_x_coordinate(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(int1, gc.getStatus().currentPosition.x);
    }
    
    @Then("YCoordinate {int}")
    public void y_coordinate(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(int1, gc.getStatus().currentPosition.y);
    }
    
    

    /* 
    @Given("the character starts at position with XCoordinates {int}")
    public void givenTheCharacterStartsAtX (int startX) {
        this.startX = startX;
    }

    @Given("the character starts at position with YCoordinates {int}")
    public void givenTheCharacterStartsAtY (int startY) {
        this.startY = startY;
    }

    @Given ("the plyer choses to move in direction {word}")
    public void givenPlayerChoosesDirection (String direction)
    {
        this.direction=GameController.DIRECTION.valueOf(direction);        
    }


    @When("the character moves")
    public void theCharactersMoves() {
        gc = new GameController();
        gc.setCharacterPosition(new Point(this.startX,this.startY));
        gc.move(this.direction);
        GameController.GameStatus status = gc.getStatus();
        this.currentPosition = status.currentPosition;
    }

    @Then("the character is now at position with XCoordinates {int}")
    public void checkXCoordinates(int endX) {
        assertNotNull("Expected position not null", this.currentPosition);
        assertEquals(endX, this.currentPosition.x);
    }


    @Then("the character is now at position with YCoordinates {int}")
    public void checkYCoordinates(int endY) {
        assertNotNull("Expected position not null", this.currentPosition);
        assertEquals(endY, this.currentPosition.y);
    }

    // Copied from the error logs
    @Given("the character starts at position with XCoordinate {int}")
public void the_character_starts_at_position_with_x_coordinate(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    this.startX = startX;
}

@Given("starts at YCoordinate {int}")
public void starts_at_y_coordinate(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    this.startY = startY;
}

@Given("the player choses to move in direction {word}")
public void the_player_choses_to_move_in_direction(String direction) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    this.direction=GameController.DIRECTION.valueOf(direction); 
}

@Then("the character is now at position with XCoordinate {int}")
public void the_character_is_now_at_position_with_x_coordinate(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    assertNotNull("Expected position not null", this.currentPosition);
    assertEquals(endX, this.currentPosition.x);
}

@Then("YCoordinate {int}")
public void y_coordinate(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    assertNotNull("Expected position not null", this.currentPosition);
    assertEquals(endY, this.currentPosition.y);
}


@Given("the player choses to move in N")
public void the_player_choses_to_move_in_n() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("the player choses to move in S")
public void the_player_choses_to_move_in_s() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("the player choses to move in W")
public void the_player_choses_to_move_in_w() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("the player choses to move in E")
public void the_player_choses_to_move_in_e() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
*/
}
