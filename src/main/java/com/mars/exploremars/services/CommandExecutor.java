package com.mars.exploremars.services;

import com.mars.exploremars.exceptions.InvalidCommandException;
import com.mars.exploremars.models.CommandEnum;
import com.mars.exploremars.models.Mission;
import com.mars.exploremars.models.Probe;

import java.util.ArrayList;

public class CommandExecutor {

    public static void executeCommandString(String commandString, Probe probe, Mission mission) throws InvalidCommandException {
        if (!commandString.matches("^[MLR]+$")){
            throw new InvalidCommandException(commandString, "Invalid character in string");
        }

        ArrayList<CommandEnum> commandList = CommandEnum.parseCommandString(commandString);

        for (CommandEnum command : commandList) {
            executeSingleCommand(command, probe);
            if (mission.isOutOfBounds(probe.getPosition())){
                probe.reverseMove();
                throw new InvalidCommandException(commandString, "Command results in invalid position");
            }
        }
    }

    private static void executeSingleCommand(CommandEnum command, Probe probe){
        switch (command) {
            case LEFT:
                probe.rotateLeft();
                return;
            case RIGHT:
                probe.rotateRight();
                return;
            case MOVE:
                probe.move();
        }
    }
}
