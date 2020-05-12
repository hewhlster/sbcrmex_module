package org.fjh.dao;


import org.apache.ibatis.annotations.Param;
import org.fjh.entity.Resource;
import org.fjh.entity.Role;
import org.fjh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface JackDaoAuthenticationUserMapper  {

    public  User findUserByEmailOrMoblie(@Param("email") String email, @Param("moblie")String moblie);

    public List<Role> findRolesByUid(@Param("uid")String uid);

    public List<Role> findRolesAll();

    public List<Resource> findResourcesByRid(@Param("rid")String rid);


}
