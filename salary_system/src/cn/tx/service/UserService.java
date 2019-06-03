package cn.tx.service;

import cn.tx.domain.User;

public interface UserService {

    /**
     * 登录的方法
     * @param username
     * @param password
     * @return
     */
    public User login(String username,String password);

}
