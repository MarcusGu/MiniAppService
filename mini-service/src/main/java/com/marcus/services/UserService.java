package com.marcus.services;

import com.marcus.entity.po.User;

import java.util.List;

public interface UserService {

    public List<User> queryAllUser();

    public User queryUserById(String id);

    User queryUserByMobile(String mobile);

    User queryUserByOpenid(String openid);

    User queryUserByUserName(String username);

    public boolean updateUser(User user);

    public boolean updateUsers(List<User> users);

    public boolean insertUser(User user);

}
