package com.anbangke.wy.design.server.design_2;

/**
 * @author wangerxiao
 * @date 2020/5/26 11:17
 * @email 784665813@qq.com
 */
public class MySQLFactory implements IFactory {

    @Override
    public IUserDao createUserDao() {
        return new MySQLUserDao();
    }
}
