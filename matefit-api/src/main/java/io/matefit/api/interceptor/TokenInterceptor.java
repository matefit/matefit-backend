package io.matefit.api.interceptor;

import io.matefit.api.service.impl.JwtServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
@RequiredArgsConstructor
public class TokenInterceptor implements HandlerInterceptor {

    private final JwtServiceImpl jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object hanlder)
            throws Exception {
        String token = request.getHeader("Authorization").substring(7);
        Long accountId = jwtService.validateToken(token).orElse(null);

        log.info("토큰: {}, 아이디: {}", token, accountId);

        if (accountId == null) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }

        request.setAttribute("accountId", accountId);
        return true;
    }
}
