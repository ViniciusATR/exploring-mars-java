package com.mars.exploremars;
import com.mars.exploremars.Exceptions.OutOfBoundsException;
import com.mars.exploremars.Models.Direction;
import com.mars.exploremars.Models.Mission;
import com.mars.exploremars.Models.Probe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MissiontTests {
    Mission mission;

    @BeforeEach
    void setMission() {
        mission = new Mission(1, 5,5 );
    }

    @Test
    @DisplayName("Can launch new probe")
    void shouldLaunchProbe() {
        Probe expectedProbe = new Probe(0, 3,4, Direction.NORTH);
        try {
            int probeId = mission.launchProbe(3, 4, Direction.NORTH);
        } catch (OutOfBoundsException e ) {
            System.out.println(e.toString());
        }
        assert mission.getProbe(0).equals(expectedProbe);
    }

    @Test
    @DisplayName("Cannot launch out of bounds probe")
    void shouldThrowOutOfBoundsException() {
        Probe expectedProbe = new Probe(0, 6,4, Direction.NORTH);
        OutOfBoundsException error = Assertions.assertThrows(OutOfBoundsException.class,
                () -> mission.launchProbe(6, 4, Direction.NORTH));
    }
}
