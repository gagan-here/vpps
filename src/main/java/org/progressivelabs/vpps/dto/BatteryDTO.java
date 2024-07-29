package org.progressivelabs.vpps.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.progressivelabs.vpps.utils.RegExConstant;
import org.progressivelabs.vpps.utils.ValidationMessageConstant;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Valid
public class BatteryDTO {

    @NotEmpty(message = ValidationMessageConstant.NAME_REQUIRED)
    @Pattern(regexp = RegExConstant.STRING_REGEX, message = ValidationMessageConstant.NAME_FORMAT)
    private String name;
    @NotEmpty(message = ValidationMessageConstant.POSTCODE_REQUIRED)
    @Pattern(regexp = RegExConstant.POSITIVE_INTEGER, message = ValidationMessageConstant.POSTCODE_FORMAT)
    private String postcode;
    @NotEmpty(message = ValidationMessageConstant.WATT_CAPACITY_REQUIRED)
    @Pattern(regexp = RegExConstant.POSITIVE_INTEGER, message = ValidationMessageConstant.CAPACITY_FORMAT)
    private String wattCapacity;
}
