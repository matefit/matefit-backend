package io.matefit.api.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface KakaoService {

    JsonNode getToken(String code);

    JsonNode getInfo(String accessToken);
}
