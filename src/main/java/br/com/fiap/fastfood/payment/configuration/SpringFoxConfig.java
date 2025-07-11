package br.com.fiap.fastfood.payment.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFoxConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pagamentos Mercado Pago")
                        .version("1.0")
                        .description("API de pagamento com geração de QRCode pelo mercado pago")
                        .contact(new Contact()
                                .name("Wesley Junior De Souza")
                                .email("wesjuniorsouza@gmail.com")));
    }
}
