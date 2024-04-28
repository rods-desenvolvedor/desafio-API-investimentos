package com.rods.investimentos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rods.investimentos.entity.Investidor;
import com.rods.investimentos.entity.Investimento;
import com.rods.investimentos.repository.InvestidorRepository;

@Service
public class InvestidorService {

    private InvestidorRepository investidorRepository;

    public InvestidorService(InvestidorRepository investidorRepository){
        this.investidorRepository = investidorRepository;
    }

    public Investidor cadastrarInvestidor(Investidor investidor){
        return investidorRepository.save(investidor);
    }

    public List<Investidor> listarInvestidores(){
        return investidorRepository.findAll();
    }

    public Investidor listarInvestimentos(Long id){
        return investidorRepository.findById(id).orElseThrow();
    }
    
}
