package com.chinasoft.oaspringboot.serice;

import com.chinasoft.oaspringboot.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    int deleteByPrimaryKey(Integer id);
    int insert(User record);
    User selectByPrimaryKey(Integer id);
    List<User> selectAll();
    int updateByPrimaryKey(User record);
    User loginByUser(@Param("name") String name, @Param("password") String password);
}
