package com.anbangke.wy.design.server.design_4;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wangerxiao
 * @date 2020/5/26 12:37
 * @email 784665813@qq.com
 */
public abstract class AbstractSubject {

    protected Collection<ITalent> allTalents = new ArrayList<ITalent>();


    public abstract void publish(String job);

    public void addTalent(ITalent talent) {
        allTalents.add(talent);
    }

    public void removeTalent(ITalent talent) {
        allTalents.remove(talent);
    }


}
