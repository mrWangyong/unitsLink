package com.mbhyggfwpt.service.impl;

import com.mbhyggfwpt.entity.User;
import com.mbhyggfwpt.mapper.UserMapper;
import com.mbhyggfwpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "user")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
   public Integer isRegister(Map map){
        return userMapper.isRegister(map);
   }

    @Override
    public Integer login(Map map){
        return userMapper.login(map);
    }


    @Override
    public Integer register(Map map){
        return userMapper.register(map);
    }

    @Override
    public Integer updateUser(Map map){
        return userMapper.updateUser(map);
    }

    @Override
    public List<User> getUserList(Map map){
        return userMapper.getUserList(map);
    }

    @Override
    public User getUserBySerialnum(Map map){
        return userMapper.getUserBySerialnum(map);
    }

}
