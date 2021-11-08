package com.mars.exploremars.Models;

import java.util.Objects;

public class Position {
    private int x;

    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() { return y; }

    public int getX() { return x; }

    public void changePosition(int xChange, int yChange) {
        this.x += xChange;
        this.y += yChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}