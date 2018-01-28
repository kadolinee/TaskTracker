package com.codexsoft.tasktracking.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("manager1").password("manager1Pass").roles("manager");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login*").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .defaultSuccessUrl("/projectList")
                .failureUrl("/login.html?error=true")
                .and()
                .logout().logoutSuccessUrl("/login.html");
    }
}
