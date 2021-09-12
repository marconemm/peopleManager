package br.com.dio.peopleManager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IdNotInformedException extends Exception {
    public IdNotInformedException(String s) {
        super(s);
    }
}
