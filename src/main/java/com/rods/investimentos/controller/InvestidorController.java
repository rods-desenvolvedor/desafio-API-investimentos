package com.rods.investimentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rods.investimentos.entity.Investidor;
import com.rods.investimentos.service.InvestidorService;

@RestController()
@RequestMapping("/investidores")
public class InvestidorController {

    private InvestidorService investidorService;

    public InvestidorController(InvestidorService investidorService){
        this.investidorService = investidorService;
    }

    @PostMapping("/cadastrar")
    private Investidor cadastrarInvestidor(Investidor investidor){
        return investidorService.cadastrarInvestidor(investidor);
    }

    @GetMapping("/listar")
    private List<Investidor> listarInvestidores(){
        return  investidorService.listarInvestidores();
    }
    
}
