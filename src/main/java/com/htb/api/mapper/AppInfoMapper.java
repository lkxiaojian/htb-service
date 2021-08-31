package com.htb.api.mapper;

import com.htb.api.entity.AppInfo;
import com.htb.api.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AppInfoMapper {
    AppInfo getAppInfo(String type);
    int insertApp(AppInfo user);
}
