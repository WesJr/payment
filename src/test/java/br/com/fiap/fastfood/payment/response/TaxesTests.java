package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TaxesTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        Taxes taxes = new Taxes();
        taxes.setPayerCondition("responsible");

        assertEquals("responsible", taxes.getPayerCondition());
    }

    @Test
    void testJacksonSerialization() throws Exception {
        Taxes taxes = new Taxes();
        taxes.setPayerCondition("registered");

        String json = objectMapper.writeValueAsString(taxes);

        assertTrue(json.contains("\"payer_condition\":\"registered\""));
    }

    @Test
    void testJacksonDeserialization() throws Exception {
        String json = "{ \"payer_condition\": \"final\" }";

        Taxes taxes = objectMapper.readValue(json, Taxes.class);

        assertEquals("final", taxes.getPayerCondition());
    }

}
