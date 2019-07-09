package com.mbhyggfwpt.service;

import com.mbhyggfwpt.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service(value = "user")
public interface UserService {
    Integer isRegister(Map map);
    Integer login(Map map);
    Integer register(Map map);
    Integer updateUser(Map map);
    List<User> getUserList(Map map);
    User getUserBySerialnum(Map map);
}
