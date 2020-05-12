package org.fjh.service;

import org.fjh.entity.User;
import org.fjh.util.PageEntity;

import java.util.List;

public interface IUserService extends IBaseService<User> {
    public User login(String uuid, String upass);

    public User find(String uuid, String upass);

    public User getUserByUname(String uname);

    public User getUserById(String id);

    public List<User> getAll();
    //public List<User> Pager(int listCount,int currentPage);

    public int add(User user);

    public int updateUser(User user);

    public int deleteUser(String id);


    public List<User> findByUserCodeOrRid(String usercode, String rid);

    public List<User> findByRoleCode(String roleid);

    /**
     * 修改密码
     *
     * @param usercode
     * @param oldpass
     * @param newpass
     * @return 0:原密码不对 1：成功
     */

    public int modifyPassword(String usercode, String oldpass, String newpass);



}

