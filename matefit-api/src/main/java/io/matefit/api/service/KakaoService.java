package io.matefit.api.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface KakaoService {

    JsonNode getInfo(String accessToken);
}
