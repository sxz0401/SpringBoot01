package cn.bdqn.service;

import cn.bdqn.pojo.user;
import cn.bdqn.util.PageBean;

import java.util.List;

public interface userService {

    PageBean<user> list(String username, int currPageNo, int pageSize);

    int getuserid(String username);

    void delete(int id);

    user getus(int id);

    void update(user u);

    void add(user u);
}
