package com.mars.exploremars;

import com.mars.exploremars.core.Direction;
import com.mars.exploremars.core.Position;
import com.mars.exploremars.core.Probe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProbeTests {
    Probe probe;

    @BeforeEach
    void setProbe() {
        probe = new Probe(1,0,0, Direction.NORTH);
    }

    @Test
    @DisplayName("Rotating left from North should go West")
    void shouldRotateLeft() {
        probe.rotateLeft();
        assert probe.getDirection() == Direction.WEST;
    }


    @Test
    @DisplayName("Rotating right from North should go East")
    void shouldRotateRight() {
        probe.rotateRight();
        assert probe.getDirection() == Direction.EAST;
    }

    @Test
    @DisplayName("Moving probe North should add one to y coordinate")
    void shouldMove() {
        Position expectedPosition = new Position(0, 1);
        probe.move();
        assert probe.getPosition().equals(expectedPosition);
    }

}
