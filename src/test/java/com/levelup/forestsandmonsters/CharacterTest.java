package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Executable;

import org.junit.Test;

import com.levelup.forestsandmonsters.Character;
import com.levelup.forestsandmonsters.GameController.DIRECTION;

import java.awt.Point;

public class CharacterTest {
   
    @Test
    public void numberOfMovesTest() {
        Map map = new Map();
        Point point = new Point(0,0);
        Character character = new Character("Test");
        character.init(map, point);


        int numOfMoves = character.getNumOfMoves();
        assertEquals(numOfMoves, 0);

        try {
            character.move(DIRECTION.EAST);
        } catch(GameNotStartedException e) {
            System.err.println("Exception while moving:" + e.getMessage());
        }

         numOfMoves = character.getNumOfMoves();
        assertEquals(numOfMoves, 1);

        try {
            character.move(DIRECTION.NORTH);
        } catch(GameNotStartedException e) {
            System.err.println("Exception while moving:" + e.getMessage());
        }

        numOfMoves = character.getNumOfMoves();
        assertEquals(numOfMoves, 2);

        try {
            character.move(DIRECTION.SOUTH);
        } catch(GameNotStartedException e) {
            System.err.println("Exception while moving:" + e.getMessage());
        }

        numOfMoves = character.getNumOfMoves();
        assertEquals(numOfMoves, 3);

        try {
            character.move(DIRECTION.WEST);
        } catch(GameNotStartedException e) {
            System.err.println("Exception while moving:" + e.getMessage());
        }

        numOfMoves = character.getNumOfMoves();
        assertEquals(numOfMoves, 4);

    }

    @Test
    public void characterInitTest() {
        Map map = new Map();
        Point point = new Point(0,0);
        Character character = new Character("Test");
        character.init(map, point);


        int numOfMoves = character.getNumOfMoves();
        assertEquals(numOfMoves, 0);

        try {
            character.move(DIRECTION.EAST);
        } catch(GameNotStartedException e) {
            System.err.println("Exception while moving:" + e.getMessage());
        }
  
        try {
            character.move(DIRECTION.EAST);
        } catch(GameNotStartedException e) {
            System.err.println("Exception while moving:" + e.getMessage());
        }
        
        character.init(map, point);
        numOfMoves = character.getNumOfMoves();
        assertEquals(numOfMoves, 0);
    }


}