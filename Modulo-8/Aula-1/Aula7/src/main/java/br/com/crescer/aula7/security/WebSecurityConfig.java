package br.com.crescer.aula7.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private CustomUserDetailService userDetailsService2;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/ator")
                .permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout().logoutUrl("/logout").deleteCookies("JSESSIONID").permitAll()
                .and()
                .cors().disable()
                .csrf().disable();
    }
}
