package org.progressivelabs.vpps.utils;

public final class ValidationMessageConstant {

    private ValidationMessageConstant() {
    }

    private static final String REQUIRED = "Required: ";

    public static final String NAME_REQUIRED = REQUIRED + "Name is required";
    public static final String POSTCODE_REQUIRED = REQUIRED + "Postcode is required";
    public static final String WATT_CAPACITY_REQUIRED = REQUIRED + "Watt Capacity is required";
    public static final String NAME_FORMAT = "Name should only contain characters";
    public static final String POSTCODE_FORMAT = "Postcode should only contain positive numbers";
    public static final String CAPACITY_FORMAT = "Capacity should only contain positive numbers";
    public static final String EMPTY_LIST_ERROR_MESSAGE = "Battery list is empty";
}
