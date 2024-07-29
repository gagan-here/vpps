package org.progressivelabs.vpps.exceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.progressivelabs.vpps.dto.BatteryResponseDTO;
import org.progressivelabs.vpps.exceptionHandler.customException.BatteryNotFoundException;
import org.progressivelabs.vpps.exceptionHandler.customException.EmptyListException;
import org.progressivelabs.vpps.exceptionHandler.customException.ErrorMessage;
import org.progressivelabs.vpps.exceptionHandler.customException.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BatteryNotFoundException.class)
    public ResponseEntity<BatteryResponseDTO<String>> handleBatteryNotFoundException(BatteryNotFoundException ex) {
        BatteryResponseDTO<String> response = new BatteryResponseDTO<>(
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> constraintViolationException(final ConstraintViolationException ex, final HttpServletRequest httpServletRequest) {
        ErrorMessage errorResponse = new ErrorMessage();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST);
        errorResponse.setApiPath(httpServletRequest.getRequestURI());
        ex.getConstraintViolations().forEach(violation -> errorResponse
                .getErrors().add(violation.getMessage()));
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<ExceptionResponseDTO> emptyListException(final EmptyListException ex, final HttpServletRequest request) {
        ExceptionResponseDTO error = new ExceptionResponseDTO(ex.getLocalizedMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
