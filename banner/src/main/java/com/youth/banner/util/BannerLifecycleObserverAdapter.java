package com.youth.banner.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Banner生命周期观察者适配器，实现LifecycleObserver接口
 * 用于监听和转发生命周期事件到BannerLifecycleObserver
 */
public class BannerLifecycleObserverAdapter implements LifecycleObserver {
    /**
     * Banner生命周期观察者
     */
    private final BannerLifecycleObserver mObserver;
    
    /**
     * 生命周期所有者
     */
    private final LifecycleOwner mLifecycleOwner;

    /**
     * 构造方法
     * @param lifecycleOwner 生命周期所有者
     * @param observer Banner生命周期观察者
     */
    public BannerLifecycleObserverAdapter(LifecycleOwner lifecycleOwner, BannerLifecycleObserver observer) {
        mLifecycleOwner = lifecycleOwner;
        mObserver = observer;
    }

    /**
     * 当生命周期变为START状态时调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        LogUtils.i("onStart");
        mObserver.onStart(mLifecycleOwner);
    }

    /**
     * 当生命周期变为STOP状态时调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        LogUtils.i("onStop");
        mObserver.onStop(mLifecycleOwner);
    }

    /**
     * 当生命周期变为DESTROY状态时调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        LogUtils.i("onDestroy");
        mObserver.onDestroy(mLifecycleOwner);
    }

}