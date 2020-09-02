package com.htsc.hittraining.web.register_i_and_log_in.Controller;

import Entity.User;
import com.htsc.hittraining.web.register_i_and_log_in.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author liubi
 * @date 2020-09-02 11:35
 **/
@Controller
public class LogInAndRegisterCtl {
    @Autowired
    private UserDao userDao;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView,  User user){

        String userName = user.getUserName();
        String password = user.getPassword();

        User userInDB = userDao.findByName(userName);
        if(userInDB==null){
            modelAndView.addObject("error","无此用户！");
            modelAndView.setViewName("login");
            return modelAndView;
        }
        if(!userInDB.getPassword().equals(password)){
            modelAndView.addObject("error","密码错误！");
            modelAndView.setViewName("login");
            return modelAndView;
        }

        modelAndView.setViewName("index");
        modelAndView.addObject("userName",userName);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView){
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(ModelAndView modelAndView,  User user){

        String userName = user.getUserName();
        String password = user.getPassword();
        User userInDB = userDao.findByName(userName);

        if(userInDB!=null){
            modelAndView.addObject("error","用户已存在！");
            modelAndView.setViewName("register");
            return modelAndView;
        }

        int res = userDao.insert(user.getUserName(),user.getPassword());

        if (res==0){
            modelAndView.addObject("error","注册失败！请重试");
            modelAndView.setViewName("register");
            return modelAndView;
        }else {
            modelAndView.setViewName("index");
            modelAndView.addObject("userName",userName);
            return modelAndView;
        }
    }
}
