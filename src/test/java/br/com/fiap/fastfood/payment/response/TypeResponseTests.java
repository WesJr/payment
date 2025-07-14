package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TypeResponseTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        TypeResponse response = new TypeResponse();
        response.setQrData("ABC123");

        assertEquals("ABC123", response.getQrData());
    }

    @Test
    void testJacksonSerialization() throws Exception {
        TypeResponse response = new TypeResponse();
        response.setQrData("XYZ789");

        String json = objectMapper.writeValueAsString(response);
        assertTrue(json.contains("\"qr_data\":\"XYZ789\""));
    }

    @Test
    void testJacksonDeserialization() throws Exception {
        String json = "{ \"qr_data\": \"QR999\" }";

        TypeResponse response = objectMapper.readValue(json, TypeResponse.class);

        assertEquals("QR999", response.getQrData());
    }
}
