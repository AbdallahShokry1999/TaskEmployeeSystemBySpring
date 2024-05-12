package com.example.demo.config;

import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class Configer {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.GET, "/api/departments/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.GET, "/api/projects/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.POST, "/api/employees/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.POST, "/api/departments/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.POST, "/api/projects/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.PUT, "/api/projects/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/projects/**").hasRole("MANGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/departments/**").hasRole("MANGER")
        );

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        // in general, not required for stateless REST APIs that use POST, PUT, DELETE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


/*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
*/
    /*

    CREATE TABLE members (
  user_id varchar(50) PRIMARY KEY,
  pw text NOT NULL,
  active smallint NOT NULL
);


INSERT INTO members (user_id, pw, active)
SELECT name, pw, 1 as active
FROM employee;


CREATE TABLE roles (
  user_id varchar(50) NOT NULL,
  role varchar(50) NOT NULL,
  CONSTRAINT authorities5_idx_1 UNIQUE (user_id, role),
  CONSTRAINT authorities5_ibfk_1 FOREIGN KEY (user_id) REFERENCES members (user_id)
);



INSERT INTO roles (user_id, role)
SELECT m.user_id, e.role
FROM members m
JOIN employee e ON m.user_id = e.name;


     */

}