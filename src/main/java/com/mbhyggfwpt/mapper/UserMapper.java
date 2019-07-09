package com.mbhyggfwpt.mapper;

import com.mbhyggfwpt.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    Integer isRegister(Map map);
    Integer login(Map map);
    Integer register(Map map);
    Integer updateUser(Map map);
    List<User> getUserList(Map map);

    User getUserBySerialnum(Map map);
}
