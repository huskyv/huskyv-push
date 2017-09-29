package com.huskyv.core.error;

/**
 * 错误监听器
 * Created by qi.zhang
 */
public interface ErrorListener {

    /**
     * 处理错误
     *
     * @param errorModel
     */
    void handle(ErrorModel errorModel);

}
