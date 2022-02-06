package com.s4u10.calculofrete.apisigabem.repository;

/**
 *  @author s4u10
 *
 **/

import com.s4u10.calculofrete.apisigabem.model.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {


}
