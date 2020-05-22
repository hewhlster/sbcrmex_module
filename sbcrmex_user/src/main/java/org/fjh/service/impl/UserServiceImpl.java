package org.fjh.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.fjh.dao.UserMapper;
import org.fjh.entity.User;
import org.fjh.entity.UserExample;
import org.fjh.service.IUserService;
import org.fjh.util.MD5Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        super.setBaseMapper(userMapper);
        this.userMapper = userMapper;
    }

    @Override
    public User login(String uid, String upass) {
        //对密码进行MD5处理
        try {
            upass = MD5Helper.md5(upass);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //准备查询参数
        UserExample example = new UserExample();
        UserExample.Criteria criteria =  example.createCriteria();

        criteria.andCodeEqualTo(uid);
        criteria.andPasswordEqualTo(upass);

        int row =  userMapper.selectByExample(example).size();
        logger.info("row=" + row);
        if (row > 0) {
            return userMapper.selectByExample(example).get(0);
        } else {
            return null;
        }
    }

    @Override
    public User getUserByUname(String uname) {
        //准备查询参数
        UserExample example = new UserExample();
        UserExample.Criteria criteria =  example.createCriteria();

        criteria.andNameEqualTo(uname);
        return userMapper.selectByExample(example).get(0);
    }

    @Override
    public List<User> getAll() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria =  example.createCriteria();
        return userMapper.selectByExample(example);
    }


    @Override
    public int add(User user) {
        // TODO Auto-generated method stub
        //将密码进行MD5处理
        String password = user.getPassword();
        try {
            password = MD5Helper.md5(password);
            user.setPassword(password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int ret = userMapper.insertSelective(user);
        return ret;
    }

    @Override
    public List<User> findByUserCodeOrRid(String usercode, String rid) {
        // TODO Auto-generated method stub
        return null;//userMapper.get(usercode, rid);
    }

    @Override
    public int modifyPassword(String usercode, String oldpass, String newpass) {
        //准备查询参数
        UserExample example = new UserExample();
        UserExample.Criteria criteria =  example.createCriteria();

        criteria.andCodeEqualTo(usercode);
        criteria.andPasswordEqualTo(oldpass);

        int row =  userMapper.selectByExample(example).size();

        if (row == 0)
            return 0;//原始密码错误

        User user = new User();
        user.setCode(usercode);
        user.setPassword(newpass);

        example = new UserExample();
        criteria =  example.createCriteria();

        criteria.andPasswordEqualTo(newpass);


        //修改密码
        return userMapper.updateByExampleSelective(user,example);
    }

    @Override
    public User findUserRolesById(String uid) {

        return null;
    }


    @Cacheable(value = "findByRoleCode", key = "#roleid")
    public List<User> findByRoleCode(String roleid) {
        Map<String, Object> params = null;
        if (null != roleid) {
            params = new HashMap<String, Object>();
            params.put("users_rid", roleid);
        }
        return null;//userMapper.paramsList(params);
    }


    @Override
    public int updateUser(User user) {
        // TODO Auto-generated method stub
        String password = user.getPassword();
        try {
            password = MD5Helper.md5(password);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        user.setPassword(password);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(String id) {
        // TODO Auto-generated method stub
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getUserById(String id) {
        // TODO Auto-generated method stub
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User find(String uuid, String upass) {
        // TODO Auto-generated method stub
        return this.login(uuid, upass);
    }


}
