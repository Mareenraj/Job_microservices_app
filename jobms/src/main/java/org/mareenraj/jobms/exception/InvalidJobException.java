package org.mareenraj.jobms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJobException extends RuntimeException{
    public InvalidJobException(String message){
        super(message);
    }
}
