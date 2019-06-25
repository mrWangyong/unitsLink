package com.mbhyggfwpt.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service(value = "user")
public interface UserService {

    Integer isRegister(Map map);
    Integer login(Map map);
    Integer register(Map map);



}
