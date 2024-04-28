package com.rods.investimentos.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rods.investimentos.entity.Investidor;
import com.rods.investimentos.entity.Investimento;
import com.rods.investimentos.repository.InvestidorRepository;
import com.rods.investimentos.repository.InvestimentoRepository;

@Service
public class InvestimentoService {

    private InvestimentoRepository investimentoRepository;
    private InvestidorRepository investidorRepository;

    public InvestimentoService(InvestimentoRepository investimentoRepository, InvestidorRepository investidorRepository){
        this.investimentoRepository = investimentoRepository;
        this.investidorRepository = investidorRepository;
    }

    public Investimento cadastrarInvestimento(Long id, Investimento investimento){

        Investidor investidor = investidorRepository.findById(id).orElseThrow();

        investimento.setDataInvestimento(LocalDate.now());

        investimentoRepository.save(investimento);
        
        investidor.getInvestimentos().add(investimento);

        investidor = investidorRepository.save(investidor);

        return investimentoRepository.save(investimento);
    }
}
