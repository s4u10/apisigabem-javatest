package com.s4u10.calculofrete.apisigabem.dto;
/**
 *
 *  @author s4u10
 *
 **/

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreteResponse {

        private String cepOrigem;
        private String cepDestino;
        private Double vlrTotalFrete;
        private String dataPrevistaEntrega;

public FreteResponse(Double vlrTotalFrete, String dataPrevistaEntrega, String cepOrigem, String cepDestino) {
        this.vlrTotalFrete = vlrTotalFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        }

public FreteResponse() {

        }


}