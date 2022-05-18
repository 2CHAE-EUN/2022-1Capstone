//package com.capstone.configuration;
//
//
//import com.capstone.JWT.JWTFilter;
//import com.capstone.JWT.TokenProvider;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
///*
// * JWT필터를 스프링시큐어리티가 관리하려면 설정에서 추가해야함
// * 필터는 new를 사용하여 객체를 생성하여 등록
// * 필터에 @Component나 @Bean을 붙이게 되면 new로 선언해준 것 외에도 한번 더 필터로 등록됨
// * */
//
//@EnableWebSecurity // 스프링 시큐어리티를 적용한다는 어노테이션
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    // SecurityConfigurerAdapter를 extends하고 TokenProvider를 주입받아서 JWTFilter를 통해 Security 로직에 필터를 등록
//
//    private final TokenProvider tokenProvider;
//
//    public SecurityConfig(TokenProvider tokenProvider) {
//        this.tokenProvider = tokenProvider;
//    }
//
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override // URL 별 인증여부, 로그인처리, 로그아웃 처리 등 가능
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic().disable()
//                .formLogin().disable() // 스프링부트에서 제공하는 로그인폼을 사용하지 않음
//                .csrf().disable(); // csrf()는 웹 사이트의 취약점을 이용한 의도치 않은 요청을 통한 공격을 의미
//
//        http.authorizeRequests() // 다음 리퀘스트에 대한 사용 권한 체크
//                .antMatchers("/").anonymous()
//                .antMatchers("/signUpForm").anonymous()
//                .antMatchers("/Login").anonymous() // 인증되지 않은 사용자 접근 가능
//                .and()
//                .addFilterBefore(new JWTFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
//    }
//}

