package com.s4u10.calculofrete.apisigabem.model;

/**
 *
 *  @author s4u10
 *
 **/

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Endereco {

    private String cep;
    private String ddd;
    private String uf;

    public Endereco() {
    }

    public Endereco(String cep, String ddd, String uf) {
        this.cep = cep;
        this.ddd = ddd;
        this.uf = uf;
    }

}