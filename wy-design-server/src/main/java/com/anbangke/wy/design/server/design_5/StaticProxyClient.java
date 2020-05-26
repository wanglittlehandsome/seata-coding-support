package com.anbangke.wy.design.server.design_5;

/**
 * @author wangerxiao
 * @date 2020/5/27 0:29
 * @email 784665813@qq.com
 */
public class StaticProxyClient {

    public static void main(String[] args) {
        ISubject subject = new ProxySubject();
        subject.action();
    }
}
