package com.chinasoft.oaspringboot.serice.sericeimpl;

import com.chinasoft.oaspringboot.dao.UsersDao;
import com.chinasoft.oaspringboot.domain.Users;
import com.chinasoft.oaspringboot.serice.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Users SelectAllByName() {
        String key = "user_" + "aa";
        ValueOperations<String, Users> operations=redisTemplate.opsForValue();

        boolean haskey=redisTemplate.hasKey(key);
        if (haskey) {
            Users user = operations.get(key);
            System.out.println("==========从缓存中获得数据=========");
            System.out.println(user.getName());
            System.out.println("==============================");
            return user;
        } else {
            Users user = usersDao.SelectAllByName("aa");
            System.out.println("==========从数据表中获得数据=========");
            System.out.println(user.getName());
            System.out.println("==============================");

            // 写入缓存
            operations.set(key, user,5, TimeUnit.HOURS);
            return user;
        }

    }
}
