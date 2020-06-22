package com.baizhi;

import com.baizhi.dao.UserDao;
import com.baizhi.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongdbApplicationTests {

    @Autowired
    private UserDao userDao;

    /**
     *
     * 添加方法
     */
    @Test
    public void save() {

        User user=new User();
        user.setId(1L);
        user.setUsername("李四");
        user.setSex("男");
        userDao.save(user);
    }


    /**
     *
     * 修改方法
     */
    @Test
    public void update() {

        User user=new User();
        user.setId(1L);
        user.setUsername("李四1");
        user.setSex("男1");

        userDao.save(user);
    }


    /**
     *
     * 批量添加数据
     *
     */
    @Test
    public void addAll(){
        for (int i=1;i<=10;i++){
            User user =new User();
            user.setId((long) i);
            user.setSex(i%2==0? "男":"女");
            user.setUsername("张三"+i);
            userDao.save(user);
        }
    }


    /**
     *
     * 查询全部
     *
     */
    @Test
    public void findAll(){
        List<User> userList = userDao.findAll();
        userList.forEach(user->{
            System.out.println(user);
        });
    }


    /**
     *
     * 分页查询
     *
     */
    @Test
    public void findAllByPage(){
        //指定排序方式
        Sort sort = Sort.by(Sort.Order.desc("id"));
        //封装分页条件
        Pageable pageRequest = PageRequest.of(1, 5,sort);

        Page<User> page = userDao.findAll(pageRequest);
        page.forEach(user->{
            System.out.println(user);
        });
    }


    //根据用户名查询用户
    @Test
    public void findUserByUsername(){

        User user1=new User();

        user1.setUsername("张三1");

        User user = userDao.findByUsername(user1.getUsername());

        System.out.println(user.toString());

    }



}
