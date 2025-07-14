package br.com.fiap.fastfood.payment.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CashOutRequestTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        CashOutRequest cashOut = new CashOutRequest();
        cashOut.setAmount(new BigDecimal("123.45"));

        assertEquals(new BigDecimal("123.45"), cashOut.getAmount());
    }

    @Test
    void testJacksonSerialization() throws Exception {
        CashOutRequest cashOut = new CashOutRequest();
        cashOut.setAmount(new BigDecimal("500.00"));

        String json = objectMapper.writeValueAsString(cashOut);
        assertTrue(json.contains("\"amount\":500.00"));
    }

    @Test
    void testJacksonDeserialization() throws Exception {
        String json = "{ \"amount\": 250.75 }";

        CashOutRequest cashOut = objectMapper.readValue(json, CashOutRequest.class);

        assertEquals(new BigDecimal("250.75"), cashOut.getAmount());
    }

}
