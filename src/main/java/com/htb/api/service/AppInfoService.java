package com.htb.api.service;
import com.htb.api.entity.AppInfo;
import com.htb.api.entity.User;
import com.htb.api.mapper.AppInfoMapper;
import com.htb.api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService {

    @Autowired
    AppInfoMapper appInfoMapper;
    public AppInfo getAppInfo(String type){
        return appInfoMapper.getAppInfo(type);
    }
    public int insertApp(AppInfo appInfo){
        return appInfoMapper.insertApp(appInfo);
    }
}
