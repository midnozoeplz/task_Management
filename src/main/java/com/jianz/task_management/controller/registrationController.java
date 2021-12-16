package com.jianz.task_management.controller;

import com.jianz.task_management.common.entities.SysUser;
import com.jianz.task_management.service.SysUserService;
import com.jianz.task_management.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Jianz
 * @version 1.0
 * @Description 对注册页的控制
 * @Email jianz8153.gmail.com
 * @Date 2021/11/27 23:50
 */

@Controller
public class registrationController {
    @Autowired
    SysUserServiceImpl sysUserService;

    // 去注册页
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/login")
    public String saveUser(SysUser sysUser, Model model){
      if(sysUser.getUsername().equals("")){
//            model.addAttribute("msg","用户名不能为空");
            return "registration";
        }
        if(sysUser.getPassword().equals("")) {
//            model.addAttribute("msg","密码不能为空");
            return "registration";
        }
        if(sysUser.getEmail().equals("")){
//            model.addAttribute("msg","邮箱不能为空");
            return "registration";
        }

        if(!sysUser.getPassword().equals(sysUser.getEnsurePassword())){
            model.addAttribute("msg","两次密码不同");
            return "registration";
        }

        sysUserService.saveUser(sysUser);
        return "redirect:/login";
    }

}
