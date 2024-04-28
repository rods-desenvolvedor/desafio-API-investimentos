package com.rods.investimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rods.investimentos.entity.Investimento;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long>{
    
}
