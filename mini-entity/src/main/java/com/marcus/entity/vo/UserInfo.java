package com.marcus.entity.vo;

import com.marcus.entity.po.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    private int id;

    private String username;

    private String gender;

    private Date birthday;

    private String nickname;

    private String mobile;

    private String email;

    private String address;

    private String avatar;

    private String token;

    public UserInfo(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.gender = user.getGender();
        this.birthday = user.getBirthday();
        this.nickname = user.getNickname();
        this.mobile = user.getMobile();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.avatar = user.getAvatar();
    }
}
