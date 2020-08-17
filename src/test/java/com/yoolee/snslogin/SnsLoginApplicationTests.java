package com.yoolee.snslogin;

import com.yoolee.snslogin.repository.UsersRepository;
import com.yoolee.snslogin.vo.Users;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SnsLoginApplicationTests {

    @Autowired
    UsersRepository usersRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void 회원가입테스트(){
        Users users = new Users();
        users.setEmail("test3@gmail.com");
        users.setPassword("test@1234");
        Users user = usersRepository.save(users);
        System.out.println(user);
    }

    @Test
    void 회원전체조회테스트(){
        List<Users> usersList = usersRepository.findAll();
        System.out.println(usersList);
    }

    @Test
    void 회원일부조회테스트(){
        Users users = new Users();
        users.setEmail("test@gmail.com");
        users.setPassword("test@1234");
        Users users2 = usersRepository.findUsersByEmailAndPassword(users.getEmail(),users.getPassword());
        System.out.println(users2);
    }

}
