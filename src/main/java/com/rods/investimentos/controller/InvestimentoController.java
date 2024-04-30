package com.rods.investimentos.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rods.investimentos.entity.Investimento;
import com.rods.investimentos.service.InvestimentoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/investimentos")
@Tag(name = "API investimentos")
public class InvestimentoController {

    private InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService){
        this.investimentoService = investimentoService;
    }

    @Operation(summary = "Realiza um novo investimento para um investidor existente.", method = "POST")
    @PostMapping("/cadastrar/{id}")
    private Investimento cadastrarInvestimento(@PathVariable Long id, @RequestBody Investimento investimento){
        return investimentoService.cadastrarInvestimento(id, investimento);
    }

    @Operation(summary = "Realiza o saque de um investimento, aplicando os ganhos e os impostos.", method = "POST")
    @GetMapping("/sacar/{id}")
    private BigDecimal sacarInvestimento(@PathVariable Long id){
        return investimentoService.calcularValorSaque(id);
    }
    
}
