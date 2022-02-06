package com.s4u10.calculofrete.apisigabem.service;
/**
 *  HTTP client, to consume the API of the
 * <b>ViaCEP</b>.
 *
 * @see  <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author s4u10
 **/

import com.s4u10.calculofrete.apisigabem.dto.FreteRequest;
import com.s4u10.calculofrete.apisigabem.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ViaCepClient {

    public Endereco buscaEnderecoOrigem(FreteRequest freteRequest) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject("https://viacep.com.br/ws/" +
                        freteRequest.getCepOrigem() + "/json", Endereco.class);

    }

    public Endereco buscaEnderecoDestino(FreteRequest freteRequest) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate
                .getForObject("https://viacep.com.br/ws/" +
                        freteRequest.getCepDestino() + "/json", Endereco.class);

    }
}