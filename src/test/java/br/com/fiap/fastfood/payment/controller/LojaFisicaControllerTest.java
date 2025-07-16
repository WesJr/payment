package br.com.fiap.fastfood.payment.controller;

import br.com.fiap.fastfood.payment.request.BusinessHours;
import br.com.fiap.fastfood.payment.request.LocationRequest;
import br.com.fiap.fastfood.payment.request.LojaRequest;
import br.com.fiap.fastfood.payment.request.TimeRange;
import br.com.fiap.fastfood.payment.response.LocationResponse;
import br.com.fiap.fastfood.payment.response.LojaResponse;
import br.com.fiap.fastfood.payment.response.LojaResponsePaginada;
import br.com.fiap.fastfood.payment.service.LojaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LojaFisicaController.class)
class LojaFisicaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LojaService lojaService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testCriarLoja() throws Exception {
        LojaRequest lojaRequest = createSampleLojaRequest();

        LojaResponse lojaResponse = createSampleLojaResponse();

        Mockito.when(lojaService.criarLoja(eq("user123"), any(LojaRequest.class)))
                .thenReturn(lojaResponse);

        mockMvc.perform(post("/loja/users/user123/stores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(lojaRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Minha Loja"))
                .andExpect(jsonPath("$.date_creation").value("2023-10-01"))
                .andExpect(jsonPath("$.external_id").value("ext-abc-123"));
    }


    @Test
    void testBuscarLojas() throws Exception {
        LojaResponsePaginada paginada = new LojaResponsePaginada();
        // preencher campos da resposta se necessário

        Mockito.when(lojaService.buscarLojas("user123", "ext-abc-123")).thenReturn(paginada);

        mockMvc.perform(get("/loja/users/user123/store/search")
                        .param("external_id", "ext-abc-123"))
                .andExpect(status().isOk());
    }

    @Test
    void testObterLoja() throws Exception {
        LojaResponse lojaResponse = createSampleLojaResponse();

        Mockito.when(lojaService.obterLoja("loja123")).thenReturn(lojaResponse);

        mockMvc.perform(get("/loja/users/store/loja123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Minha Loja"));
    }

    private LojaResponse createSampleLojaResponse() {
        LojaResponse response = new LojaResponse();
        response.setId(1L);
        response.setName("Minha Loja");
        response.setDateCreated("2023-10-01");
        response.setExternalId("ext-abc-123");

        BusinessHours businessHours = new BusinessHours();
        TimeRange abertura = new TimeRange();
        TimeRange fechamento = new TimeRange();
        abertura.setOpen("09:00");
        fechamento.setClose("18:00");
        List<TimeRange> horarios = new ArrayList<>();
        horarios.add(abertura);
        horarios.add(fechamento);

        businessHours.setMonday(horarios);
        response.setBusinessHours(businessHours);

        LocationResponse location = new LocationResponse();
        location.setAddressLine("São Paulo");
        location.setReference("SP");
        response.setLocation(location);

        return response;
    }

    private LojaRequest createSampleLojaRequest() {
        LojaRequest request = new LojaRequest();
        request.setName("Loja Central");
        request.setExternalId("loja-ext-001");

        LocationRequest location = new LocationRequest();
        location.setCityName("São Paulo");
        location.setReference("SP");
        request.setLocation(location);

        return request;
    }

}
