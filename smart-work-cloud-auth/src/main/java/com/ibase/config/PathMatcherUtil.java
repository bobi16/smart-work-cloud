package com.ibase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "config")
@Configuration
public class PathMatcherUtil
{

    @Value("auth.white.list")
    public static String[] AUTH_WHITE_LIST;

    @Value("auth.login.url")
    public static String FORM_LOGIN_URL = "/login";
}
