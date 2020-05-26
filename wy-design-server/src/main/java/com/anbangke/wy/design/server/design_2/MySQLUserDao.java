package com.anbangke.wy.design.server.design_2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/26 11:17
 * @email 784665813@qq.com
 */
@Slf4j
public class MySQLUserDao implements IUserDao {


    @Override
    public void addUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }

    @Override
    public User getUser(String name) {
        User user = new User(name, this.getClass().getSimpleName());
        log.info("user:{}", user);
        return user;
    }
}
