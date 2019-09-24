package com.chinasoft.oaspringboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.chinasoft.oaspringboot.dao.UsersDao;
import com.chinasoft.oaspringboot.domain.Users;
import com.chinasoft.oaspringboot.serice.UsersService;
import com.chinasoft.oaspringboot.util.JsonResult;
import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UsersController {
    @Autowired
    UsersDao usersMapper;
    @Autowired
    private StringRedisTemplate redisTpl;

    @Autowired
    private UsersService usersService;
    private Map<String, Object> modelMap = new HashMap<String, Object>();

    @ResponseBody
    @RequestMapping("/find")
    public Users findUsers() {
        Users users = usersMapper.SelectAllByName("aa");
        return users;
    }

    @GetMapping("/add")
    private Object add(String name) {
        modelMap.clear();
        if (name != null && !name.equals("")) {
            redisTpl.opsForValue().set("name", name);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @GetMapping("/get")
    private Object get() {
        modelMap.clear();
        String name = redisTpl.opsForValue().get("name");
        modelMap.put("success", true);
        modelMap.put("name", name);
        return modelMap;
    }

    @ResponseBody
    @RequestMapping("/findUserById")
    public Map<String, Object> findUserById() {
        Users user = usersService.SelectAllByName();
        Map<String, Object> result = new HashMap<>();
        result.put("uid", user.getId());
        result.put("uname", user.getName());
        return result;
    }

    @RequestMapping("/select")
    @ResponseBody
    public JsonResult<Users> selectInfoForUser(@RequestBody JSONObject params) {
        String name = params.getString("username");
        Users userInfo = usersMapper.SelectAllByName("aa");
        System.out.print(name);
        System.out.print(userInfo);
        return new JsonResult<Users>(0, "成功", userInfo);
    }
}
