package com.anbangke.userserver.test.properties;

import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.pojo.ServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author wangerxiao
 * @date 2020/5/30 23:47
 * @email 784665813@qq.com
 */
@Slf4j
public class CustEventDispatcher {

    private ExecutorService executorService = null;

    private BlockingQueue<CustInfo> changedServices = new LinkedBlockingQueue<CustInfo>();


    private ConcurrentMap<String, List<EventListener>> observerMap
            = new ConcurrentHashMap<>();

    public CustEventDispatcher() {
        executorService = Executors.newSingleThreadExecutor(r -> {
            Thread thread = new Thread(r, "com.anbangke.userserver.test.properties.listenner");
            thread.setDaemon(true);
            return thread;
        });
        executorService.execute(new Notifier());

    }

    public void serviceChanged(CustInfo custInfo) {
        if (custInfo == null) {
            return;
        }

        changedServices.add(custInfo);
    }

    private class Notifier implements Runnable {

        @Override
        public void run() {
            while (true) {
                CustInfo custInfo = null;
                try {
                    custInfo = changedServices.poll(5, TimeUnit.MINUTES);
                } catch (Exception ignore) {
                }
                if (custInfo == null) {
                    continue;
                }
                try {
                    List<EventListener> listeners = observerMap.get(custInfo.getKey());

                    for (EventListener listener : listeners) {
                        listener.onEvent(new CustEvent(custInfo.getKey()));
                    }

                } catch (Exception e) {
                    log.error("[NA] notify error for service: {}", custInfo.getKey());
                }
            }
        }
    }
}
