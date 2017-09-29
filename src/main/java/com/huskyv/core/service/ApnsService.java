package com.huskyv.core.service;


import com.huskyv.core.model.PushNotification;

public interface ApnsService {

    /**
     * 发送通知(异步)
     *
     * @param notification
     */
    void sendNotification(PushNotification notification);

    /**
     * 发送通知(同步)
     *
     * @param notification
     * @return
     */
    boolean sendNotificationSynch(PushNotification notification);

    /**
     * 关闭服务
     */
    void shutdown();

}
