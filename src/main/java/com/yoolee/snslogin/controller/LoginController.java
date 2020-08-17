package com.yoolee.snslogin.controller;

import com.yoolee.snslogin.repository.UsersRepository;
import com.yoolee.snslogin.vo.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String main(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Users users){
        users = usersRepository.findUsersByEmailAndPassword(users.getEmail(),users.getPassword());
        if(ObjectUtils.isEmpty(users)){
            return "fail";
        }
        return "success";
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join(){
        return "join";
    }

    @RequestMapping(value = "/join" , method = RequestMethod.POST)
    public String join(Users users){
        try{
            usersRepository.save(users);
            return "login";
        }catch (Exception e){
            log.error("[Error] {}",e.getMessage());
        }
        return "fail";
    }

}
