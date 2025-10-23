package dev.lucas.gatosAPI.infra;

import dev.lucas.gatosAPI.exceptions.GatoNotFoundException;
import dev.lucas.gatosAPI.exceptions.GatoNotNullException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ GatoNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail handleGatoNotFoundException(HttpServletRequest request, GatoNotFoundException e){
        var pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND , e.getMessage());
        pd.setTitle("Gato não encontrado!");
        pd.setType(URI.create("https:/www.someurl.com/erros/not-found"));
        return pd;
    }

    @ExceptionHandler({ GatoNotNullException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleGatoNotNullException(HttpServletRequest request, GatoNotNullException e) {
        var pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        pd.setTitle("Gato não preenchido");
        pd.setType(URI.create("https:/www.someurl.com/erros/bad-request"));
        return pd;
    }


}
