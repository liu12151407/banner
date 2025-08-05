package com.youth.banner.holder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Banner图片ViewHolder，继承自RecyclerView.ViewHolder
 * 用于持有ImageView实例，方便在适配器中使用
 */
public class BannerImageHolder extends RecyclerView.ViewHolder {
    /**
     * ImageView实例，用于显示图片
     */
    public ImageView imageView;

    /**
     * 构造方法
     * @param view 传入的View实例，通常是一个ImageView
     */
    public BannerImageHolder(@NonNull View view) {
        super(view);
        this.imageView = (ImageView) view;
    }
}
