package com.mars.exploremars.Exceptions;

import com.mars.exploremars.Models.Position;

public class OutOfBoundsException extends Exception {

    public OutOfBoundsException(String errorMessage, Position position) {
        super("Out of Bounds Exception:" + errorMessage + " " + position.toString() + " is invalid");
    }

}
