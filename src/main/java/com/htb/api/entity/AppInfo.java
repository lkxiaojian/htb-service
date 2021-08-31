package com.htb.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class AppInfo {
    private  int id;
    private int version;
    private  String createDate;
    private String name;
    private String updateInfo;
    private String url;
    private String type;
}
