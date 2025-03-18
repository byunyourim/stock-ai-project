package com.stockaiproject.controller;

import com.stockaiproject.controller.request.StockRequest;
import com.stockaiproject.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stock")
@AllArgsConstructor
public class StockController {

    private StockService stockService;

    @PostMapping("/kr")
    public String getStockList(@RequestBody StockRequest request) {

        return stockService.getStockData(request);
    }


}
