package com.mbhyggfwpt.mapper;

import java.util.Map;

public interface UserMapper {

    Integer isRegister(Map map);
    Integer login(Map map);
    Integer register(Map map);
}
