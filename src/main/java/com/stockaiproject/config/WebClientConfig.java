package com.stockaiproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilderFactory;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient WebClient() {
        UriBuilderFactory factory = new DefaultUriBuilderFactory();
        ((DefaultUriBuilderFactory) factory).setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

        return WebClient.builder()
            .uriBuilderFactory(factory)
            .build();
    }


}
