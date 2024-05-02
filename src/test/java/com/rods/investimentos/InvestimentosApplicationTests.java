package com.rods.investimentos;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.rods.investimentos.entity.Investidor;
import com.rods.investimentos.repository.InvestidorRepository;
import com.rods.investimentos.service.InvestidorService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@OpenAPIDefinition(info = @Info(title = "API de investimentos", version = "1.0", description = "API desenvolvida para praticar desafios de vagas backend"))
class InvestimentosApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testeCadastrarInvestidor() {

     
        Investidor investidor = new Investidor("Rods");

        webTestClient.post().uri("/investidores/cadastrar").bodyValue(investidor).exchange().expectStatus().isOk()
        .expectBody()
        .jsonPath("$.nome").isEqualTo(investidor.getNome());


    }

}
