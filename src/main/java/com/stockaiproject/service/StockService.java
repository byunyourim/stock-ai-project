package com.stockaiproject.service;

import com.stockaiproject.controller.request.StockRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class StockService {

    private final WebClient webClient = WebClient.builder().baseUrl("https://openapi.db-fi.com:8443")
        .defaultHeader("Content-Type", "application/json")
        .defaultHeader("cont_yn", "N")
        .build();

    public String getStockData(StockRequest request) {

            return webClient.post()
                .uri("/api/v1/quote/kr-stock/inquiry/stock-ticker")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
