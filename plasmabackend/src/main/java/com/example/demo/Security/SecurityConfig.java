package com.example.demo.Security;

import com.example.demo.Implementation.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@CrossOrigin("http://localhost:3000")
@EnableWebSecurity
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("http://localhost:3000"); // Modify to allow specific origins
//        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // Modify allowed methods
//        config.setAllowedHeaders(Arrays.asList("Content-Type", "CSRF-Token")); // Add specific headers
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setHideUserNotFoundExceptions(false); // Throw exceptions when user not found
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        logger.debug("Configuring security filter chain");

        http
                .csrf(csrf -> csrf
                        .disable()
                )
                .authorizeHttpRequests(req ->
                                req
                                        // Allow access to OPTIONS requests
                                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                                        // Allow access to static resources and specific endpoints without authentication
                                        .requestMatchers(
                                                "/bower_components/**", "/components/**", "/Service/**","/*.js", "/*.jsx", "/main.css",
                                                "/auth/**",
                                                "/csrf-token",
                                                "/login", "/logout"
                                        ).permitAll()
                        // Require authentication for any other request
                )
                // Disable form login
                .formLogin(formLogin -> formLogin
                        .disable()
                )
                // Configure logout endpoint
                .logout(logout -> logout
                        .logoutSuccessUrl("/register")
                        .permitAll()
                );
                // Add CORS filter

        return http.build();
    }
}
