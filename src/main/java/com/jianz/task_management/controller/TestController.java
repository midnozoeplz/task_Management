package com.jianz.task_management.controller;

import com.jianz.task_management.common.entities.SysUser;
import com.jianz.task_management.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jianz
 * @version 1.0
 * @Description
 * @Email jianz8153.gmail.com
 * @Date 2021/11/27 0:21
 */
@Controller
public class TestController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SysUserServiceImpl sysUserService;


//    @ResponseBody
//    @GetMapping("/user")
//    public SysUser getById(@RequestParam("id") int id){
//        return sysUserService.getUserById(id);
//    }

}
