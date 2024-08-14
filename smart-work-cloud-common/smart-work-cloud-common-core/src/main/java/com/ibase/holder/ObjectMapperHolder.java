package com.ibase.holder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取全局统一的ObjectMapper工具类
 */
@Component
public class ObjectMapperHolder
{
    private static ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        ObjectMapperHolder.objectMapper = objectMapper;
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
