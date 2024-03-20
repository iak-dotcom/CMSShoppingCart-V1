package com.khan.cmsshoppingcartv1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // Categorry permitted by User and admin
                .antMatchers("/category/**").hasAnyRole("USER","ADMIN")
                //  /admin only access by admin
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                // rest can be seen by anyone
                .antMatchers("/").permitAll()
                .and()
                // form login would be shown
                .formLogin()
                    .loginPage("/login")
            .and()
                .logout()
                    .logoutSuccessUrl("/")
            .and()
                .exceptionHandling()
                    .accessDeniedPage("/");

    }
}
