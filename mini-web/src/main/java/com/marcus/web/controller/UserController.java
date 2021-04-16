package com.marcus.web.controller;

import com.marcus.common.api.Response;
import com.marcus.common.api.WebResponse;
import com.marcus.common.http.HttpRequest;
import com.marcus.common.service.UserTokenManager;
import com.marcus.common.util.IpUtil;
import com.marcus.common.util.JacksonUtil;
import com.marcus.common.util.RegexUtil;
import com.marcus.common.wx.Contract;
import com.marcus.entity.po.User;
import com.marcus.entity.dto.LoginParam;
import com.marcus.entity.vo.UserInfo;
import com.marcus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/error")
    public Response error() {
        return Response.error(404, "toke失效");
    }

    @GetMapping("/query")
    public Response queryAllUser() {
        return new WebResponse<>(userService.queryAllUser());
    }

    @GetMapping("/query/{id}")
    public User queryUserById(@PathVariable("id") String id) {

        return userService.queryUserById(id);
    }

    @PostMapping("/update")
    public boolean updateUser(User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/insert")
    public boolean insertUser(User user) {
        return userService.insertUser(user);
    }

    @PostMapping("/register")
    public Response register(@RequestBody LoginParam body, HttpServletRequest request) {

        User user = userService.queryUserByMobile(body.getMobile());
        if (user != null) {
            return Response.error(402, "手机号已注册");
        }

        if (!RegexUtil.isMobileSimple(body.getMobile())) {
            return Response.error(402, "手机号码格式不正确");
        }

        user = User.fromLoginParam(body);

        String wx2session = HttpRequest.getInstance().get(Contract.createWeChartSnsUrl(body.getCode()));
        String sessionKey = JacksonUtil.parseString(wx2session, "session_key");
        String openid = JacksonUtil.parseString(wx2session, "openid");

        if (!StringUtils.isEmpty(openid)) {
            user.setOpenid(openid);
            user.setSessionKey(sessionKey);
        }

        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setLastLoginTime(LocalDateTime.now());
        user.setLastLoginIp(IpUtil.getIpAddr(request));

        userService.insertUser(user);

        user = userService.queryUserByMobile(user.getMobile());

        String token = UserTokenManager.generateToken(user.getId());

        UserInfo info = new UserInfo(user);
        info.setToken(token);

        return new WebResponse(info);
    }

    @PostMapping("/login")
    public Response login(@RequestBody LoginParam body, HttpServletRequest request) {
        User user = userService.queryUserByMobile(body.getMobile());
        if (null == user) {
            return Response.error(402, "账号不存在");
        }
        if (!user.getPassword().equals(body.getPassword())) {
            return Response.error(402, "密码错误");
        }

        user.setLastLoginTime(LocalDateTime.now());
        user.setLastLoginIp(IpUtil.getIpAddr(request));

        String wx2session = HttpRequest.getInstance().get(Contract.createWeChartSnsUrl(body.getCode()));
        String sessionKey = JacksonUtil.parseString(wx2session, "session_key");
        String openid = JacksonUtil.parseString(wx2session, "openid");

        if (!StringUtils.isEmpty(openid)) {
            user.setOpenid(openid);
            user.setSessionKey(sessionKey);
        }
        userService.updateUser(user);
        UserInfo info = new UserInfo(user);
        info.setToken(UserTokenManager.generateToken(user.getId()));

        return new WebResponse<>(info);
    }
}
