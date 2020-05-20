package com.wqf.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author GGBond
 * @date 2019/9/15 22:35
 */
@Service
public class SystemUserDetailsService implements UserDetailsService {

//    @Autowired
//    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userDetail = new User();
        try {
            userDetail.setUserName("admin");
            userDetail.setPassword("$2a$10$zhvxqabslwrLwTV2CLer9en6ptwieloVS0SkSipaGPunVTSObH9wO");
            List<GrantedAuthority> auths = new ArrayList<>();
            // 根据用户名查询用户id
//        SysUser dbUser = sysUserService.getByUsername2(username);
            if (userDetail == null) {
                throw new Exception("");
            }
            if (userDetail.getPassword() == null || userDetail.getPassword().equals("")){
                throw new Exception("密码为空");
            }
            List<String> permsList = new LinkedList<>();
            permsList.add("approval:approval:view");
            permsList.add("years:years:edit");
            permsList.add("approval:approval:edit");
            permsList.add("sys:dict:edit");
            permsList.add("adv:class:edit");
            for (String perms : permsList) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(perms);
                auths.add(authority);
            }
            return new org.springframework.security.core.userdetails.User(userDetail.getUserName(), userDetail.getPassword(), auths);
        } catch (Exception e) {
            e.printStackTrace();
            return new org.springframework.security.core.userdetails.User(userDetail.getUserName(), userDetail.getPassword(), null);
        }



    }

    public static void main(String[] args) {
        List<String> permsList = new LinkedList<>();
        permsList.add("approval:approval:view");
        permsList.add("years:years:edit");
        permsList.add("approval:approval:edit");
        permsList.add("sys:dict:edit");
        permsList.add("adv:class:edit");
        permsList.forEach(e->{
            System.out.println(e);
        });
    }
}


