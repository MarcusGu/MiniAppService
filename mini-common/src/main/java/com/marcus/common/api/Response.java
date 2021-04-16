package com.marcus.common.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response {

    private int code;

    private String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Response error(int code, String message) {
        return new Response(code, message);
    }

    public static Response paramError() {
        return error(404, "参数异常");
    }

    public static Response loginOut() {
        return error(401, "请登陆账号");
    }

    public static Response loginFailure() {
        return error(402, "陆账失效");
    }

    public static Response systemError() {
        return error(500, "系统异常");
    }

}
