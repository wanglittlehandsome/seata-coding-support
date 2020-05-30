package com.anbangke.userserver.test.properties;

import com.alibaba.nacos.api.naming.listener.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author wangerxiao
 * @date 2020/5/31 2:26
 * @email 784665813@qq.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustEvent implements Event {

    private String key;
}
