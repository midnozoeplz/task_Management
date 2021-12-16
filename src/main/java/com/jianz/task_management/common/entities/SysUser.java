package com.jianz.task_management.common.entities;

import lombok.Data;

/**
 * @author Jianz
 * @version 1.0
 * @Description
 * @Email jianz8153.gmail.com
 * @Date 2021/11/25 17:20
 */
@Data
public class SysUser {
    private int id;
    private String username;
    private String password;
    private String ensurePassword;
    private String email;
}
