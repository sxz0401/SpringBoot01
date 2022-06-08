package cn.bdqn.controller;

import cn.bdqn.pojo.user;
import cn.bdqn.service.userService;
import cn.bdqn.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class userController {

    @Resource
    private userService userS;

    public userService getUserS() {
        return userS;
    }

    public void setUserS(userService userS) {
        this.userS = userS;
    }

    @RequestMapping("list")
    public String list(Model model,@RequestParam(value = "currPageNo",defaultValue = "1", required = false) int currPageNo,
                       @RequestParam(value = "username", required = false) String username){
        PageBean<user> userlist = userS.list(username,currPageNo,1);
        model.addAttribute("userlist",userlist);
        return "list";
    }
    @RequestMapping("delete")
    public String delete(int id){
        userS.delete(id);
        return "redirect:/list";
    }

    @RequestMapping("toupdate")
    public String toupdate(int id , Model model){
        user us = userS.getus(id);
        model.addAttribute("us",us);
        return "update";
    }
    @RequestMapping("update")
    public String update(user u){
        userS.update(u);
        return "redirect:/list";
    }
    @RequestMapping("add")
    public String add(user u){
        userS.add(u);
        return "redirect:/list";
    }
}
