package com.ibase.handler;

import com.ibase.domain.Result;
import com.ibase.utils.ResponseUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import java.io.IOException;

/**
 * 会话失效处理
 */
public class CustomSessionInformationExpiredStrategyHandler implements SessionInformationExpiredStrategy
{
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        HttpServletResponse response = event.getResponse();
        ResponseUtils.renderResult(response, Result.error("当前会话已失效,请重新登录!"));
    }
}
