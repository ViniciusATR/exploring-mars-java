package com.mars.exploremars.Exceptions;

public class InvalidCommandException extends Exception {

    public InvalidCommandException(String invalidCommand, String reason) {
        super("Command \"" + invalidCommand + "\" is not a valid Command: " + reason);
    }

}
