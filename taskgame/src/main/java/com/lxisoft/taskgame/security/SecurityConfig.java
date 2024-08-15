package com.lxisoft.taskgame.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.lxisoft.taskgame.service.GetUserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private GetUserDetails getUserDetails;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(
            auth->{auth.requestMatchers("/").permitAll()
                        .requestMatchers("/signup","/addUser").permitAll()
                        .requestMatchers("/gethome").hasAnyAuthority("user","admin")
                        .requestMatchers("/addproject").hasAuthority("admin")
                        .anyRequest().authenticated();
                    }
        )
        .formLogin(f->f.loginPage("/login").permitAll())
        .logout(f->f.permitAll())
        .userDetailsService(getUserDetails);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    } 

}
