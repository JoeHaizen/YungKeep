//package com.yungkeep.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // pour les API REST (à adapter si tu utilises un front intégré)
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll() // autorise toutes les requêtes
//                )
//                .formLogin().disable() // désactive /login
//                .httpBasic().disable(); // désactive l’authentification basique si non utilisée
//        http
//                .csrf().disable()
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/hello").permitAll() // accessible sans authentification
//                        .anyRequest().authenticated()              // toutes les autres requêtes sont protégées
//                )
//                .formLogin().disable()
//                .httpBasic().disable();
//        return http.build();
//    }
//}
//
