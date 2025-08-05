package com.youth.banner.listener;

/**
 * Banner点击事件监听器接口
 * @param <T> 数据类型
 */
public interface OnBannerListener<T> {

    /**
     * 点击事件
     *
     * @param data     数据实体
     * @param position 当前位置
     */
    void OnBannerClick(T data, int position);

}
