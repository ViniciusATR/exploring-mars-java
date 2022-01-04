package com.mars.exploremars.ports.responses;

import com.mars.exploremars.core.Direction;
import com.mars.exploremars.core.Position;

import java.util.Objects;

public class SimpleProbeResponse {

    private final Integer id;
    private Direction direction;
    private Position position;

    public SimpleProbeResponse(Integer id, Direction direction, Position position) {
        this.id = id;
        this.direction = direction;
        this.position = position;
    }

    public Integer getId() {
        return id;
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
        SimpleProbeResponse that = (SimpleProbeResponse) o;
        return id.equals(that.id) && direction == that.direction && position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, direction, position);
    }

    @Override
    public String toString() {
        return "LaunchProbeRequest{" +
                "id=" + id +
                ", direction=" + direction +
                ", position=" + position +
                '}';
    }
}
