package com.capstone.configuration;

import com.capstone.Service.UserService;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringBootSecurityConfiguration extends WebSecurityConfigurerAdapter  {

    private final UserService userService;

    public SpringBootSecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // csrf().disable() : 사이트간 요청 위조 공격 방지 기능 켜기
                .authorizeRequests() // 요청에 의한 보안 검사 시작
                .antMatchers("/", "/SignUpForm").permitAll()
                .antMatchers("/MainHomePage").hasRole("USER") // 권한이 있기만 하다면 접근 가능
                .and()
                .httpBasic().disable()
                .formLogin()
                    .loginPage("/Login") // 로그인 페이지
                    .usernameParameter("userEmail")
                    .passwordParameter("userPassword")
                    .loginProcessingUrl("/MainHomePage")
                    .defaultSuccessUrl("/MainHomePage") // 로그인 성공시 제공할 페이지
                    .failureUrl("/Temp") // 로그인 실패 시 제공할 페이지
                    .permitAll(); // 로그인 폼은 누구나 접근이 가능
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

}