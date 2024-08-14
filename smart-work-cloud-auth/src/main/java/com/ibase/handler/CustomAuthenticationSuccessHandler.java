package com.ibase.handler;

import com.ibase.domain.Result;
import com.ibase.utils.ResponseUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

/**
 * 认证成功处理
 */
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获取用户信息
        User principal = (User) authentication.getPrincipal();

        //将用户信息返回到前端
        ResponseUtils.renderResult(response, Result.ok("登录成功!", principal));
    }
}
