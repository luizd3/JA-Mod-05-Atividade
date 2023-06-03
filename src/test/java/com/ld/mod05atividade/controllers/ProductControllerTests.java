package com.ld.mod05atividade.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldListAllProducts() throws Exception {

        Pattern UUDI_REGEX =
                Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

        // Requisição para testar se o status HTTP é 200 (OK) e se lista corretamente os produtos cadastrados
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/products").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", matchesPattern(UUDI_REGEX)))
                .andExpect(jsonPath("$[0].nome").value("Air Fryer"))
                .andExpect(jsonPath("$[0].valor").value(450.0))
                .andExpect(jsonPath("$[0].descontoMaximo").value(0.15))
                .andExpect(jsonPath("$[0].quantidade").value(18))
                .andExpect(jsonPath("$[1].nome").value("Liquidificador"))
                .andExpect(jsonPath("$[2].valor").value(2489.90))
                .andExpect(jsonPath("$[3].descontoMaximo").value(0.07))
                .andExpect(jsonPath("$[4].quantidade").value(15))
                .andReturn();

    }
}
