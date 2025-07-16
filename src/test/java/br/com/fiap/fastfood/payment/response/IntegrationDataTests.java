package br.com.fiap.fastfood.payment.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IntegrationDataTests {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        IntegrationData data = new IntegrationData();
        data.setApplicationId("APP-001");
        data.setPlatformId("PLAT-123");
        data.setIntegratorId("INT-456");
        data.setStatus("active");
        data.setStatusDetail("running");
        data.setCreatedDate("2024-01-01");
        data.setLastUpdatedDate("2024-07-01");

        SponsorRequest sponsor = new SponsorRequest();
        sponsor.setId("1");
        data.setSponsor(sponsor);

        assertEquals("APP-001", data.getApplicationId());
        assertEquals("PLAT-123", data.getPlatformId());
        assertEquals("INT-456", data.getIntegratorId());
        assertEquals("active", data.getStatus());
        assertEquals("running", data.getStatusDetail());
        assertEquals("2024-01-01", data.getCreatedDate());
        assertEquals("2024-07-01", data.getLastUpdatedDate());
        assertEquals("1", data.getSponsor().getId());
    }

    @Test
    void testJacksonSerialization() throws Exception {
        IntegrationData data = new IntegrationData();
        data.setApplicationId("APP-999");
        data.setPlatformId("PLAT-XYZ");
        data.setIntegratorId("INT-ABC");
        data.setStatus("inactive");
        data.setStatusDetail("terminated");
        data.setCreatedDate("2023-01-01");
        data.setLastUpdatedDate("2023-12-31");

        SponsorRequest sponsor = new SponsorRequest();
        sponsor.setId("1");
        data.setSponsor(sponsor);

        String json = objectMapper.writeValueAsString(data);

        assertTrue(json.contains("\"application_id\":\"APP-999\""));
        assertTrue(json.contains("\"platform_id\":\"PLAT-XYZ\""));
        assertTrue(json.contains("\"integrator_id\":\"INT-ABC\""));
        assertTrue(json.contains("\"status\":\"inactive\""));
        assertTrue(json.contains("\"status_detail\":\"terminated\""));
        assertTrue(json.contains("\"created_date\":\"2023-01-01\""));
        assertTrue(json.contains("\"last_updated_date\":\"2023-12-31\""));
        assertTrue(json.contains("\"1\""));
    }

    @Test
    void testJacksonDeserialization() throws Exception {
        String json = """
                {
                  "application_id": "APP-777",
                  "platformId": "PLAT-555",
                  "integratorId": "INT-888",
                  "status": "pending",
                  "status_detail": "waiting",
                  "created_date": "2022-02-02",
                  "last_updated_date": "2022-12-12",
                  "sponsor": {
                    "id": "1"
                  }
                }
                """;

        IntegrationData data = objectMapper.readValue(json, IntegrationData.class);

        assertEquals("APP-777", data.getApplicationId());
        assertEquals("PLAT-555", data.getPlatformId());
        assertEquals("INT-888", data.getIntegratorId());
        assertEquals("pending", data.getStatus());
        assertEquals("waiting", data.getStatusDetail());
        assertEquals("2022-02-02", data.getCreatedDate());
        assertEquals("2022-12-12", data.getLastUpdatedDate());
        assertNotNull(data.getSponsor());
        assertEquals("1", data.getSponsor().getId());
    }
}
