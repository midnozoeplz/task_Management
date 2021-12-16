package com.jianz.task_management.mapper;

import com.jianz.task_management.common.entities.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jianz
 * @version 1.0
 * @Description
 * @Email jianz8153.gmail.com
 * @Date 2021/11/27 0:06
 */

@Mapper
public interface SysUserMapper {
    int hasUser(String username, String password);

    void insert(SysUser user);

    int wrongPWD(String username);
}
