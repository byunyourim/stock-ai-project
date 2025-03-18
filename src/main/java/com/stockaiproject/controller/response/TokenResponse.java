package com.stockaiproject.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenResponse {

    private String token;
    private String expire_in;
    private String scope;
    private String token_type;
}
