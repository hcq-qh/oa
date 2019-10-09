package com.chinasoft.oaspringboot.controller;

import com.chinasoft.oaspringboot.Mapper.EmpMapper;
import com.chinasoft.oaspringboot.entity.Emp;
import com.chinasoft.oaspringboot.serice.EmpService;
import com.chinasoft.oaspringboot.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpController {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpService empService;

    @RequestMapping("/empmain")
    @ResponseBody
    public JsonResult<List<Emp>> selectEmp(){
        List<Emp> list = new ArrayList<Emp>();
        list = empService.selectAll();
//        for (Emp emp:list
//             ) {
//            System.out.print(emp.getEname());
//        }
        return new JsonResult<List<Emp>>(0, "成功", list);
    }

    @RequestMapping("/delectemp")
    public String delectEmp(@RequestParam("id") int id){
        int i=empService.deleteByPrimaryKey(id);
        return "redirect:/html/emp/emain.html";
    }
}
