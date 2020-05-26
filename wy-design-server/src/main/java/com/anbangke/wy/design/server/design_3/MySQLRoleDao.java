package com.anbangke.wy.design.server.design_3;

import com.anbangke.wy.design.server.design_2.IUserDao;
import com.anbangke.wy.design.server.design_2.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/26 11:17
 * @email 784665813@qq.com
 */
@Slf4j
public class MySQLRoleDao implements IRoleDao {


    @Override
    public void addRole(Role role) {

    }

    @Override
    public void removeRole(Role role) {

    }

    @Override
    public Role getRole(String name) {
        Role role = new Role(name, this.getClass().getSimpleName());
        log.info("role:{}", role);
        return role;
    }


}
