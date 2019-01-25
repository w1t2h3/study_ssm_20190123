package com.wang.controller;

import com.wang.domain.User;
import com.wang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @Autowired
    private IUserService userService;

//    用户登录
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public ModelAndView login(String username,String password){
        ModelAndView mv = new ModelAndView();
//       如果输入账号不为空
        if(username != null && !username.isEmpty()){
//          根据账户输入值在数据库表中查找此用户
            User userByName = userService.findUserByName(username);
//          如果用户存在
            if(userByName != null){
//                如果输入密码不为空
                if(password != null && !password.isEmpty()){
//                  校验输入的密码是否与表中账号对应的密码一致
//                  密码一致
                    if(password.equals(userByName.getPassword())){
                        mv.addObject("username",username);
                        mv.setViewName("ok");
                        return mv;
                    }
//                  密码不一致
                    mv.addObject("username",username);
                    mv.addObject("password",password);
                    mv.addObject("passwordError","密码错误");
                    mv.setViewName("forward:/login.jsp");
                    return mv;
                }
//                如果输入密码为空
                mv.addObject("username",username);
                mv.addObject("NullPasswordError","请输入密码");
                mv.setViewName("forward:/login.jsp");
                return mv;
            }
//          如果用户不存在
            mv.addObject("username",username);
            mv.addObject("notExistUsernameError","此账户名不存在");
            mv.setViewName("forward:/login.jsp");
            return mv;
        }
//      如果输入账号为空
        mv.addObject("NullUsernameError","请输入账户名");
        mv.setViewName("forward:/login.jsp");
        return mv;
    }


//    用户注册
    @RequestMapping("regist")
    public ModelAndView regist(String username,String password){
        ModelAndView mv = new ModelAndView();
//        校验账号是否存在
        User userByName = userService.findUserByName(username);
//        账号存在
        if(userByName != null){
            mv.addObject("existedUsernameError","此账户名已被注册");
            mv.addObject("username",username);
            mv.setViewName("forward:/regist.jsp");
            return mv;
        }
//        账号不存在
//        账号输入值为空
        if(username == null || username.isEmpty()){
            mv.addObject("NullUsernameError","请输入账户名");
            mv.setViewName("forward:/regist.jsp");
            return mv;
        }

//        账号包含空字符
        if(username.contains(" ")){
            mv.addObject("username",username);
            System.out.println("username: " + username);
            mv.addObject("usernameHasNullStringError","格式错误，不能包含空格");
            mv.setViewName("forward:/regist.jsp");
            return mv;
        }

//        密码输入值为空
        if (password == null || password.isEmpty()){
            mv.addObject("username",username);
            mv.addObject("NullPasswordError","请输入密码");
            mv.setViewName("forward:/regist.jsp");
            return mv;
        }

//        密码包含空字符
        if(password.contains(" ")){
            mv.addObject("username",username);
            mv.addObject("passwordHasNullStringError","格式错误，不能包含空格");
            mv.setViewName("forward:/regist.jsp");
            return mv;
        }


//        账号和密码都不为空，且都不包含空字符
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userService.addUser(user);
            mv.addObject("username",username);
            mv.addObject("okInfo","注册成功！");
            mv.setViewName("ok");
            return mv;

    }
}
