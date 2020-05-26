package com.anbangke.wy.design.server.design_4;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date 2020/5/26 12:38
 * @email 784665813@qq.com
 */
@Slf4j
public class Architect implements ITalent {

    @Override
    public void newJob(String job) {
        log.info("{} get a new job:{}", this.getClass().getSimpleName(), job);
    }
}
