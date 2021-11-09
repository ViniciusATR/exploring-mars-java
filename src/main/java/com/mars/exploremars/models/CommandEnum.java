package com.mars.exploremars.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public enum CommandEnum {
    RIGHT,
    LEFT,
    MOVE;

    public static ArrayList<CommandEnum> parseCommandString(String commandSequence){
        ArrayList commandList = commandSequence.chars()
                                               .mapToObj(singleCommand -> parseSingleCommand((char) singleCommand))
                                               .collect(Collectors.toCollection(ArrayList::new));

        return commandList;
    }

    private static CommandEnum parseSingleCommand(char singleCommand) {
        switch (singleCommand) {
            case 'R':
                return CommandEnum.RIGHT;
            case 'L':
                return CommandEnum.LEFT;
            case 'M':
                return CommandEnum.MOVE;
            default:
                return null;
        }
    }

}
