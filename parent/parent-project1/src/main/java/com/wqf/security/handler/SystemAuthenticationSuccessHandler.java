package com.wqf.security.handler;


import com.alibaba.fastjson.JSONObject;
import com.wqf.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * @author GGBond
 * @date 2019/9/12 15:05
 */

@Component
public class SystemAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//    @Autowired
//    private SysUserMapper sysUserMapper;

//    @Autowired
//    private SecContext secContext;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        ResultVo result = new ResultVo();
        result.setFlag(true);
        result.setCode(200);
        result.setMsg("登录成功");
        JSONObject resultMap = new JSONObject();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User secUser = null;
        if(principal != null ){
            if (principal != null && principal instanceof User) {
                secUser = (User) principal;
            }
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        User userDetail = (User) authentication.getPrincipal();
        request.getSession().setAttribute("fu", userDetail.getUsername());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String loginTime = format.format(new Date());
//        List<ZTreeMenu> menuList = sysUserMapper.selectMenuByuserid(secUser.getId());
//        for (ZTreeMenu it:menuList){
//            if (it.getStatus() == 1){
//                it.setShow(true);
//            }else {
//                it.setShow(false);
//            }
//        }
        //权限信息
        List<String> buttonList = new LinkedList<>();
        buttonList.add("approval:approval:view");
        buttonList.add("years:years:edit");
        buttonList.add("approval:approval:edit");
        buttonList.add("sys:dict:edit");
        buttonList.add("adv:class:edit");
        /*if(buttonList.size()<1||buttonList == null){
            result.setCode(104);
            result.setMsg("没有访问权限");
        }*/
        List newTree = new LinkedList();
        resultMap.put("loginTime", loginTime);
        resultMap.put("username",secUser.getUsername());
        resultMap.put("id","");
        resultMap.put("nickName","");
        resultMap.put("avatar","");
        resultMap.put("menuList",newTree);
        resultMap.put("buttonList",buttonList);
        result.setData(resultMap);
        String resultStr = JSONObject.toJSONString(result);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(resultStr);
    }
}

