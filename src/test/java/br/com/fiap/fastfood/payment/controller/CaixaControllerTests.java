package br.com.fiap.fastfood.payment.controller;

import br.com.fiap.fastfood.payment.request.CaixaRequest;
import br.com.fiap.fastfood.payment.response.CaixaResponse;
import br.com.fiap.fastfood.payment.response.QrResponse;
import br.com.fiap.fastfood.payment.service.CaixaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CaixaController.class)
class CaixaControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private CaixaService caixaService;

    @Test
    void deveCriarCaixa() throws Exception {
        CaixaRequest request = new CaixaRequest(
                "Caixa Teste", true, 1L, "EXT_STORE", "EXT_123", 5
        );

        QrResponse qrResponse = new QrResponse(
                "IMAGE_URL",
                "TEMPLATE_DOC_URL",
                "TEMPLATE_IMAGE_URL"
        );

        CaixaResponse response = new CaixaResponse(
                1L, qrResponse, "ACTIVE", "2025-07-12", "2025-07-12",
                "uuid-abc", 999L, "Caixa Teste", true, 5,
                "STORE001", "EXT_STORE", "EXT_123", "BR", "QR_CODE_STRING"
        );

        when(caixaService.createCaixa(any(CaixaRequest.class))).thenReturn(response);

        mockMvc.perform(post("/caixa/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.qr.image").value("IMAGE_URL"))
                .andExpect(jsonPath("$.qr.template_document").value("TEMPLATE_DOC_URL"))
                .andExpect(jsonPath("$.qr.template_image").value("TEMPLATE_IMAGE_URL"))
                .andExpect(jsonPath("$.status").value("ACTIVE"))
                .andExpect(jsonPath("$.uuid").value("uuid-abc"))
                .andExpect(jsonPath("$.user_id").value(999))
                .andExpect(jsonPath("$.name").value("Caixa Teste"))
                .andExpect(jsonPath("$.fixed_amount").value(true))
                .andExpect(jsonPath("$.category").value(5))
                .andExpect(jsonPath("$.store_id").value("STORE001"))
                .andExpect(jsonPath("$.external_store_id").value("EXT_STORE"))
                .andExpect(jsonPath("$.external_id").value("EXT_123"))
                .andExpect(jsonPath("$.site").value("BR"))
                .andExpect(jsonPath("$.qr_code").value("QR_CODE_STRING"));
    }

    @Test
    void deveBuscarCaixaPorId() throws Exception {
        String caixaId = "1";

        QrResponse qrResponse = new QrResponse(
                "IMAGE_URL",
                "TEMPLATE_DOC_URL",
                "TEMPLATE_IMAGE_URL"
        );

        CaixaResponse response = new CaixaResponse(
                1L, qrResponse, "ACTIVE", "2025-07-12", "2025-07-12",
                "uuid-abc", 999L, "Caixa Teste", true, 5,
                "STORE001", "EXT_STORE", "EXT_123", "BR", "QR_CODE_STRING"
        );

        when(caixaService.getCaixaById(caixaId)).thenReturn(response);

        mockMvc.perform(get("/caixa/{caixa-id}", caixaId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.qr.image").value("IMAGE_URL"))
                .andExpect(jsonPath("$.qr.template_document").value("TEMPLATE_DOC_URL"))
                .andExpect(jsonPath("$.qr.template_image").value("TEMPLATE_IMAGE_URL"))
                .andExpect(jsonPath("$.status").value("ACTIVE"))
                .andExpect(jsonPath("$.uuid").value("uuid-abc"));
    }
}
