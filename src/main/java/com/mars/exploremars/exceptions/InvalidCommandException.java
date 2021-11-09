package com.mars.exploremars.exceptions;

public class InvalidCommandException extends Exception {

    public InvalidCommandException(String invalidCommand, String reason) {
        super("Command \"" + invalidCommand + "\" is not a valid Command: " + reason);
    }

}
