package com.s4u10.calculofrete.apisigabem.controller;

/**
 *
 * @author s4u10
 * @since 6/01/2022
 **/

import com.s4u10.calculofrete.apisigabem.dto.FreteRequest;
import com.s4u10.calculofrete.apisigabem.dto.FreteResponse;
import com.s4u10.calculofrete.apisigabem.service.FreteService;
import com.s4u10.calculofrete.apisigabem.service.Impl.FreteServiceImpl;
import com.s4u10.calculofrete.apisigabem.service.ViaCepClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@Api(value = "API Siga Bem - Cálculo de Frete")
public class FreteController {

    @Autowired
    private final ViaCepClient viaCepClient;
    private final FreteService freteService;
    private final FreteServiceImpl freteServiceImpl;


    public FreteController(ViaCepClient viaCepClient, FreteService freteService, FreteServiceImpl freteServiceImpl) {
        this.viaCepClient = viaCepClient;
        this.freteService = freteService;
        this.freteServiceImpl = freteServiceImpl;
    }

    @PostMapping("/inputfrete")
    @ApiOperation(value = "Inserir dados de frete")
    public ResponseEntity<FreteResponse> consultaFrete(@RequestBody FreteRequest freteRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(freteService.calculaFrete(freteRequest));

    }

 //   @GetMapping("/{id}")
 //   @ApiOperation(value = "Faz a consulta de frete Por id")
 //   public ResponseEntity<Frete> buscarPorId(@PathVariable Long id){
 //       return ResponseEntity.ok(freteService.buscarPorId(id));
 //   }

}
