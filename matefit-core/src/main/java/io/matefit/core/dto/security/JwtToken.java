package io.matefit.core.dto.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtToken {

    @JsonProperty("access_token")
    private String accessToken;
}
