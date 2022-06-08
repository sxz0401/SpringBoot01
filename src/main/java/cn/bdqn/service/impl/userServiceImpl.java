package cn.bdqn.service.impl;

import cn.bdqn.dao.userMapper;
import cn.bdqn.pojo.user;
import cn.bdqn.service.userService;
import cn.bdqn.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userServiceImpl implements userService{

    @Resource
    private userMapper userM;

    public userMapper getUserM() {
        return userM;
    }

    public void setUserM(userMapper userM) {
        this.userM = userM;
    }

    @Override
    public PageBean<user> list( String username, int currPageNo, int pageSize) {
        PageBean<user> page = new PageBean<user>();
        page.setCurrPageNo(currPageNo);
        page.setPageSize(pageSize);
        int totalcount = userM.getuserid(username);
        page.setTotalCount(totalcount);
        int totalpagecount = totalcount%pageSize == 0?totalcount/pageSize:totalcount/pageSize+1;
        page.setTotalPageCount(totalcount);
        List<user> list = userM.list(username,(currPageNo-1)*pageSize,pageSize);
        page.setLists(list);
        return page;
    }

    @Override
    public int getuserid(String username) {
        return userM.getuserid(username);
    }

    @Override
    public void delete(int id) {
        userM.delete(id);
    }

    @Override
    public user getus(int id) {
        return userM.getus(id);
    }

    @Override
    public void update(user u) {
        userM.update(u);
    }

    @Override
    public void add(user u) {
        userM.add(u);
    }
}
