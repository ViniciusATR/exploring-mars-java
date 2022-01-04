package com.mars.exploremars.ports.requests;

import com.mars.exploremars.core.Direction;
import com.mars.exploremars.core.Position;

import java.util.Objects;

public class LaunchProbeRequest {

    private Direction direction;
    private Position position;

    public LaunchProbeRequest(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaunchProbeRequest that = (LaunchProbeRequest) o;
        return direction == that.direction && position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash( direction, position);
    }

    @Override
    public String toString() {
        return "LaunchProbeRequest{" +
                "direction=" + direction +
                ", position=" + position +
                '}';
    }
}
