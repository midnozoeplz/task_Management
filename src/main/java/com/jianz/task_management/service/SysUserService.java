package com.jianz.task_management.service;

import com.jianz.task_management.common.entities.SysUser;
/**
 * @author Jianz
 * @version 1.0
 * @Description
 * @Email jianz8153.gmail.com
 * @Date 2021/11/27 0:24
 */
public interface SysUserService {
       /**
        * @author Jianz
        * @Description  是否含有此用户
        * @Return
        * @Date 2021/12/3 19:28
        */
      int hasUser(String username,String password);

        /**
         * @author Jianz
         * @version 1.0
         * @Description 保存用户
         * @Return
         * @Date 2021/11/28 0:49
         */
        void saveUser(SysUser user);

      /**
       * @author Jianz
       * @version 1.0
       * @Description  数据库中是否含有此用户名
       * @Email jianz8153.gmail.com
       * @Date 2021/11/27 0:24
       */
        int WrongPWD(String username);
        }



