package com.levelup.forestsandmonsters;

import java.awt.Point;

public class Map {
    
    private int width;
    private int height;
    private int DEFAULT_WIDTH = 9;
    private int DEFAULT_HEIGHT = 9;

    public Map() {
        createMap(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Map(int w, int h) throws MapInstantiationException{

        if (w < 0 || h < 0)
        throw new MapInstantiationException("Can't instantiate map with negative dimension");

        this.width = w;
        this.height = h;
    }

    public void init() {

    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void createMap(int w, int h) {

        this.width = w;
        this.height = h;
    }

    public boolean validatePosition(int x, int y) {

        if (x < 0 || y < 0)
        return false;

        return (x <= this.width && y <= this.height);
     }

    public Point calculatePosition(Point position, GameController.DIRECTION direction) {

        int x = position.x;
        int y = position.y;

        switch (direction) {
            case NORTH:
            y += 1;
            break;

            case SOUTH:
            y -= 1;
            break;

            case EAST:
            x += 1;
            break;

            case WEST:
            x -= 1;
            break;
        }

        boolean isValid = validatePosition(x, y);

        if (isValid)
            return new Point(x,y);
        else
            return position;

    }

    class MapInstantiationException extends Exception {

        private String message;

        public MapInstantiationException(String msg) {

            this.message = msg;

        }
    }
}
