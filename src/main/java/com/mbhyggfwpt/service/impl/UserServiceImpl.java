package com.mbhyggfwpt.service.impl;

import com.mbhyggfwpt.mapper.UserMapper;
import com.mbhyggfwpt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
