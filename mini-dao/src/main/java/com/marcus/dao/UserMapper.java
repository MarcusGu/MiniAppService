package com.marcus.dao;

import com.marcus.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> queryAllUser();

    User queryUserById(@Param("id") String id);

    User queryUserByUserName(@Param("username") String username);

    User queryUserByMobile(@Param("mobile") String mobile);

    User queryUserByOpenid(@Param("openid") String openid);

    boolean updateUser(User user);

    boolean updateUsers(List<User> users);

    boolean insertUser(User user);
}
