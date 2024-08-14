package com.ibase.handler;

import com.ibase.domain.Result;
import com.ibase.utils.ResponseUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

/**
 * 用户认证失败处理
 */
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler
{

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String localizedMessage = exception.getLocalizedMessage();
        ResponseUtils.renderResult(response, Result.fail(localizedMessage));
    }
}
