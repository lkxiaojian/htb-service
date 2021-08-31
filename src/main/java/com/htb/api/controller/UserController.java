package com.htb.api.controller;

import com.htb.api.entity.User;
import com.htb.api.service.UserService;
import com.htb.api.util.DateUtil;
import com.htb.api.util.Response;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static com.htb.api.util.Contants.V1;

@RestControllerAdvice
@RequestMapping(V1)
public class UserController {
    @Value("${upload.headpath}")
    private String pafpath;
    @Autowired
    UserService userService;
    @RequestMapping(value = "getUserByPhone",method =RequestMethod.GET )
    public Response GetUser(@RequestParam String phone){
        User user = userService.getUserByPhone(phone);
        return new Response(200,user,"");
    }

    @RequestMapping(value = "login.do",method =RequestMethod.POST )
    public Response login(@RequestParam String phone,@RequestParam String password){
        User user = userService.login(phone,password);
        return new Response(200,user,"");
    }

    @RequestMapping("insertUser.do")
    public Response insertUser(@RequestParam String username,@RequestParam String password,@RequestParam String phone,@RequestParam String tb_id ) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setVip_level("1");
        String currentDateString = DateUtil.getCurrentTimeString();
        user.setCreate_time(currentDateString);
        user.setModify_time(currentDateString);
        user.setTb_id(tb_id);
        boolean isexit=true;
        String code="";
        while (isexit){
            code= String.valueOf ((int) ((Math.random() * 99999 + 10000)));
            int i=userService.getUserByCode(code);
            if(i==1){
                isexit=false;
            }
        }

        user.setInvitation_code(code);
        user.setUsername("user"+code);
        int i = userService.insertUser(user);
        Response response;
        if(i==1){
            response=  new Response(200, "添加用户成功");
        } else if(i==100){
            response=  new Response(300, "该用户已存在,请直接登入");
        }
        else  {
            response=  new Response(400, "添加用户失败");
        }
        return response;
    }


    @PostMapping("upDateUser")
    public Response upDateUser(@RequestBody User user) {
        int i = userService.upDateUser(user);
        Response response;
        if(i==1){
            response=  new Response(200, "添加用户成功");
        }else {
            response=  new Response(400, "添加用户失败");
        }
        return response;
    }

    @PostMapping("upDateUserImageUrl.do")
    public Response upDateUserImageUrl(@RequestParam(value = "file", required = false) MultipartFile file,@RequestParam String phone) {
if(file ==null){
    return new Response(400, "上传文件为空");
}

        try {
//            String savePath = DateUtil.formatDateTime(new Date(), "yyyy-MM-dd") + "_" + (int) (Math.random() * 100) + "/" + file.getOriginalFilename();
            String savePath = DateUtil.formatDateTime(new Date(), "yyyy-MM-dd") + "/" + file.getOriginalFilename();
            User user = userService.getUserByPhone(phone);
            if(user!=null){
                String head_url = user.getHead_url();
                head_url=head_url.replace("file","home/file/htb");
                File file1 = new File(head_url);
                if(file1.exists()){
                    file1.delete();
                }
            }

            String  path = pafpath + savePath;
            File f = new File(path);
            FileUtils.copyInputStreamToFile(file.getInputStream(), f);
            path=path.replace("/home/file/htb","/file");
            int i = userService.upDateUserImageUrl(phone,path);
            Response response;
            if(i==1){
                response=  new Response(200, path,"添加用户成功");
            }else {
                response=  new Response(400, "添加用户失败");
            }
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
       return  new Response(500, "上传文件失败");
    }

/**
 *  不对外提供
 */
//    @PostMapping("deleteUserByPhone")
//    public Response deleteUserByPhone(@RequestParam String phone){
//       int i = userService.deleteUserByPhone(phone);
//        Response response;
//        if(i==1){
//            response=  new Response(200, "删除用户成功");
//        }else {
//            response=  new Response(400, "删除用户失败");
//        }
//        return response;
//    }

}
