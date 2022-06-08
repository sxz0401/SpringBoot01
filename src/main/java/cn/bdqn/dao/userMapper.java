package cn.bdqn.dao;

import cn.bdqn.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface userMapper {
    List<user> list(@Param("username") String username, @Param("currPageNo") int currPageNo, @Param("pageSize") int pageSize);

    int getuserid(@Param("username") String username);

    void delete(int id);

    user getus(int id);

    void update(user u);

    void add(user u);
}
