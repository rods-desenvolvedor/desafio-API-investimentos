package com.rods.investimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rods.investimentos.entity.Investidor;

public interface InvestidorRepository extends JpaRepository<Investidor, Long>{
    
}
