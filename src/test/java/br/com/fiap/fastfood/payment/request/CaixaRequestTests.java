package br.com.fiap.fastfood.payment.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaixaRequestTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        CaixaRequest caixa = new CaixaRequest();

        caixa.setName("Caixa 1");
        caixa.setFixedAmout(true);
        caixa.setStoreId(123L);
        caixa.setExternalStoreId("EXT-STORE-01");
        caixa.setExternalId("EXT-ID-01");
        caixa.setCategory(5);

        assertEquals("Caixa 1", caixa.getName());
        assertTrue(caixa.isFixedAmout());
        assertEquals(123L, caixa.getStoreId());
        assertEquals("EXT-STORE-01", caixa.getExternalStoreId());
        assertEquals("EXT-ID-01", caixa.getExternalId());
        assertEquals(5, caixa.getCategory());
    }

    @Test
    void testAllArgsConstructor() {
        CaixaRequest caixa = new CaixaRequest("Caixa 2", false, 456L, "EXT-STORE-02", "EXT-ID-02", 10);

        assertEquals("Caixa 2", caixa.getName());
        assertFalse(caixa.isFixedAmout());
        assertEquals(456L, caixa.getStoreId());
        assertEquals("EXT-STORE-02", caixa.getExternalStoreId());
        assertEquals("EXT-ID-02", caixa.getExternalId());
        assertEquals(10, caixa.getCategory());
    }

    @Test
    void testToString() {
        CaixaRequest caixa = new CaixaRequest("Caixa X", true, 999L, "STORE-X", "ID-X", 1);
        String output = caixa.toString();
        assertTrue(output.contains("Caixa X"));
        assertTrue(output.contains("true"));
        assertTrue(output.contains("999"));
    }

    @Test
    void testJacksonSerialization() throws Exception {
        CaixaRequest caixa = new CaixaRequest("Caixa JSON", true, 555L, "STORE-JSON", "ID-JSON", 7);

        String json = objectMapper.writeValueAsString(caixa);
        assertTrue(json.contains("\"name\":\"Caixa JSON\""));
        assertTrue(json.contains("\"fixed_amount\":true"));
        assertTrue(json.contains("\"store_id\":555"));
        assertTrue(json.contains("\"external_store_id\":\"STORE-JSON\""));
        assertTrue(json.contains("\"external_id\":\"ID-JSON\""));
        assertTrue(json.contains("\"category\":7"));
    }

    @Test
    void testJacksonDeserialization() throws Exception {
        CaixaRequest expected = new CaixaRequest(
                "Caixa JSON", true, 777L, "STORE-777", "ID-777", 3
        );

        String json = objectMapper.writeValueAsString(expected);

        CaixaRequest result = objectMapper.readValue(json, CaixaRequest.class);

        assertAll(
                () -> assertEquals(expected.getName(), result.getName()),
                () -> assertEquals(expected.isFixedAmout(), result.isFixedAmout()),
                () -> assertEquals(expected.getStoreId(), result.getStoreId()),
                () -> assertEquals(expected.getExternalStoreId(), result.getExternalStoreId()),
                () -> assertEquals(expected.getExternalId(), result.getExternalId()),
                () -> assertEquals(expected.getCategory(), result.getCategory())
        );
    }
}
