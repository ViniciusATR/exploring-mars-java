package com.mars.exploremars;

import com.mars.exploremars.Exceptions.InvalidCommandException;
import com.mars.exploremars.Exceptions.OutOfBoundsException;
import com.mars.exploremars.Models.CommandEnum;
import com.mars.exploremars.Models.Direction;
import com.mars.exploremars.Models.Mission;
import com.mars.exploremars.Models.Probe;
import com.mars.exploremars.Services.CommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CommandsTests {

    @Test
    @DisplayName("Should parse valid command string")
    void shouldParseValidCommand(){
        String validCommand = "LMRM";

        ArrayList<CommandEnum> expectedParsedArray = new ArrayList<CommandEnum>();
        expectedParsedArray.add(CommandEnum.LEFT);
        expectedParsedArray.add(CommandEnum.MOVE);
        expectedParsedArray.add(CommandEnum.RIGHT);
        expectedParsedArray.add(CommandEnum.MOVE);

        ArrayList<CommandEnum> parsedCommandList = CommandEnum.parseCommandString(validCommand);

        assert expectedParsedArray.equals(parsedCommandList);

    }

    @Test
    @DisplayName("Valid command should be executed")
    void shouldExecuteValidCommand() throws OutOfBoundsException, InvalidCommandException {

        Mission mission = new Mission(1, 5, 5);
        int probeId = mission.launchProbe(1,2, Direction.NORTH);
        String command = "LMLMLMLMM";
        Probe expectedProbe = new Probe(0, 1, 3, Direction.NORTH);

        CommandExecutor.executeCommandString(command, mission.getProbe(probeId), mission);

        assert expectedProbe.equals(mission.getProbe(probeId));
    }

    @Test
    @DisplayName("Should throw exception in case of invalid command string")
    void shouldThrowExceptionForInvalidString() throws OutOfBoundsException {

        Mission mission = new Mission(1, 5, 5);
        int probeId = mission.launchProbe(1,2, Direction.NORTH);
        String command = "ABCLMLMLMLMM";

        InvalidCommandException error = Assertions.assertThrows(InvalidCommandException.class,
                () -> CommandExecutor.executeCommandString(command, mission.getProbe(probeId), mission));

    }

    @Test
    @DisplayName("Should throw exception in case of invalid position reached")
    void shouldThrowExceptionForInvalidPosition() throws OutOfBoundsException {

        Mission mission = new Mission(1, 5, 5);
        int probeId = mission.launchProbe(4,4, Direction.NORTH);
        String command = "MMMMMMMM";

        InvalidCommandException error = Assertions.assertThrows(InvalidCommandException.class,
                () -> CommandExecutor.executeCommandString(command, mission.getProbe(probeId), mission));

    }

}
