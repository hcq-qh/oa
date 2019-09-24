package com.chinasoft.oaspringboot.dao;

import com.chinasoft.oaspringboot.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UsersDao {

    Users SelectAllByName(String name);
}
