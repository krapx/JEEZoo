package com.example.jeezoo;

import com.example.jeezoo.security.JWTFilter;
import com.example.jeezoo.security.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity()
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;

    public SecurityConfig(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .csrf().disable()
            .cors()
            .and()
            .authorizeRequests()
                .antMatchers("/login", "/register", "/demo").permitAll()
                .antMatchers("/api/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest()
                .authenticated()
                .and()
            .addFilterBefore(new JWTFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}