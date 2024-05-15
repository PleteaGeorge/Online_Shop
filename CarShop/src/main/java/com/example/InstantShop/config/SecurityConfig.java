package com.example.InstantShop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth ->{
                auth.requestMatchers("/register").permitAll();
                auth.requestMatchers("/login").permitAll();
                auth.requestMatchers("/home").permitAll();
                auth.requestMatchers("/product").authenticated();
                auth.requestMatchers("/cart", "/buy").authenticated();
                auth.requestMatchers("/Css/**", "/javascript/**", "/Images/**").permitAll();
                auth.requestMatchers("/addToCart/{productId}").authenticated();
                auth.requestMatchers("/removeFromCart/{productId}").authenticated();

        });
        http.csrf().disable();

        http.formLogin(formLogin ->{
            try {
                formLogin.loginPage("/login").permitAll()
                        .defaultSuccessUrl("/home", true);
            } catch (Exception e){
                throw new RuntimeException(e);
            }
        });
        return http.httpBasic().and().build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
