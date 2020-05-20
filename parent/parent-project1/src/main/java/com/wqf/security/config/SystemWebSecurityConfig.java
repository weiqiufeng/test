package com.wqf.security.config;

import com.wqf.security.handler.SystemAccessDeniedHandler;
import com.wqf.security.handler.SystemAuthenticationFailureHandler;
import com.wqf.security.handler.SystemAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @author GGBond
 * @date 2019/9/9 1:05
 * 1.casAuthenticationFilter()创建的bean为核心，所以必须设置anthenticationManager，cas返回的ticket由他来校验
 * 2. 由于设置的ServicePropertiesbean响应路径为/cas/login，所以权限配置处必须允许访问到，否则会出现死循环
 * 3. 入口点为casAuthenticationEntryPoint
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class SystemWebSecurityConfig extends WebSecurityConfigurerAdapter {
//
    @Autowired
    private PasswordEncoder passwordEncoder;        // 密码加密

    @Autowired
    private UserDetailsService userDetailsService;     // 认证类

    @Autowired
    private SystemAuthenticationFailureHandler systemAuthenticationFailureHandler;      // 认证失败处理器

    @Autowired
    private SystemAuthenticationSuccessHandler systemAuthenticationSuccessHandler;      // 认证成功处理器

    @Autowired
    private SystemAccessDeniedHandler systemAccessDeniedHandler;                        //没有权限处理器

    @Autowired
    private AuthenticationProvider authenticationProvider;//cas认证提供
    @Autowired
    private CasAuthenticationProvider casAuthenticationProvider;

    /**
     * 指定验证类，密码验证方式
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用数据库   查询方法实现UserDetailsService接口
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        //写死用户和角色
        //auth.inMemoryAuthentication()
        //.withUser("admin").password("admin").roles("USER").and()
        //.withUser("admin").password("123456").roles("ADMIN","USER");
    }

    @Override
    @Bean
    //注入authenticationManager
    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
        //设置cas认证提供
        return new ProviderManager(
                Arrays.asList(authenticationProvider));
    }

    /**
     * 自定义登录页面以及需要放行的资源
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        这段配置，我认为就是配置Security的认证策略, 每个模块配置使用and结尾。
            http.
                formLogin()//对应表单认证相关的配置
                    //  .loginPage("/index.html")//自定义登录页url,默认为/login
                        .usernameParameter("username")//用户名的请求字段 默认为userName
                        .passwordParameter("password")//密码的请求字段 默认为password
                    //  .loginProcessingUrl("/user/login")//录请求拦截的url,也就是form表单提交时指定的action
                        .failureForwardUrl("/login?error")
                        .failureHandler(systemAuthenticationFailureHandler)//登录失败的拦截器
                        .successHandler(systemAuthenticationSuccessHandler)//登录成功的拦截器
                    .permitAll()
                .and()
                .logout()//对应了注销相关的配置
                // .logoutUrl("/SysSecurity/logout")//指定spring security拦截的注销url
                //.logoutSuccessUrl("")//用户退出后要被重定向的url
                     .invalidateHttpSession(true)//默认为true,用户在退出后Http session失效
                .and()
                .authorizeRequests()//配置路径拦截，表明路径访问所对应的权限，角色，认证信息。
                    .antMatchers( "/js/**","/user/register","/index","/index.html","/static/**").permitAll()
                    .antMatchers("/resources/**", "/signup", "/about").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')").anyRequest()
                    .authenticated()
                .and()
                .exceptionHandling()//权限认证
                    .accessDeniedHandler(systemAccessDeniedHandler)
                .and()
                .csrf().disable()//自定义登录页面时需要加这个  因为securety默认登录页面会发送token   但是自定义的不会
                .httpBasic().disable();//可以配置basic登录
    }

    @Bean
    public CasAuthenticationFilter casAuthenticationFilter(ServiceProperties s)
            throws Exception {
        //cas认证过滤器，当触发本filter时，对ticket进行认证
        CasAuthenticationFilter filter = new CasAuthenticationFilter();
        filter.setServiceProperties(s);
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }
}
