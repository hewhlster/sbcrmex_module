package org.fjh;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.AppUserStart;
import org.fjh.dao.UserMapper;
import org.fjh.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Classname UserDaoTest
 * @Description TODO
 * @Date 2020/5/24 16:34
 * @Created by Jack
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = {AppUserStart.class})
public class UserDaoTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void selectAll(){
        System.out.println(
        userMapper.selectList(null)
        );
    }

    @Test
    public void selectUsersByRid(){
        System.out.println(
                userMapper.selectUsersByRid("1868e69b260411e990d23c970e4745df")
        );
    }

    @Test
    public void page(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        Page<User> page = new Page<>(2,2);

        IPage<User> ipage=userMapper.selectPage(page,queryWrapper);
        System.out.println(ipage.getRecords());
    }
}
