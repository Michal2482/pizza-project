package com.example.pizzaproject.config;


import com.example.pizzaproject.service.RegisterCompanyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class Auth extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final RegisterCompanyService registerCompanyService;

    public Auth(@Qualifier("customUserDetailsService") final UserDetailsService userDetailsService, RegisterCompanyService registerCompanyService) {
        this.userDetailsService = userDetailsService;
        this.registerCompanyService = registerCompanyService;
    }
    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/pizzeria").permitAll()
                .antMatchers("/pizzeria/categories").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/addCategory").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/editCategory/**").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/deleteCategory/**").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/addDish/**").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/editDish/**").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/mealList").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/deleteDish/**").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/meal/**").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/addPerson").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/editPerson/**").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/personList").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .antMatchers("/pizzeria/deletePerson/**").hasAnyRole("ADMIN","PIZZERIA_OWNER")
//                .antMatchers("/pizzeria/admin/**").hasAnyRole("ADMIN","PIZZERIA_OWNER")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
//                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/pizzeria/admin")
                .failureUrl("/login?error")
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout");
    }

}
