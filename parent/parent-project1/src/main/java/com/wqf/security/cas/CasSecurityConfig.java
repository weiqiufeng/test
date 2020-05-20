package com.wqf.security.cas;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.jasig.cas.client.validation.Cas30ServiceTicketValidator;
import org.jasig.cas.client.validation.TicketValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.security.cas.ServiceProperties;
import org.springframework.security.cas.authentication.CasAuthenticationProvider;
import org.springframework.security.cas.web.CasAuthenticationEntryPoint;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

import javax.servlet.http.HttpSessionEvent;
//cas校验流程：
//
//        用户访问业务系统（client）
//        无权限时跳转到cas（服务端），并且携带参数为service=${客户端url}，所以我们看到登录页时浏览器路径为 http://localhost:8080/login?service=http%3A%2F%2Flocalhost%3A8123%2Flogin
//        当用户在cas处登录完后，会颁发一个ticket带回client端，如http://localhost:8123/login/cas?ticket=xxxxx
//        业务系统获取到ticket后，拿这个ticket请求cas获取对应的登录用户
//        cas返回对应的用户信息，业务系统再对该用户进行身份映射再次认证，则完成本次登录
/**
 * @Desc
 * @Author weiqiufeng
 * @Date 2020-05-12
 * 注意casAuthenticationProvider()方法创建的bean，该bean可以设置用户映射，正常来说，例如通过第三方github登录，
 * 这里返回的openid，是github的用户id，则需要对用户进行映射或做用户绑定，则在这里做手脚
 **/
public class CasSecurityConfig {
    //cas服务
    @Value("${cas.server.url:http://localhost:8080}")
    private String casServerUrl;

    @Bean
    public ServiceProperties serviceProperties() {
        ServiceProperties serviceProperties = new ServiceProperties();
        //本机服务，访问/login/cas时进行校验登录
        serviceProperties.setService("http://localhost:8123/login/cas");
        serviceProperties.setSendRenew(false);
        return serviceProperties;
    }

    @Bean
    @Primary
    public AuthenticationEntryPoint authenticationEntryPoint(
            ServiceProperties sP) {

        CasAuthenticationEntryPoint entryPoint
                = new CasAuthenticationEntryPoint();
        //cas登录服务
        entryPoint.setLoginUrl(casServerUrl + "/login");
        entryPoint.setServiceProperties(sP);
        return entryPoint;
    }

    @Bean
    public TicketValidator ticketValidator() {
        //指定cas校验器
        return new Cas30ServiceTicketValidator(
                casServerUrl);
    }

    //cas认证
    @Bean
    public CasAuthenticationProvider casAuthenticationProvider() {

        CasAuthenticationProvider provider = new CasAuthenticationProvider();
        provider.setServiceProperties(serviceProperties());
        provider.setTicketValidator(ticketValidator());
        //固定响应用户，在生产环境中需要额外设置用户映射
        provider.setUserDetailsService(
                s -> new User("auth-user", "123", true, true, true, true,
                        AuthorityUtils.createAuthorityList("ROLE_ADMIN")));
        provider.setKey("CAS_PROVIDER_LOCALHOST_8123");
        return provider;
    }


    @Bean
    public SecurityContextLogoutHandler securityContextLogoutHandler() {
        return new SecurityContextLogoutHandler();
    }

    @Bean
    public LogoutFilter logoutFilter() {
        //退出后转发路径
        LogoutFilter logoutFilter = new LogoutFilter(
                casServerUrl + "/logout",
                securityContextLogoutHandler());
        //cas退出
        logoutFilter.setFilterProcessesUrl("/logout/cas");
        return logoutFilter;
    }

    @Bean
    public SingleSignOutFilter singleSignOutFilter() {
        //单点退出
        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
        singleSignOutFilter.setCasServerUrlPrefix(casServerUrl);
        singleSignOutFilter.setIgnoreInitConfiguration(true);
        return singleSignOutFilter;
    }

    //设置退出监听
    @EventListener
    public SingleSignOutHttpSessionListener singleSignOutHttpSessionListener(
            HttpSessionEvent event) {
        return new SingleSignOutHttpSessionListener();
    }
}
