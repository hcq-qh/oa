package com.chinasoft.oaspringboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinasoft.oaspringboot.Mapper.UserMapper;
import com.chinasoft.oaspringboot.entity.User;
import com.chinasoft.oaspringboot.serice.UserService;
import com.chinasoft.oaspringboot.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

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

    private Map<String, Object> modelmap = new HashMap<String, Object>();

    @RequestMapping("/userlogin")
    @ResponseBody
//    public JsonResult<User> selectInfoForUser(@RequestBody JSONObject params) {
    public JsonResult<User> selectInfoForUser(@RequestParam("username") String name,@RequestParam("password") String password) {
//        String name = params.getString("username");
//        String password = params.getString("password");
        User u = userService.loginByUser(name, password);
//        System.out.print(name);
        return new JsonResult<User>(0, "成功", u);
    }

    @RequestMapping("/userregister")
    @ResponseBody
    public JsonResult<Integer> registerUser(@RequestParam("username") String name,@RequestParam("password") String password) {
//        String name = params.getString("username");
//        String password = params.getString("password");
          User u = new User(name,password);
          int i = userMapper.insert(u);
//        System.out.print(name);
        return new JsonResult<Integer>(0, "成功", i);
    }
}
