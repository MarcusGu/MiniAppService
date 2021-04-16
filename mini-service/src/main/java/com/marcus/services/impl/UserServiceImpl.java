package com.marcus.services.impl;

import com.marcus.entity.po.User;
import com.marcus.dao.UserMapper;
import com.marcus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public User queryUserById(String id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public User queryUserByMobile(String mobile) {
        return userMapper.queryUserByMobile(mobile);
    }

    @Override
    public User queryUserByOpenid(String openid) {
        return userMapper.queryUserByOpenid(openid);
    }

    @Override
    public User queryUserByUserName(String username) {
        return userMapper.queryUserByUserName(username);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public boolean updateUsers(List<User> users) {
        return userMapper.updateUsers(users);
    }

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
