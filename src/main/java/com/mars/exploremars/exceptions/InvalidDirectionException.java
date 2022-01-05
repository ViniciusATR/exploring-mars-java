package com.mars.exploremars.exceptions;

public class InvalidDirectionException extends Exception{

    public InvalidDirectionException(String invalidDirection) {
        super("String \"" + invalidDirection + "\" is not a valid Direction: ");
    }

}
