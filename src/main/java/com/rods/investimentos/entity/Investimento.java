package com.rods.investimentos.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "investimentos")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataInvestimento;

    @NotNull
    private BigDecimal valorInvestimento;
    
    @ManyToOne
    @JoinColumn(name = "id_investidor")
    @JsonIgnore
    private Investidor investidor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInvestimento() {
        return dataInvestimento;
    }

    public void setDataInvestimento(LocalDate dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }

    public BigDecimal getValorInvestimento() {
        return valorInvestimento;
    }

    public void setValorInvestimento(BigDecimal valorInvestimento) {
        this.valorInvestimento = valorInvestimento;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    

    
}
