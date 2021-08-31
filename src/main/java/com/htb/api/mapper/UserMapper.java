package com.htb.api.mapper;

import com.htb.api.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserByPhone(String phone);
    int insertUser(User user);
    int upDateUser(User user);
    int deleteUserByPhone(String phone);

    User login(String phone,String password);

    User getUserByCode(String code);

    int upDateUserImageUrl(String phone, String imageUrl);
}
