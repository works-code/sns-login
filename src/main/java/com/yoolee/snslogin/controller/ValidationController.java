package com.yoolee.snslogin.controller;


import com.yoolee.snslogin.repository.UsersRepository;
import com.yoolee.snslogin.vo.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ValidationController {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/validation")
    public boolean validation(Users users){
        if(ObjectUtils.isEmpty(usersRepository.findUsersByEmail(users.getEmail()))){
            return true;
        }else{
            return false;
        }
    }

}
