package com.stockaiproject.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.stockaiproject.controller.response.StockResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Slf4j
@Service
@AllArgsConstructor
public class AuthService {

    private final WebClient webClient;

    public String generateToken(String serviceKey) {

        String url = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo?serviceKey=" + serviceKey;

        try {
            String responseData =  webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();

            if (responseData == null) {
                log.error("데이터를 가져오는 데 실패했습니다.");
                throw new RuntimeException("데이터를 가져오는 데 실패했습니다.");

            } else {
                return responseData;
            }

        } catch (Exception e){
            throw new IllegalArgumentException("API 호출 예외 ===> {}", e);
        }
    }



}
