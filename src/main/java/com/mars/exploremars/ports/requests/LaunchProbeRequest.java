package com.mars.exploremars.ports.requests;

import java.util.Objects;

public class LaunchProbeRequest {

    private final String direction;
    private final Integer x;
    private final Integer y;

    public LaunchProbeRequest(String direction, Integer x, Integer y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaunchProbeRequest that = (LaunchProbeRequest) o;
        return Objects.equals(direction, that.direction) && Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, x, y);
    }

    @Override
    public String toString() {
        return "LaunchProbeRequest{" +
                "direction=" + direction +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
