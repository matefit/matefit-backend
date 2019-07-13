package io.matefit.core.dto.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;

@Data
public class KakaoInfo {

    private Long id;

    private HashMap<String, String> properties;

    @JsonProperty("kakao_account")
    private HashMap<String, String> kakaoAccount;
}
