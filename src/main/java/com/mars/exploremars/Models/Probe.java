package com.mars.exploremars.Models;

public class Probe {

    private final int id;
    private Direction direction;
    private Position position;

    public Probe(int id, int x, int y, Direction direction) {
        this.position = new Position(x, y);
        this.direction = direction;
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    public void rotateLeft(){
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
        }
    }

    public void rotateRight(){
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    public void move(){
        switch (direction){
            case NORTH:
                position.changePosition(0, 1);
                break;
            case EAST:
                position.changePosition(1,0);
                break;
            case SOUTH:
                position.changePosition(0,-1);
                break;
            case WEST:
                position.changePosition(-1,0);
                break;
        }
    }
}
