package com.marcus.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

    private String username;

    private String password;

    private String nickname;

    private String mobile;

    private String email;

    private String gender;

    private String avatar;

    private String code;

}
