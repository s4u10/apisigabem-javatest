package com.s4u10.calculofrete.apisigabem.service.Impl;


/**
 *  @author s4u10
 *  @since 6/01/2022
 **/

import com.s4u10.calculofrete.apisigabem.model.Frete;
import com.s4u10.calculofrete.apisigabem.repository.FreteRepository;
import com.s4u10.calculofrete.apisigabem.service.FreteService;
import com.s4u10.calculofrete.apisigabem.service.ViaCepClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FreteServiceImpl extends FreteService {
    @Autowired
    private FreteRepository freteRepository;

    public FreteServiceImpl(FreteRepository freteRepository, ViaCepClient viaCepClient) {
        super(freteRepository, viaCepClient);
    }

    @Override
    public Iterable<Frete> buscarTodos(){
        return freteRepository.findAll();
    }

    @Override
    public Frete buscarPorId(Long id){
     Optional<Frete> frete = freteRepository.findById(id);
        return frete.get();
    }

}
