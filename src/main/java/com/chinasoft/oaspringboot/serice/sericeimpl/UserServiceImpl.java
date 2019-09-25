package com.chinasoft.oaspringboot.serice.sericeimpl;

import com.chinasoft.oaspringboot.Mapper.UserMapper;
import com.chinasoft.oaspringboot.entity.User;
import com.chinasoft.oaspringboot.serice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        String key = "user_" + "aa";
        ValueOperations<String, User> operations=redisTemplate.opsForValue();

        boolean haskey=redisTemplate.hasKey(key);
        if (haskey) {
            User user = operations.get(key);
//            System.out.println("==========从缓存中获得数据=========");
//            System.out.println(user.getName());
//            System.out.println("==============================");
            return user;
        } else {
            User user = userMapper.selectByPrimaryKey(1);
//            System.out.println("==========从数据表中获得数据=========");
//            System.out.println(user.getName());
//            System.out.println("==============================");

            // 写入缓存
            operations.set(key, user,5, TimeUnit.HOURS);
            return user;
        }
    }

    @Override
    public List<User> selectAll() {
        return null;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }

    @Override
    public User loginByUser(String name, String password) {
        String key = "user_login_" + name;
        ValueOperations<String, User> operations=redisTemplate.opsForValue();

        boolean hasKey=redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);
//            System.out.println("==========从缓存中获得数据=========");
//            System.out.println(user.getName());
//            System.out.println("==============================");
            return user;
        } else {
            User user = userMapper.selectByPrimaryKey(1);
//            System.out.println("==========从数据表中获得数据=========");
//            System.out.println(user.getName());
//            System.out.println("==============================");
            // 写入缓存
            operations.set(key, user,5, TimeUnit.HOURS);
            return user;
        }
    }
}
