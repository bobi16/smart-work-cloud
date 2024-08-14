package com.ibase.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibase.domain.Result;
import com.ibase.holder.ObjectMapperHolder;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ResponseUtils
{
    private static final ObjectMapper objectMapper = ObjectMapperHolder.getObjectMapper();

    public static void renderResult(HttpServletResponse response, Result result)
    {
        try {
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(result));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
