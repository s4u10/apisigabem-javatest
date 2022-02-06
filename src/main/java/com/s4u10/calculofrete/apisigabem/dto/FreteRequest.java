package com.s4u10.calculofrete.apisigabem.dto;
/**
 *
 *  @author s4u10
 *
 **/

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class FreteRequest {

        @NotEmpty(message = "Todos os compos são obrigatorios")
        private String nomeDestinatario;
        @NotEmpty(message = "Preencha o campo")
        @Size(min = 8, max = 8, message = "CEP deve ter 8 dígitos")
        private String cepOrigem;
        @NotEmpty(message = "Preencha o campo")
        @Size(min = 8, max = 8, message = "CEP deve ter 8 dígitos")
        private String cepDestino;
        @NotNull
        private Double peso;

public FreteRequest() {
        }

public FreteRequest(String nomeDestinatario, String cepOrigem, String cepDestino, Double peso) {
        this.nomeDestinatario = nomeDestinatario;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.peso = peso;
        }


}
