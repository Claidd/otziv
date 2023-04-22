package com.hunt.otziv.config;

import com.hunt.otziv.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class MainSecurityConfig {

    /*Производим внедрение сервиса в котором userDetailsService*/
    private final UserService userService;

    public MainSecurityConfig(UserService userService) {
        this.userService = userService;
    }

/*Производим настройки аутентификации для нужных страниц*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/registration").permitAll()
                .requestMatchers("/company").hasAuthority(Role.ADMIN.name())
                .requestMatchers("/category/add").hasAuthority(Role.ADMIN.name())
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/auth")
                .and()
                .logout()
                .logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().disable()
                .csrf().disable();
//                .and()
//                .authenticationProvider(daoAuthenticationProvider());
        return http.build();
    }

    /*Производим настройки аутентификации для нужных страниц*/
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder (){
        return new BCryptPasswordEncoder(12);
    }

    /*Для работы с собственной базой данных необходимо настроить свой провайдер
    * Установить в него бикриптэнкодер и userDetailsServise чтобы секьюрити понимало откуда брать юзеров
    * И давало их нам в удобном ввиде*/
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(this.bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }

}
