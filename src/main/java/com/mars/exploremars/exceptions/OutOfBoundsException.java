package com.mars.exploremars.exceptions;

import com.mars.exploremars.core.Position;

public class OutOfBoundsException extends Exception {

    public OutOfBoundsException(String errorMessage, Position position) {
        super("Out of Bounds Exception:" + errorMessage + " " + position.toString() + " is invalid");
    }

}
