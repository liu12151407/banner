package com.youth.banner.indicator;

import android.view.View;

import androidx.annotation.NonNull;

import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.listener.OnPageChangeListener;

/**
 * 指示器接口，继承自OnPageChangeListener
 * 定义了指示器必须实现的方法
 */
public interface Indicator extends OnPageChangeListener {
    /**
     * 获取指示器视图
     * @return 指示器View实例
     */
    @NonNull
    View getIndicatorView();

    /**
     * 获取指示器配置
     * @return IndicatorConfig实例
     */
    IndicatorConfig getIndicatorConfig();

    /**
     * 页面变化时调用
     * @param count 总数
     * @param currentPosition 当前位置
     */
    void onPageChanged(int count, int currentPosition);

}
