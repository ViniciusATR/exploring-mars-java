package com.mars.exploremars;
import com.mars.exploremars.core.Position;
import com.mars.exploremars.exceptions.OutOfBoundsException;
import com.mars.exploremars.core.Direction;
import com.mars.exploremars.core.Mission;
import com.mars.exploremars.core.Probe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MissionTests {
    Mission mission;

    @BeforeEach
    void setMission() {
        mission = new Mission(1, 5,5 );
    }

    @Test
    @DisplayName("Can launch new probe")
    void shouldLaunchProbe() throws OutOfBoundsException {
        Probe expectedProbe = new Probe(0, 3,4, Direction.NORTH);
        Position position = new Position(3, 4);
        int probeId = mission.launchProbe(position, Direction.NORTH);
        assert mission.getProbe(0).equals(expectedProbe);
    }

    @Test
    @DisplayName("Cannot launch out of bounds probe")
    void shouldThrowOutOfBoundsException() {
        Probe expectedProbe = new Probe(0, 6,4, Direction.NORTH);
        Position position = new Position(6,4);
        OutOfBoundsException error = Assertions.assertThrows(OutOfBoundsException.class,
                () -> mission.launchProbe(position, Direction.NORTH));
    }
}
