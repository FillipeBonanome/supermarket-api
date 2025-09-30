package br.com.fillipebonanome.Supermarket.infra.handler;

import br.com.fillipebonanome.Supermarket.infra.exception.ProductException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<FieldValidationErrorDTO> handleProductException(ProductException exception) {
        return ResponseEntity.badRequest().body(new FieldValidationErrorDTO(exception.getMessage()));
    }


    public record FieldValidationErrorDTO(String message) {
    }

}
