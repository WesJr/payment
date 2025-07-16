package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class LocationResponseTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        LocationResponse location = new LocationResponse();
        location.setAddressLine("Rua Central, 123");
        location.setReference("Próximo ao Shopping");
        location.setLatitude(-23.5505);
        location.setLongitude(-46.6333);

        assertEquals("Rua Central, 123", location.getAddressLine());
        assertEquals("Próximo ao Shopping", location.getReference());
        assertEquals(-23.5505, location.getLatitude());
        assertEquals(-46.6333, location.getLongitude());
    }

    @Test
    void testJacksonSerialization() throws Exception {
        LocationResponse location = new LocationResponse();
        location.setAddressLine("Avenida Brasil");
        location.setReference("Em frente ao Banco");
        location.setLatitude(-22.9068);
        location.setLongitude(-43.1729);

        String json = objectMapper.writeValueAsString(location);

        assertTrue(json.contains("\"address_line\":\"Avenida Brasil\""));
        assertTrue(json.contains("\"reference\":\"Em frente ao Banco\""));
        assertTrue(json.contains("\"latitude\":-22.9068"));
        assertTrue(json.contains("\"longitude\":-43.1729"));
    }

    @Test
    void testJacksonDeserialization() throws Exception {
        String json = """
                {
                  "address_line": "Rua das Flores, 45",
                  "reference": "Perto da praça",
                  "latitude": -15.7801,
                  "longitude": -47.9292
                }
                """;

        LocationResponse location = objectMapper.readValue(json, LocationResponse.class);

        assertEquals("Rua das Flores, 45", location.getAddressLine());
        assertEquals("Perto da praça", location.getReference());
        assertEquals(-15.7801, location.getLatitude());
        assertEquals(-47.9292, location.getLongitude());
    }
}
