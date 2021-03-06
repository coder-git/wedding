package com.demo.common.config;
import com.demo.common.jwt.JwtAccessDeniedHandler;
import com.demo.common.jwt.JwtAuthenticationEntryPoint;
import com.demo.common.jwt.JwtTokenUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
//    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//    private final JwtTokenUtils jwtTokenUtils;
//
////    public SecurityConfig(JwtAccessDeniedHandler jwtAccessDeniedHandler, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtTokenUtils jwtTokenUtils) {
////
////        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
////        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
////        this.jwtTokenUtils = jwtTokenUtils;
////
////    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // ?????? CSRF
                .csrf().disable()

                // ????????????
                .exceptionHandling()
//                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .accessDeniedHandler(jwtAccessDeniedHandler)

                // ??????iframe ????????????
                .and()
                .headers()
                .frameOptions()
                .disable()

                // ???????????????
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()

                // ??????swagger
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/doc.html").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/*/api-docs").permitAll()

                // ??????????????????
                .antMatchers("/file/**").permitAll()

                // ??????druid
                .antMatchers("/druid/**").permitAll()

                //?????????????????????????????????
                .antMatchers("/test/login", "/error/**").permitAll()
                // ???????????????????????????
                .anyRequest().authenticated();

        // ????????????
        httpSecurity.headers().cacheControl();

//        // ??????JWT filter
//        httpSecurity
//                .apply(new TokenConfigurer(jwtTokenUtils));
    }

    public class TokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

        private final JwtTokenUtils jwtTokenUtils;

        public TokenConfigurer(JwtTokenUtils jwtTokenUtils){

            this.jwtTokenUtils = jwtTokenUtils;
        }

//        @Override
//        public void configure(HttpSecurity http) {
//            JwtAuthenticationTokenFilter customFilter = new JwtAuthenticationTokenFilter(jwtTokenUtils);
//            http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
//        }
    }
}
