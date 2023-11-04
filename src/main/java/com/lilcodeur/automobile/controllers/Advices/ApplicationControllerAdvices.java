package com.lilcodeur.automobile.controllers.Advices;
import com.lilcodeur.automobile.DTO.ErreurRequets;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ApplicationControllerAdvices {
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler({EntityNotFoundException.class})
    public @ResponseBody ErreurRequets erreurException(EntityNotFoundException exception){
        return new ErreurRequets(null,exception.getMessage());
    }
}
