package com.rods.investimentos.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rods.investimentos.entity.Investimento;
import com.rods.investimentos.service.InvestimentoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    private InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService){
        this.investimentoService = investimentoService;
    }

    @PostMapping("/cadastrar/{id}")
    private Investimento cadastrarInvestimento(@PathVariable Long id, @RequestBody Investimento investimento){
        return investimentoService.cadastrarInvestimento(id, investimento);
    }
    
}
