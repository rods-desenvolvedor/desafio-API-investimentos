package com.rods.investimentos.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
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

        if(investimento.getDataInvestimento() == null){
            investimento.setDataInvestimento(LocalDate.now());
        }

        investimentoRepository.save(investimento);
        
        investidor.getInvestimentos().add(investimento);

        investidor = investidorRepository.save(investidor);

        return investimentoRepository.save(investimento);
    }



    public BigDecimal calcularValorSaque(Long id){

        Investimento investimento = investimentoRepository.findById(id).orElseThrow();

        BigDecimal valorSaque = new BigDecimal(0);

        BigDecimal ganho = new BigDecimal(0);

        BigDecimal valorInvestimentoInicial = investimento.getValorInvestimento();

        Period period = Period.between(investimento.getDataInvestimento(),LocalDate.now());

        int mesesPassados = period.getYears() * 12 + period.getMonths();

        ganho = valorInvestimentoInicial.multiply(new BigDecimal(mesesPassados)).multiply(new BigDecimal(0.052));

        ganho = aplicarImpostos(ganho, mesesPassados);

        valorSaque = valorInvestimentoInicial.add(ganho);

        return valorSaque;
    }

    public BigDecimal aplicarImpostos(BigDecimal ganho, int mesesPassados){

        if(mesesPassados <= 12){
            BigDecimal perdas = ganho.multiply(new BigDecimal(0.225));
            ganho = ganho.subtract(perdas);
        }
        if(mesesPassados > 12 || mesesPassados < 24){
            BigDecimal perdas = ganho.multiply(new BigDecimal(0.185));
            ganho = ganho.subtract(perdas);
        }
        if(mesesPassados > 24){
            BigDecimal perdas = ganho.multiply(new BigDecimal(0.15));
            ganho = ganho.subtract(perdas);
            
        }

        return ganho;
    }
}
