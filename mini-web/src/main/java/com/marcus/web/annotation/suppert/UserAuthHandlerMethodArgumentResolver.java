package com.marcus.web.annotation.suppert;

import com.marcus.common.service.UserTokenManager;
import com.marcus.web.annotation.UserAuth;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


public class UserAuthHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String APP_TOKEN = "APP_TOKEN";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Integer.class) && parameter.hasParameterAnnotation(UserAuth.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = webRequest.getHeader(APP_TOKEN);
        if (token == null || token.isEmpty()) {
            return null;
        }
        return UserTokenManager.getUserId(token);
    }
}
