package com.zzy.config;

import com.zzy.cache.RedisTokenRepository;
import com.zzy.service.impl.AuthServiceRedisVer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Resource
//    private UserAuthService userAuthService;
    // Redis缓存用户验证
    @Resource
    private AuthServiceRedisVer authServiceRedisVer;
    @Resource
    RedisTokenRepository redisTokenRepository;
    @Resource
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/static/**", "/register", "/api/auth/**").permitAll()
                .anyRequest().hasAnyRole("user", "admin")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .permitAll()
                .defaultSuccessUrl("/index")
                .and()
                .csrf().disable()
                .rememberMe()
                .tokenRepository(redisTokenRepository);
//                .tokenRepository(new JdbcTokenRepositoryImpl(){{setDataSource(dataSource);}});

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(authServiceRedisVer)
//                .userDetailsService(userAuthService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
