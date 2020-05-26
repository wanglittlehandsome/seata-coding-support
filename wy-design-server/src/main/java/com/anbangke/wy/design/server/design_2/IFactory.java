package com.anbangke.wy.design.server.design_2;

import com.anbangke.wy.design.server.design_3.IRoleDao;

/**
 * @author wangerxiao
 * @date 2020/5/26 11:16
 * @email 784665813@qq.com
 */
public interface IFactory {

    IUserDao createUserDao();


}
