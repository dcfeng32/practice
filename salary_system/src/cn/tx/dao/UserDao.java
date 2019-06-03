package cn.tx.dao;

import cn.tx.domain.User;


public interface UserDao {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password);

}
