package com.rods.investimentos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rods.investimentos.entity.Investidor;
import com.rods.investimentos.service.InvestidorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController()
@RequestMapping("/investidores")
@Tag(name = "API investimentos")
public class InvestidorController {

    private InvestidorService investidorService;

    public InvestidorController(InvestidorService investidorService){
        this.investidorService = investidorService;
    }

    @Operation(summary = "Realiza o cadastro de um novo investidor", method = "POST")
    @ApiResponse(responseCode = "200", description = "Novo investidor cadastrado com sucesso!!")
    @PostMapping("/cadastrar")
    private Investidor cadastrarInvestidor(@RequestBody Investidor investidor){
        return investidorService.cadastrarInvestidor(investidor);
    }
    @Operation(summary = "Lista todos os investidores cadastrados", method = "GET")
    @GetMapping("/listar")
    private List<Investidor> listarInvestidores(){
        return  investidorService.listarInvestidores();
    }

    @Operation(summary = "Realiza a busca de um investidor a partir de seu ID unico", method = "GET")
    @GetMapping("/{id}/listar")
    private Investidor listarInvestimentos(@PathVariable Long id){
        return investidorService.listarInvestimentos(id);
    }
    
}
