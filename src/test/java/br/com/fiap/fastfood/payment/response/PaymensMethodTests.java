package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PaymensMethodTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        PaymensMethod method = new PaymensMethod();
        method.setNewTotalAmount("100.50");
        method.setType("credit_card");

        assertEquals("100.50", method.getNewTotalAmount());
        assertEquals("credit_card", method.getType());
    }

    @Test
    void testJacksonSerialization() throws Exception {
        PaymensMethod method = new PaymensMethod();
        method.setNewTotalAmount("250.00");
        method.setType("debit");

        String json = objectMapper.writeValueAsString(method);

        assertTrue(json.contains("\"new_total_amount\":\"250.00\""));
        assertTrue(json.contains("\"type\":\"debit\""));
    }

    @Test
    void testJacksonDeserialization() throws Exception {
        String json = """
                {
                  "new_total_amount": "300.75",
                  "type": "pix"
                }
                """;

        PaymensMethod method = objectMapper.readValue(json, PaymensMethod.class);

        assertEquals("300.75", method.getNewTotalAmount());
        assertEquals("pix", method.getType());
    }

}
