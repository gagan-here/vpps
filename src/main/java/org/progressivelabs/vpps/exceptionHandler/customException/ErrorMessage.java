package org.progressivelabs.vpps.exceptionHandler.customException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorMessage {

    private String apiPath;
    private HttpStatus status;
    private List<String> errors = new ArrayList<>();

}
