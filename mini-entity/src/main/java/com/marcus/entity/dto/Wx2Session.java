package com.marcus.entity.dto;

import lombok.Data;

@Data
public class Wx2Session {

    private String openid;

    private String session_key;

    private String unionid;

    private String errcode;

    private String errmsg;

}
