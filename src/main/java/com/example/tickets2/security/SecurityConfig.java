package com.example.tickets2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                //.formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authCustomizer -> authCustomizer

                                .requestMatchers("/createEvent","/editEvent","/crudEvent").hasRole("ADMIN")
                                //.requestMatchers("/home","/detailsEvent").hasAnyRole("GUEST","ADMIN","USER")
                                .requestMatchers("/home","/detailsEvent","/login","/webjars/**").permitAll()

                                .anyRequest().authenticated()

                )
                .formLogin(
                        formLogin -> formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/")
                )
               // .exceptionHandling(e->e.accessDeniedPage("accessDenied"))
        .build();

    }
    //@Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(bCryptPasswordEncoder().encode("123")).roles("ADMIN","USER").build(),
                User.withUsername("guest").password(bCryptPasswordEncoder().encode("123")).roles("GUEST").build(),
                User.withUsername("accountant").password(bCryptPasswordEncoder().encode("123")).roles("USER").build()

        );
    }
}
