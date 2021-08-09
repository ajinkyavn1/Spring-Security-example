package com.spring.springsecurity.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.spring.springsecurity.Security.ApplicationUserPermisions.COURSE_WRITE;
import static com.spring.springsecurity.Security.ApplicationUserRoles.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private  final PasswordEncoder passwordEncoder;
    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*").permitAll()
                .antMatchers("/api/**").hasRole(STUDENT.name())
//                .antMatchers(HttpMethod.DELETE,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.POST,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers(HttpMethod.PUT,"/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                .antMatchers("/management/api/**").hasAnyRole(ADMIN.name(),SUPERADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
      UserDetails Student1= User.builder()
               .username("USER")
               .password(passwordEncoder.encode("USER"))
//               .roles(STUDENT.name())
              .authorities(STUDENT.getGrantedAuthorities())
               .build();
      UserDetails Admin=User.builder()
              .username("ADMIN")
              .password(passwordEncoder.encode("ADMIN"))
              .authorities(ADMIN.getGrantedAuthorities())
//              .roles(ADMIN.name())
              .build();
        UserDetails Administrative=User.builder()
                .username("SUPERADMIN")
                .password(passwordEncoder.encode("ADMIN"))
                .authorities(SUPERADMIN.getGrantedAuthorities())
                .build();
       return  new InMemoryUserDetailsManager(
               Student1,
               Admin,
               Administrative
       );
    }
}
