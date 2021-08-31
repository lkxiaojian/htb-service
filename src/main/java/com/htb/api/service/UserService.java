package com.htb.api.service;
import com.htb.api.entity.User;
import com.htb.api.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public User getUserByPhone(String phone){
        return userMapper.getUserByPhone(phone);
    }

    public User login(String phone,String paw){
        return userMapper.login(phone,paw);
    }


    public int insertUser(User user){
        User userByPhone = userMapper.getUserByPhone(user.getPhone());
        if(userByPhone!=null){
            return 100;
        }
        return userMapper.insertUser(user);
    }

    public int deleteUserByPhone(String phone){
        return userMapper.deleteUserByPhone(phone);
    }

    public int upDateUser(User user){
        return userMapper.upDateUser(user);
    }

    public int getUserByCode(String code) {
        User userByPhone = userMapper.getUserByCode(code);
        if(userByPhone!=null){
            return 100;
        }
        return 1;
    }

    public int upDateUserImageUrl(String phone, String imageUrl) {
       int i= userMapper.upDateUserImageUrl(phone,imageUrl);
        return i;
    }
}
