package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ItemTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        Item item = new Item();
        item.setTitle("Produto Teste");
        item.setUnitPrice("150.00");
        item.setQuantity(2);
        item.setUnitMeasure("unidade");
        item.setExternalCode("EXT-001");

        ExternalCategory category = new ExternalCategory();
        category.setId("1");

        item.setExternalCategories(List.of(category));

        assertEquals("Produto Teste", item.getTitle());
        assertEquals("150.00", item.getUnitPrice());
        assertEquals(2, item.getQuantity());
        assertEquals("unidade", item.getUnitMeasure());
        assertEquals("EXT-001", item.getExternalCode());
        assertEquals(1, item.getExternalCategories().size());
        assertEquals("1", item.getExternalCategories().getFirst().getId());
    }

    @Test
    void testJacksonSerialization() throws Exception {
        Item item = new Item();
        item.setTitle("Produto JSON");
        item.setUnitPrice("299.99");
        item.setQuantity(5);
        item.setUnitMeasure("unidade");
        item.setExternalCode("EXT-999");

        ExternalCategory category = new ExternalCategory();
        category.setId("1");
        item.setExternalCategories(List.of(category));

        String json = objectMapper.writeValueAsString(item);

        assertTrue(json.contains("\"title\":\"Produto JSON\""));
        assertTrue(json.contains("\"unit_price\":\"299.99\""));
        assertTrue(json.contains("\"quantity\":5"));
        assertTrue(json.contains("\"unit_measure\":\"unidade\""));
        assertTrue(json.contains("\"external_code\":\"EXT-999\""));
        assertTrue(json.contains("\"external_categories\""));
    }

    @Test
    void testJacksonDeserialization() throws Exception {
        String json = """
                {
                  "title": "Produto X",
                  "unit_price": "100.00",
                  "quantity": 3,
                  "unit_measure": "kg",
                  "external_code": "EXT-777",
                  "external_categories": [
                    { "id": "1" }
                  ]
                }
                """;

        Item item = objectMapper.readValue(json, Item.class);

        assertEquals("Produto X", item.getTitle());
        assertEquals("100.00", item.getUnitPrice());
        assertEquals(3, item.getQuantity());
        assertEquals("kg", item.getUnitMeasure());
        assertEquals("EXT-777", item.getExternalCode());
        assertEquals(1, item.getExternalCategories().size());
        assertEquals("1", item.getExternalCategories().getFirst().getId());
    }
}
