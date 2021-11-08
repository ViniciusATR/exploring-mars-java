package com.mars.exploremars.Exceptions;

import com.mars.exploremars.Models.Position;

public class OutOfBoundsError extends Exception {

    public OutOfBoundsError(String errorMessage, Position position) {
        super("Out of Bounds Exception:" + errorMessage + " " + position.toString() + " is invalid");
    }

}
