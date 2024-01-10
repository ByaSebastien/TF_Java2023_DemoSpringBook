package be.bstorm.tf_java2023_demospringbook.api.models.dtos;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Data
public class ErrorDTO {

    private int statusCode;
    private HttpStatus status;
    private String message;
    private LocalDateTime time;

    public ErrorDTO(HttpStatus status, String message) {
        this.status = status;
        this.statusCode = status.value();
        this.message = message;
        this.time = LocalDateTime.now();
    }
}
