
package com.co;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password("{noop}1234")
            .roles("ADMIN","USER")
            .and()
            .withUser("user")
            .password("{noop}1234")
            .roles("USER")
            ;
    }
    
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                .antMatchers("/login")
                    .hasRole("ADMIN")
                .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/loginadmin")
                    .failureUrl("/login?error=true")
                    .permitAll()
                ;
                
    }
}
