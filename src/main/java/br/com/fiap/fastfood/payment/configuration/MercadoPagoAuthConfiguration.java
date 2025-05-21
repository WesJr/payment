package br.com.fiap.fastfood.payment.configuration;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MercadoPagoAuthConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "Bearer TEST-865844660348055-051618-542011f7120c3ba7b944dc63b2beaf2c-161940350");

        };
    }
}
