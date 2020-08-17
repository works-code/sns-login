package com.yoolee.snslogin.repository;

import com.yoolee.snslogin.vo.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findUsersByEmailAndPassword(String email, String password);

    Users findUsersByEmail(String email);

}
