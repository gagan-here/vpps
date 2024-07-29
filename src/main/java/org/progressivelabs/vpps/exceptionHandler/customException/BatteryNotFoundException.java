package org.progressivelabs.vpps.exceptionHandler.customException;

public class BatteryNotFoundException extends RuntimeException {

    public BatteryNotFoundException(String message) {
        super(message);
    }

}

