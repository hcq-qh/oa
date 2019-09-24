package com.chinasoft.oaspringboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinasoft.oaspringboot.Mapper.UserMapper;
import com.chinasoft.oaspringboot.entity.User;
import com.chinasoft.oaspringboot.serice.UserService;
import com.chinasoft.oaspringboot.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private Map<String,Object> modelmap = new HashMap<String, Object>();

    @RequestMapping("/sss")
    @ResponseBody
    public JsonResult<User> selectInfoForUser(@RequestBody JSONObject params) {
        String name = params.getString("username");
        User userInfo = userMapper.selectByPrimaryKey(1);
        System.out.print(name);
        System.out.print(userInfo);
        return new JsonResult<User>(0, "成功", userInfo);
    }

}
