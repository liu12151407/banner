package com.youth.banner.holder;

import android.view.ViewGroup;

/**
 * ViewHolder接口，定义了创建和绑定ViewHolder的方法
 * @param <T> 数据类型
 * @param <VH> ViewHolder类型
 */
public interface IViewHolder<T, VH> {

    /**
     * 创建ViewHolder
     *
     * @param parent 父布局
     * @param viewType 视图类型
     * @return ViewHolder实例
     */
    VH onCreateHolder(ViewGroup parent, int viewType);

    /**
     * 绑定布局数据
     *
     * @param holder   ViewHolder实例
     * @param data     数据实体
     * @param position 当前位置
     * @param size     总数
     */
    void onBindView(VH holder, T data, int position, int size);

}
