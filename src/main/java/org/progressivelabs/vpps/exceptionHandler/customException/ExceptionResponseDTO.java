package org.progressivelabs.vpps.exceptionHandler.customException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponseDTO {

    private String message;
    private String callerUrl;

}
