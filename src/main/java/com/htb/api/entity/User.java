package com.htb.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class User {
    private  int id;
    private String username;
    private String password;
    private String phone;
    private String tb_id;
    private String vip_level;
    private String create_time;
    private String modify_time;
    private String invitation_code;
    private String head_url;
}
