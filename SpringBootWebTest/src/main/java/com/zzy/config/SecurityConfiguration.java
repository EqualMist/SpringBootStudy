package com.zzy.config;

import com.zzy.service.impl.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Resource
    private AuthService authService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/api/auth/**").permitAll()
                .antMatchers( "/static/api/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/static/api/auth/access-denied")
                .loginProcessingUrl("/static/api/auth/login")
                .successForwardUrl("/static/api/auth/login-success")
                .failureForwardUrl("/static/api/auth/login-failure")
                .and()
                .logout()
                .logoutUrl("/static/api/auth/logout")
                .logoutSuccessUrl("/static/api/auth/logout-success")
                .and()
                .csrf().disable();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


    @Bean
    public CorsFilter corsFilter() {
        //创建CorsConfiguration对象后添加配置
        CorsConfiguration config = new CorsConfiguration();
        //设置放行哪些原始域，这里直接设置为所有
        config.addAllowedOriginPattern("*");
        //你可以单独设置放行哪些原始域 config.addAllowedOrigin("http://localhost:2222");
        //放行哪些原始请求头部信息
        config.addAllowedHeader("*");
        //放行哪些请求方式，*代表所有
        config.addAllowedMethod("*");
        //是否允许发送Cookie，必须要开启，因为我们的JSESSIONID需要在Cookie中携带
        config.setAllowCredentials(true);
        //映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        //返回CorsFilter
        return new CorsFilter(corsConfigurationSource);
    }

}
