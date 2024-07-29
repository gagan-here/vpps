package org.progressivelabs.vpps.exceptionHandler.customException;

public class EmptyListException extends RuntimeException {

    public EmptyListException(String message) {
        super(message);
    }
}
