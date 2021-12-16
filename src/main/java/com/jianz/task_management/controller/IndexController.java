package com.jianz.task_management.controller;

import com.jianz.task_management.common.entities.SysUtilIndex;
import com.jianz.task_management.common.entities.SysLocation;
import com.jianz.task_management.common.entities.SysUser;
import com.jianz.task_management.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Jianz
 * @Description
 * @Email jianz8153.gmail.com
 * @Date 2021/11/25 11:18
 */
@Controller
public class IndexController {

    @Autowired
    SysUserServiceImpl sysUserService;

    /**
     * @author Jianz
     * @Description 来登录页和一些进主页的拦截
     * @Return
     * @Date 2021/11/25 11:33
     */
    @GetMapping(value = {"/", "/login", "/login.html"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/main")
    public String main( SysUser sysUser, HttpSession session, Model model) {
        //  进行登录验证，数据库中是否有该用户
        if (sysUserService.hasUser(sysUser.getUsername(), sysUser.getPassword()) > 0) {
            session.setAttribute("loginUser", sysUser);
            return "redirect:/main.html";
        } else if (sysUserService.WrongPWD(sysUser.getUsername()) > 0) {
            model.addAttribute("msg", "密码输入错误");
            return "login";
        } else {
            model.addAttribute("msg", "账号输入错误或未注册");
            return "login";
        }

    }

    /**
     * @author Jianz
     * @Description 去main页面
     * @Return
     * @Date 2021/11/25 22:57
     */
    @GetMapping(value = {"/main.html"})
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {

            return "main";
        } else {
            model.addAttribute("msg", "请重新登录");
            return "login";
        }

    }
     /**
      * @author Jianz
      * @Description
      * @Return
      * @Date 2021/12/4 1:03
      */
     @PostMapping("/location")
     public String demo( SysLocation location,HttpSession session) {
         Object loginUser = session.getAttribute("loginUser");
        return "main";
     }

    /**
     * @author Jianz
     * @Description
     * @Return
     * @Date 2021/12/15 19:17
     */

    @ResponseBody
    @RequestMapping("/a1")
    public int getLocation(SysLocation location){
        int index1 = SysUtilIndex.getLocationIndex(location.getLocationName1());
        int index2 = SysUtilIndex.getLocationIndex(location.getLocationName2());
        System.out.println(index1 + "  " + index2);
        if(index1 != -1 && index2 != -1) {
            return SysUtilIndex.minLength(index1, index2);
        }
        else return -1;
    }
}
