package com.yoolee.snslogin.vo;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * create table users(
 *     seq int auto_increment primary key,
 *     email varchar(100) unique key,
 *     password varchar(100),
 *     create_dt timestamp default now()
 * );
 */
@Entity
@Data
public class Users {

    @Id
    @Column
    private int seq;

    @Column
    private String email;

    @Column
    private String password;

    @CreationTimestamp // default 현재 일자
    @Column
    private Date create_dt;
}
