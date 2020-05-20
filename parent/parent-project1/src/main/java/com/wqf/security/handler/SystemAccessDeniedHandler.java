package com.wqf.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.wqf.utils.ResultVo;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author GGBond
 * @date 2019/9/12 14:42
 */

@Component
public class SystemAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResultVo vo = new ResultVo();
        vo.setFlag(false);
        vo.setCode(403);
        vo.setMsg("无权访问");
        String s = JSONObject.toJSONString(vo);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(s);
        writer.flush();
        writer.close();
    }
}

