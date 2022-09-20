package com.levelup.forestsandmonsters;

import java.awt.Point;

public class GameController { 
    // TODO: If your stakeholder wants to call this CHARACTER, change var name for
    // low representational gap
    static final String DEFAULT_CHARACTER_NAME = "Character";
    static final int INITIAL_X = 0;
    static final int INITIAL_Y = 0;

    public class GameStatus {
        // TODO: Add other status data
        public String characterName = DEFAULT_CHARACTER_NAME;
        public Point currentPosition = null;
        public int moveCount = 0;

        public void setCharacterPosition (Point coordinates) {
            this.currentPosition = coordinates;
        }
        public String toString() {
            return characterName + " you moved " + moveCount + " times and ended at (" + 
                currentPosition.x + "," + currentPosition.y + ")";
        }
    }

    protected Point initialPosition = new Point(INITIAL_X, INITIAL_Y);

    //Character is now responsible for the position, name and move count
    //GameStatus status;
    Map map;
    Character character;

    public GameController() {
        //status = new GameStatus();
    }

    public static enum DIRECTION {
        NORTH, SOUTH, EAST, WEST
    }

    // Pre-implemented to demonstrate ATDD
    // TODO: Update this if it does not match your design
    public void createCharacter(String name) {
        String characterName;
        if (name != null && !name.equals("")) {
            characterName = name;
        } else {
            characterName = DEFAULT_CHARACTER_NAME;
        }
        this.character = new Character(characterName);
    }

    public void startGame() {
        // TODO: Implement startGame - Should probably create tiles and put the character
        // on them?
        // TODO: Should also update the game results?
        this.map = new Map();
        if (this.character == null) {
            throw new IllegalStateException("Can not start game without creating the character");
        }
        this.character.init(map, this.initialPosition);
        System.out.println(getCharacter().getName() + " is at (" + 
            getCharacter().getCurrentPosition().x + "," + getCharacter().getCurrentPosition().y + ")");
        
    }

    public GameStatus getStatus() {
        GameStatus status = new GameStatus();
        status.characterName = this.character.getName();
        status.currentPosition = this.character.getCurrentPosition();
        status.moveCount = this.getMoveCount();
        return status;
    }

    public void move(DIRECTION directionToMove) throws GameNotStartedException {
        this.character.move(directionToMove);
        System.out.println(this.character.getName() + " you just moved " + directionToMove + 
        " and you are at (" + this.character.getCurrentPosition().x + "," + 
        this.character.getCurrentPosition().y + ")"); 
    } 

    public int getTotalPositions() {
        if (this.map != null) {
            return (this.map.getHeight() +1) * (this.map.getWidth() + 1);
        } else {
            return -1;
        }
    }
    public int getMoveCount() {
        return this.character.getNumOfMoves();
    }
    public Character getCharacter() {
        return this.character;
    }

    protected void setInitialPosition(Point initialPosition) {
        this.initialPosition = initialPosition;
    }
    protected Point getInitialPosition() {
        return this.initialPosition;
    }
}
