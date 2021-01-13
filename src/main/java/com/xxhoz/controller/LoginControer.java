package com.xxhoz.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.xxhoz.Utils.JWTUtil;
import com.xxhoz.Utils.ResJsonUtils;
import com.xxhoz.pojo.HosUser;
import com.xxhoz.service.HosUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api")
public class LoginControer {

    @Autowired
    HosUsersService hosUsersService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String Login(String username,String password) throws JsonProcessingException {
        HosUser hosUser = hosUsersService.queryUser(username, password);
        if(hosUser!=null){
            String sign = JWTUtil.sign(username, String.valueOf(hosUser.getUserId()));
            return ResJsonUtils.Tojson(sign);
        }else{
            return ResJsonUtils.Tojson("用户名或密码错误");
        }
    }
}
