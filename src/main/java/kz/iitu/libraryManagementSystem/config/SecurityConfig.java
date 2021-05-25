package kz.iitu.libraryManagementSystem.config;

import kz.iitu.libraryManagementSystem.service.impl.AuthorServiceImpl;
//import kz.iitu.libraryManagementSystem.service.impl.SubscriberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthorServiceImpl authorService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/books").permitAll()
                .antMatchers("/new-book", "/add-book", "/update/**", "/book-update/**", "/book-delete/**").hasAuthority("AUTHOR")
//                .antMatchers("/books/create", "/books/update/**", "/books/delete/**", "/books/newbook").hasAuthority("AUTHOR")
                .antMatchers("/roles", "/roles/create", "/roles/update/**", "/roles/delete/**").hasAuthority("AUTHOR")
                .antMatchers("/roles").hasAuthority("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/users")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .addFilter(new JwtTokenGeneratorFilter(authenticationManager()))

                // Add a filter to validate the tokens with every request
                .addFilterAfter(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authorService)
                .passwordEncoder(passwordEncoder());
    }
}
