package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionsTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        PaymentsItem payment1 = new PaymentsItem();
        payment1.setId("PAY-001");
        payment1.setAmount("100.00");

        PaymentsItem payment2 = new PaymentsItem();
        payment2.setId("PAY-002");
        payment2.setAmount("200.00");

        Transactions transactions = new Transactions();
        transactions.setPayments(List.of(payment1, payment2));

        assertEquals(2, transactions.getPayments().size());
        assertEquals("PAY-001", transactions.getPayments().get(0).getId());
        assertEquals("200.00", transactions.getPayments().get(1).getAmount());
    }

    @Test
    void testJacksonSerialization() throws Exception {
        PaymentsItem payment = new PaymentsItem();
        payment.setId("PAY-999");
        payment.setAmount("500.00");

        Transactions transactions = new Transactions();
        transactions.setPayments(List.of(payment));

        String json = objectMapper.writeValueAsString(transactions);

        assertTrue(json.contains("\"payments\""));
        assertTrue(json.contains("\"id\":\"PAY-999\""));
        assertTrue(json.contains("\"amount\":\"500.00\""));
    }

    @Test
    void testJacksonDeserialization() throws Exception {
        String json = """
                {
                  "payments": [
                    {
                      "id": "PAY-777",
                      "amount": "350.00"
                    }
                  ]
                }
                """;

        Transactions transactions = objectMapper.readValue(json, Transactions.class);

        assertNotNull(transactions.getPayments());
        assertEquals(1, transactions.getPayments().size());
        assertEquals("PAY-777", transactions.getPayments().get(0).getId());
        assertEquals("350.00", transactions.getPayments().get(0).getAmount());
    }
}
