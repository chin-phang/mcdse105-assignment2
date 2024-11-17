package org.mcdse105.assignment2.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(withDefaults())
            .csrf(csrf -> csrf
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.GET, "/").permitAll()
                    .requestMatchers(HttpMethod.GET, "/static/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/products").hasAnyAuthority("ADMIN", "USER")
                    .requestMatchers(HttpMethod.GET, "/about").permitAll()
                    .requestMatchers(HttpMethod.GET, "/contact").permitAll()
                    .requestMatchers(HttpMethod.GET, "/login").permitAll()
                    .requestMatchers(HttpMethod.GET, "/register").permitAll()
                    .requestMatchers(HttpMethod.POST, "/register").permitAll()
                    .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                    .anyRequest().authenticated())
            .formLogin(login -> login
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .defaultSuccessUrl("/products")
                    .permitAll())
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/")
                    .permitAll());

        return http.build();
    }
}
