package com.config;

import com.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.ArrayList;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }

  /*  @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userDetails = User.builder()
                .username("kawsur")
                .password("$2y$10$LqPYTOcJhvhV7oSWXG5L2OkVMdQ4F0IbBxCP1Eyh2eqD7n8qgRhU6")
                .authorities("ROLE_USER", "ROLE_ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }*/
   /* @Bean
    UserDetailsServiceImpl customUserDetailsService() {
        return new UserDetailsServiceImpl();
    }*/
   /*@Bean
   UserDetailsManager users(DataSource dataSource) {
       UserDetails user = User.builder()
               .username("kawsur1")
               .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
               .roles("USER")
               .build();
       UserDetails admin = User.builder()
               .username("admin1")
               .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
               .roles("USER", "ADMIN")
               .build();
       JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
       users.createUser(user);
       users.createUser(admin);
       return users;
   }
*/

     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      /*  http
                .authorizeRequests()
                .antMatchers("/reg/**").permitAll()
               .antMatchers("/api/**")
               .access("hasRole('ROLE_ADMIN')")
               .antMatchers("/leaveTypes/**")
               .access("hasRole('ROLE_USER')")

               .and()
                .formLogin();*/
         http
                 .authorizeRequests()
                 .antMatchers("/resources/**", "/WEB-INF/jsp/*").permitAll()
                 .anyRequest().authenticated()
                 .and()
                 .formLogin()
                 .loginPage("/login")
                 .defaultSuccessUrl("/welcome")
                 .failureUrl("/login?error")
                 .permitAll()
                 .and()
                 .logout()
                 .permitAll();
        return http.build();
    }
}
