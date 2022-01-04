package com.mars.exploremars.ports.requests;

import java.util.Objects;

public class CreateMissionRequest {
    private Integer limitX;
    private Integer limitY;

    public CreateMissionRequest(Integer limitX, Integer limitY) {
        this.limitX = limitX;
        this.limitY = limitY;
    }

    public Integer getLimitX() {
        return limitX;
    }

    public void setLimitX(Integer limitX) {
        this.limitX = limitX;
    }

    public Integer getLimitY() {
        return limitY;
    }

    public void setLimitY(Integer limitY) {
        this.limitY = limitY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateMissionRequest that = (CreateMissionRequest) o;
        return Objects.equals(limitX, that.limitX) && Objects.equals(limitY, that.limitY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limitX, limitY);
    }

    @Override
    public String toString() {
        return "CreateMissionRequest{" +
                "maximumX=" + limitX +
                ", maximumY=" + limitY +
                '}';
    }
}
