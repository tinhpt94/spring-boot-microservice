package com.tinhpt.order.config;

import com.tinhpt.common.security.JwtConfig;
import com.tinhpt.common.security.JwtTokenAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        final String[] REQUEST_WHITE_LIST = new String[]{
                "/swagger-resources/**",
                "/webjars/**",
                "/configuration/**",
                "/v2/api-docs",
                "favicon.ico",
                "/swagger-ui.html/**"
        };
        http
                .csrf().disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // handle an authorized attempts
                .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .antMatchers(REQUEST_WHITE_LIST)
                .permitAll()
                .and()
                .addFilterBefore(new JwtTokenAuthenticationFilter(jwtConfig), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest()
                .authenticated();;
    }

    @Bean
    public JwtConfig getJwtConfig() {
        return new JwtConfig();
    }
}