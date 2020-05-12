package org.fjh.dao;

import org.fjh.entity.User;
import org.fjh.entity.UserExample;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper extends BaseMapper<User, UserExample> {

    public User selectUserRoleByPk(String id);

    public List<User> selectUsersByRid(String rid);

    public User selectUserRoleById(String uid);
}