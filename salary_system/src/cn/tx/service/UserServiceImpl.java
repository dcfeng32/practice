package cn.tx.service;

import cn.tx.dao.UserDao;
import cn.tx.dao.UserDaoImpl;
import cn.tx.domain.User;
import cn.tx.utils.MD5Utils;

/**
 * 用户业务层模块实现类
 */
public class UserServiceImpl implements UserService{

    private UserDao userDao = new UserDaoImpl();

    /**
     * 用户登录的功能
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        // 先对密码做加密处理，加密的算法使用MD5加密方式
        String newpwd = MD5Utils.encrypt(password);
        // 调用持久层，查询数据库
        return userDao.login(username,newpwd);
    }

}

















