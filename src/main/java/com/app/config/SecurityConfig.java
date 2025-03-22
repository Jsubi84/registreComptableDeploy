package com.app.config;

import com.app.config.filter.JwtTokenValidator;
import com.app.service.UserDetailServiceImpl;
import com.app.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtUtils jwtUtils;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    // Configurar los endpoints publicos
                    http.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();

                    // Configurar los endpoints privados
                    http.requestMatchers(HttpMethod.POST, "/api/**").permitAll();
                    http.requestMatchers(HttpMethod.GET, "/api/**").permitAll();
                    http.requestMatchers(HttpMethod.PUT, "/api/**").permitAll();
                    http.requestMatchers(HttpMethod.DELETE, "/api/**").permitAll();
//                    http.requestMatchers(HttpMethod.GET, "/api/**").hasRole("ADMIN");
//                    http.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
//                    http.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN");
//                    http.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN");
//                    http.requestMatchers(HttpMethod.GET, "/api/**").hasRole("STD");
//                    http.requestMatchers(HttpMethod.POST, "/api/**").hasRole("STD");
//                    http.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("STD");
//                    http.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("STD");
//                    http.requestMatchers(HttpMethod.GET, "/method/get").hasAuthority("READ");
//                    http.requestMatchers(HttpMethod.POST, "/method/post").hasAuthority("CREATE");
//                    http.requestMatchers(HttpMethod.DELETE, "/method/delete").hasAuthority("DELETE");
//                    http.requestMatchers(HttpMethod.PUT, "/method/put").hasAuthority("UPDATE");

                    // Configurar el resto de endpoint - NO ESPECIFICADOS
                    http.anyRequest().denyAll();
                })
                .addFilterBefore(new JwtTokenValidator(jwtUtils), BasicAuthenticationFilter.class)
                .build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
