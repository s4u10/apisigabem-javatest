package com.s4u10.calculofrete.apisigabem.exceptions;
/**
 *
 *  @author s4u10
 *  @since 6/01/2022
 **/

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class CepNaoEncontradoException extends HttpStatusCodeException {
    public CepNaoEncontradoException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }

}
