package com.anbangke.wy.design.server.design_2;

/**
 * @author wangerxiao
 * @date 2020/5/26 11:14
 * @email 784665813@qq.com
 */
public class Client {

    public static void main(String[] args) {
        IFactory factory = new MySQLFactory();
        IUserDao userDao = factory.createUserDao();
        userDao.getUser("admin");

    }
}
