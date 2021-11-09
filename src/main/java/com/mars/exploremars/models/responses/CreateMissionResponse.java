package com.mars.exploremars.models.responses;

import java.util.Objects;

public class CreateMissionResponse {

    private Integer id;
    private Integer limitX;
    private Integer limitY;

    public Integer getLimitX() {
        return limitX;
    }

    public CreateMissionResponse(int id, Integer maximumX, Integer maximumY) {
        this.id = id;
        this.limitX = maximumX;
        this.limitY = maximumY;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        CreateMissionResponse that = (CreateMissionResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(limitX, that.limitX) && Objects.equals(limitY, that.limitY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, limitX, limitY);
    }

    @Override
    public String toString() {
        return "CreateMissionResponse{" +
                "id=" + id +
                ", limitX=" + limitX +
                ", limitY=" + limitY +
                '}';
    }
}
