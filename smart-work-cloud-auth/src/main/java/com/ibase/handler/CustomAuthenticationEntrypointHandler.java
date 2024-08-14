package com.ibase.handler;

import com.ibase.domain.Result;
import com.ibase.utils.ResponseUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/**
 * 未认证请求处理
 */
public class CustomAuthenticationEntrypointHandler implements AuthenticationEntryPoint
{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String message = "用户认证失败,请重新登录!"; //authException.getLocalizedMessage();
        ResponseUtils.renderResult(response, Result.error(message));
    }
}
