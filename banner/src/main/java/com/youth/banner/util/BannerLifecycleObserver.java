package com.youth.banner.util;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

/**
 * Banner生命周期观察者接口，继承自LifecycleObserver
 * 定义了Banner在不同生命周期状态下的回调方法
 */
public interface BannerLifecycleObserver extends LifecycleObserver {

    /**
     * 当Banner进入停止状态时调用
     * @param owner LifecycleOwner实例
     */
    void onStop(LifecycleOwner owner);

    /**
     * 当Banner进入开始状态时调用
     * @param owner LifecycleOwner实例
     */
    void onStart(LifecycleOwner owner);

    /**
     * 当Banner被销毁时调用
     * @param owner LifecycleOwner实例
     */
    void onDestroy(LifecycleOwner owner);
}
