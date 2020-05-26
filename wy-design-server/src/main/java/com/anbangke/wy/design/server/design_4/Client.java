package com.anbangke.wy.design.server.design_4;

/**
 * @author wangerxiao
 * @date 2020/5/26 12:41
 * @email 784665813@qq.com
 */
public class Client {


    public static void main(String[] args) {
        ITalent talent = new Architect();
        AbstractSubject subject = new HeadHunter();
        subject.addTalent(talent);
        subject.publish("a good position");
    }
}
