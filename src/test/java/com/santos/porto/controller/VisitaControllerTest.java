package com.santos.porto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VisitaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Deveria devolver codigo http 500 quando informacoes estao invalidas")
    @WithMockUser
    void agendar_cenario1() throws Exception {
        var jsonInvalido = "{ \"campoInvalido\": \"valorInvalido\" }";

        var response = mvc.perform(post("/visitas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInvalido))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}