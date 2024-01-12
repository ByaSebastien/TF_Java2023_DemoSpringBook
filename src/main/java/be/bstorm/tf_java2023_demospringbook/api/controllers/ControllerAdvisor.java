package be.bstorm.tf_java2023_demospringbook.api.controllers;

import be.bstorm.tf_java2023_demospringbook.api.models.dtos.ErrorDTO;
import be.bstorm.tf_java2023_demospringbook.bll.services.exception.MultipleReviewException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleRuntimeException(Exception exception){
        return ResponseEntity.status(400).body(exception.getMessage());
    }

    @ExceptionHandler(MultipleReviewException.class)
    public ResponseEntity<ErrorDTO> handle(MultipleReviewException ex){
        return ResponseEntity.badRequest()
                .body(
                        new ErrorDTO(
                                HttpStatus.BAD_REQUEST,
                                ex.getMessage()
                        )
                );
    }
}
