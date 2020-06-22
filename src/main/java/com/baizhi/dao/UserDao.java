package com.baizhi.dao;

import com.baizhi.pojo.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;


/**
 *
 * 声明一个接口  来继承mongo方法
 */
@Component
public interface UserDao extends MongoRepository<User,Long> {

    //根据用户名查询用户
    User findByUsername(String username);
}
