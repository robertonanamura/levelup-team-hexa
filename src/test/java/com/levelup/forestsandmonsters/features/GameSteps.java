package com.levelup.forestsandmonsters.features;

import static org.junit.Assert.assertEquals;

import com.levelup.forestsandmonsters.GameController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GameSteps {

    GameController gc = new GameController();
    String characterName;
    int positionX;
    int positionY;
    int totalMoves;

@Given("a Character with name {string}")
public void a_character_with_name(String characterName) {
    // Write code here that turns the phrase above into concrete actions
    //gc = new GameController();
    this.characterName = characterName; // throw new io.cucumber.java.PendingException();
}

@When("Player starts the Game")
public void player_starts_the_game() {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    gc.createCharacter(characterName);
    gc.startGame();
}

@Then("the Game set the map size to {int}")
public void the_game_set_the_map_size_to(Integer mapSize) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    assertEquals(gc.getTotalPositions(), 100);
}

@Then("the initial positionX is {int}")
public void the_initial_position_x_is(Integer initialX) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    assertEquals((int) gc.getStatus().currentPosition.x, (int) initialX);
}

@Then("the initial positionY is {int}")
public void the_initial_position_y_is(Integer initialY) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    assertEquals((int) gc.getStatus().currentPosition.y, (int) initialY);
}

@Then("the move count is {int}")
public void the_move_count_is(Integer moveCount) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    assertEquals( (int) gc.getMoveCount(), 0);
}

@Then("character name is {string}")
public void character_name_is(String charName) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    assertEquals(gc.getStatus().characterName, charName);
}

/* 
    @Given("the character's name is {string}")
    public void givenTheCharactersNameIs(String characterName) {
        this.characterName = characterName;
    }
    @When("the character sets their name")
    public void whenTheCharacterSetsTheirName() {
        gc = new GameController();
        gc.createCharacter(characterName);
    }
    @Then("the Game sets the character's name to {string}")
    public void thenTheGameSetsTheCharactersName(String expectedName) {
        assertEquals(expectedName, gc.getStatus().characterName);
    }
    */

}
