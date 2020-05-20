package com.wqf.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Enums;
import com.wqf.utils.ResultVo;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author GGBond
 * @date 2019/9/12 14:54
 */

@Component
public class SystemAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        ResultVo resultVo = new ResultVo();
        resultVo.setFlag(false);

        // 没有此用户
        if ((exception instanceof InternalAuthenticationServiceException) || (exception instanceof UsernameNotFoundException)) {
        }

        // 账号不可用
        if (exception instanceof DisabledException) {
        }

        // 密码错误
        if (exception instanceof BadCredentialsException) {
        }
        exception.printStackTrace();
        String s = JSONObject.toJSONString(resultVo);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(s);
        writer.flush();
        writer.close();
    }
}

