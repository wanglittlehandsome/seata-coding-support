package com.anbangke.wy.design.server.design_2;

/**
 * @author wangerxiao
 * @date 2020/5/26 11:15
 * @email 784665813@qq.com
 */
public interface IUserDao {

    void addUser(User user);

    void removeUser(User user);

    User getUser(String name);

}
