package ru.javabegin.springboot.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = true)
public class SpringConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().disable(); //отключаем форму авторизации
        http.httpBasic().disable(); //отключаем бейсик авторизацию. стандартную баузерную форму авторизпации
        http.requiresChannel().anyRequest().requiresSecure(); // обязательное использование HTTPS

    }
}
