package com.santos.porto.controller;

import com.santos.porto.controller.DTO.DadosAgendamentoVisita;
import com.santos.porto.controller.DTO.DadosDetalhamentoVisita;
import com.santos.porto.domain.visita.AgendaDeVisitas;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class VisitaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosAgendamentoVisita> dadosAgendamentoVisitaJson;

    @Autowired
    private JacksonTester<DadosDetalhamentoVisita> dadosDetalhamentoVisitaJson;

    @MockBean
    private AgendaDeVisitas agendaDeVisitas;



    @Test
    @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
    @WithMockUser
    void agendar_cenario1() throws Exception {
        var response = mvc.perform(post("/visitas"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void agendar_cenario2() throws Exception {
        var data = LocalDateTime.now().plusHours(1);

        var dadosDetalhamento = new DadosDetalhamentoVisita(null, 2l, 5l, data);

        when(agendaDeVisitas.agendar(any())).thenReturn(dadosDetalhamento);

        var response = mvc.perform(post("/visitas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosAgendamentoVisitaJson.write(
                                new DadosAgendamentoVisita(2l, 5l, data)
                        ).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

        var jsonEsperado = dadosDetalhamentoVisitaJson.write(
                dadosDetalhamento
        ).getJson();

        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }
}