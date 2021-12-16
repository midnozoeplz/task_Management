package com.jianz.task_management.service.impl;

import com.jianz.task_management.common.entities.SysUser;
import com.jianz.task_management.mapper.SysUserMapper;
import com.jianz.task_management.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jianz
 * @version 1.0
 * @Description
 * @Email jianz8153.gmail.com
 * @Date 2021/11/27 0:28
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public int hasUser(String username , String password) {
        return sysUserMapper.hasUser(username,password);
    }

    @Override
    public void saveUser(SysUser user) {
        sysUserMapper.insert(user);
    }

    @Override
    public int WrongPWD(String username) {
        return sysUserMapper.wrongPWD(username);
    }
}
