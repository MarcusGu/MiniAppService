package com.marcus.common.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WebResponse<T> extends Response {

    private T data;

    public WebResponse(T data) {
        super(200, "请求成功");
        this.data = data;
    }

    public WebResponse(int code, String message, T data) {
        super(code, message);
        this.data = data;
    }

    public WebResponse(int code, String message) {
        super(code, message);
    }

}
