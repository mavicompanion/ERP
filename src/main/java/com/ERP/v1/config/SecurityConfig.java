package com.ERP.v1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

import com.ERP.v1.model.Employee;
import com.ERP.v1.service.EmployeeService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    EmployeeService employeeService;

    // Filter chain for authorization.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/registration","/css/**","/images/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/hello","/employee/**").hasAnyRole("EMPLOYEE","ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/hello")
                .permitAll()
                .successHandler(new LoginSuccessHandler())
            )
            .logout((logout) -> logout.permitAll().logoutSuccessUrl("/login"))
            ;

        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService()
    {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
            {
                Employee employee = employeeService.getEmployee(email);

                 // If the user is not found, throw an exception
                if (employee == null) {
                    throw new UsernameNotFoundException("Username not found");
                }
                else
                {
                    @SuppressWarnings("deprecation")
                    UserDetails user = User
                    .withDefaultPasswordEncoder().username(employee.getEmail())
                    .password(employee.getPassword())
                    .roles(employee.getRole())
                    .build();
                    return user;
                }
            }
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider()

    {
        final DaoAuthenticationProvider DaoauthenticationProvider = new DaoAuthenticationProvider();
        DaoauthenticationProvider.setUserDetailsService(userDetailsService());
        return DaoauthenticationProvider;
    }

}
