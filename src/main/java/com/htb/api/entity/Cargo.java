package com.htb.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import java.sql.Date;

@Data
@AllArgsConstructor
@Validated
/*
    商品POJO
 */
public class Cargo {
    private Integer id;
    private String name;
    private float price;
    private Date exp;   // time to expire
    private Boolean shortage;
}
