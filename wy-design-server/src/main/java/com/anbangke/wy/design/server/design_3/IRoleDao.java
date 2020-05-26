package com.anbangke.wy.design.server.design_3;


/**
 * @author wangerxiao
 * @date 2020/5/26 11:15
 * @email 784665813@qq.com
 */
public interface IRoleDao {

    void addRole(Role role);

    void removeRole(Role role);

    Role getRole(String name);

}
