package io.matefit.api.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import io.matefit.api.service.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
@RequiredArgsConstructor
@PropertySource("classpath:oauth.properties")
public class KakaoServiceImpl implements KakaoService {

    private final RestTemplate restTemplate;

    @Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    @Override
    public JsonNode getInfo(String accessToken) {
        final URI requestUri = UriComponentsBuilder
                .fromHttpUrl("https://kapi.kakao.com/v2/user/me")
                .build(true)
                .toUri();

        final HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        final HttpEntity entity = new HttpEntity(headers);

        return restTemplate.exchange(requestUri, HttpMethod.GET, entity, JsonNode.class).getBody();
    }
}
