package com.ibase.config;

import com.ibase.handler.*;
import com.ibase.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.CompositeAccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig
{
    @Resource
    private SysUserService sysUserService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //设置权限,允许某些URL匿名访问
        http.authorizeHttpRequests(authorize ->{
            authorize.requestMatchers(PathMatcherUtil.AUTH_WHITE_LIST).permitAll()
                    .anyRequest().authenticated();
        });

        http.formLogin(form -> {
            form.loginProcessingUrl(PathMatcherUtil.FORM_LOGIN_URL).permitAll()
                    .successHandler(new CustomAuthenticationSuccessHandler())
                    .failureHandler(new CustomAuthenticationFailureHandler());
        });

        http.userDetailsService(username -> sysUserService.loadUserByUsername(username));
        //推出登录自定义处理类
        http.logout(logout ->{
            logout.logoutSuccessHandler(new CustomLogoutSuccessHandler());
        });
        //鉴权失败、认证失败
        http.exceptionHandling(exception ->{
            exception.authenticationEntryPoint(new CustomAuthenticationEntrypointHandler())
                    .accessDeniedHandler(new CustomAccessDeniedHandler())
            ;
        });
        //账号会话配置信息
        http.sessionManagement(session -> {
            //允许一个账号仅一个地方登录
            session.maximumSessions(1).expiredSessionStrategy(new CustomSessionInformationExpiredStrategyHandler());
        });

        //关闭csrf
        http.csrf(AbstractHttpConfigurer::disable);
        //允许跨域请求
        http.cors(Customizer.withDefaults());

        return http.build();
    }
}
