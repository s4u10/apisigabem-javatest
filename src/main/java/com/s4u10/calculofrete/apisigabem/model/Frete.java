package com.s4u10.calculofrete.apisigabem.model;
/**
 *
 *  @author s4u10
 *  @since 6/01/2022
 **/

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name= "frete")
public class Frete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nomeDestinatario;
    @Column
    private Double peso;
    @Column(length = 8)
    private String cepOrigem;
    @Column(length = 8)
    private String cepDestino;
    private Double vlrTotalFrete;
    private String dataPrevistaEntrega;
    private String dataConsulta;

    public Frete(Long id, String nomeDestinatario, Double peso, String cepOrigem, String cepDestino,
                 Double vlrTotalFrete, String dataPrevistaEntrega, String dataConsulta) {
        this.id = id;
        this.nomeDestinatario = nomeDestinatario;
        this.peso = peso;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.vlrTotalFrete = vlrTotalFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.dataConsulta = dataConsulta;
    }

    public Frete() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Frete frete = (Frete) o;
        return Objects.equals(id, frete.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
