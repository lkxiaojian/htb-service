package com.htb.api.controller;

import com.htb.api.entity.AppInfo;
import com.htb.api.service.AppInfoService;
import com.htb.api.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.htb.api.util.Contants.V1;

@RestController
@RequestMapping(V1)
public class AppInfoController {

    @Autowired
    AppInfoService appInfoService;
    @RequestMapping(value = "getAppInfo.do",method = RequestMethod.GET )
    public Response GetUser(@RequestParam String type){
        AppInfo user = appInfoService.getAppInfo(type);
        return new Response(200,user,"");
    }

}
