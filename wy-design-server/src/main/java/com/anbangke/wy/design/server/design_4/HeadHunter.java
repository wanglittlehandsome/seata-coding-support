package com.anbangke.wy.design.server.design_4;

/**
 * @author wangerxiao
 * @date 2020/5/26 12:41
 * @email 784665813@qq.com
 */
public class HeadHunter extends AbstractSubject {

    @Override
    public void publish(String job) {
        allTalents.forEach(talent -> talent.newJob(job));
    }
}
