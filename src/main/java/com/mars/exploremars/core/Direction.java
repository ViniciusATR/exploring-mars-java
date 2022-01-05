package com.mars.exploremars.core;

import com.mars.exploremars.exceptions.InvalidDirectionException;

public enum Direction {
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST( "W");

    private final String character;

    Direction(String character) {
        this.character = character;
    }

    public static Direction fromString(String text) throws InvalidDirectionException {
        for (Direction b : Direction.values()) {
            if (b.character.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new InvalidDirectionException(text);
    }
}
