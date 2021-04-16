package com.marcus.entity.po;

import com.marcus.entity.dto.LoginParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;

    private String username;

    private String password;

    private String gender;

    private Date birthday;

    private String nickname;

    private String mobile;

    private String email;

    private String address;

    private String avatar;

    private String openid;

    private String sessionKey;

    private String status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private LocalDateTime lastLoginTime;

    private String lastLoginIp;


    public User(LoginParam param) {
        this.username = param.getUsername();
        this.username = param.getUsername();
        this.password = param.getPassword();
        this.gender = param.getGender();
        this.nickname = param.getNickname();
        this.mobile = param.getMobile();
        this.email = param.getEmail();
        this.avatar = param.getAvatar();
    }

    public static User fromLoginParam(LoginParam param) {
        return new User(param);
    }

}
