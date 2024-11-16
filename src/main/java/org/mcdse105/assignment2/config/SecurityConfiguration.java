package org.mcdse105.assignment2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http
            .cors(withDefaults())
            .csrf(csrf -> csrf
                    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/static/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/products")).hasAnyAuthority("ADMIN", "USER")
                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/about")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/contact")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/login")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/register")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/register")).permitAll()
                    .anyRequest().authenticated())
            .formLogin(login -> login
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .defaultSuccessUrl("/products")
                    .permitAll())
            .logout(logout -> logout
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/")
                    .permitAll());

        return http.build();
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
}
