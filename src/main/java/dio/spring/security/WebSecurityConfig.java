package dio.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    // CÓDIGO APRESENTADO NO CURSO , PORÉM ESTÃO USANDO UMA VERSÃO DO SPRING ANTIGA E COMO ESTOU USANDO NOVA, NÃO RODA
//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}user123")
//                .roles("USERS")
//                .and()
//                .withUser("admin").password("{noop}master123")
//                .roles("MANAGERS");
//    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password("{noop}user123")
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}adm123")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}

