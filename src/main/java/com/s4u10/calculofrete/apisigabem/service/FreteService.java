package com.s4u10.calculofrete.apisigabem.service;
/**
 *
 *  @author s4u10
 *  @since 6/01/2022
 **/

import com.s4u10.calculofrete.apisigabem.dto.FreteRequest;
import com.s4u10.calculofrete.apisigabem.dto.FreteResponse;
import com.s4u10.calculofrete.apisigabem.enums.DescontoTipo;
import com.s4u10.calculofrete.apisigabem.enums.PrazoTipo;
import com.s4u10.calculofrete.apisigabem.exceptions.CepNaoEncontradoException;
import com.s4u10.calculofrete.apisigabem.model.Endereco;
import com.s4u10.calculofrete.apisigabem.model.Frete;
import com.s4u10.calculofrete.apisigabem.repository.FreteRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Data
@Service
@RequiredArgsConstructor
public abstract class FreteService {
    private final FreteRepository freteRepository;
    private final ViaCepClient viaCepClient;

    public FreteResponse calculaFrete(FreteRequest freteRequest) throws CepNaoEncontradoException {
        Endereco buscaEnderecoOrigem = viaCepClient
                .buscaEnderecoOrigem(freteRequest);
        Endereco buscaEnderecoDestino = viaCepClient
                .buscaEnderecoDestino(freteRequest);

        double precoTotal;
        Calendar dataEntrega = new GregorianCalendar();
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd-MM-yyyy");

        if (buscaEnderecoOrigem.getCep() == null)
            throw new CepNaoEncontradoException
                    (HttpStatus.BAD_REQUEST, " - CEP " + freteRequest.getCepOrigem() + " não existe");
                else if (buscaEnderecoDestino.getCep() == null)
                    throw new CepNaoEncontradoException(HttpStatus.BAD_REQUEST, " - CEP " + freteRequest.getCepDestino() + " não existe");
                else if (Objects.equals(buscaEnderecoOrigem.getDdd(), buscaEnderecoDestino.getDdd())) {
                        precoTotal = (freteRequest.getPeso()) - ((freteRequest.getPeso() * DescontoTipo.MESMO_DDD.getDesconto()));

                        // Regra para DF e GO com mesmo DDD
                        dataEntrega.add(Calendar.DAY_OF_MONTH, PrazoTipo.MESMO_DDD.getPrazo());
                        } else if (Objects.equals(buscaEnderecoOrigem.getUf(), buscaEnderecoDestino.getUf())) {
                                    precoTotal = (freteRequest.getPeso()) - ((freteRequest.getPeso() * DescontoTipo.MESMA_UF.getDesconto()));
                                    dataEntrega.add(Calendar.DAY_OF_MONTH, PrazoTipo.MESMA_UF.getPrazo());
                            } else
                                    precoTotal = (freteRequest.getPeso()) - ((freteRequest.getPeso() * DescontoTipo.UF_DIFERENTE.getDesconto()));
                                    dataEntrega.add(Calendar.DAY_OF_MONTH, PrazoTipo.UF_DIFERENTE.getPrazo());

                        FreteResponse freteResponse = new FreteResponse();
                        freteResponse.setDataPrevistaEntrega(dataFormatada.format(dataEntrega.getTime()));
                        freteResponse.setVlrTotalFrete(precoTotal);
                        freteResponse.setCepDestino(freteRequest.getCepDestino());
                        freteResponse.setCepOrigem(freteRequest.getCepOrigem());

                        Date date = new Date();
                        Frete frete = new Frete();
                        frete.setNomeDestinatario(freteRequest.getNomeDestinatario());
                        frete.setPeso(freteRequest.getPeso());
                        frete.setCepOrigem(freteRequest.getCepOrigem());
                        frete.setCepDestino(freteRequest.getCepDestino());
                        frete.setVlrTotalFrete(freteResponse.getVlrTotalFrete());
                        frete.setDataPrevistaEntrega(freteResponse.getDataPrevistaEntrega());
                        frete.setDataConsulta(dataFormatada.format(date));

        freteRepository.save(frete);
        return freteResponse;
    }

    public abstract Iterable<Frete> buscarTodos();

    public abstract Frete buscarPorId(Long id);
}
