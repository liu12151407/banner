package com.youth.banner.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;

import com.youth.banner.holder.BannerImageHolder;

import java.util.List;

/**
 * 默认实现的图片适配器，继承自BannerAdapter
 * 图片加载需要自己实现，通过抽象方法onBindView实现
 */
public abstract class BannerImageAdapter<T> extends BannerAdapter<T, BannerImageHolder> {

    /**
     * 构造方法
     * @param mData 数据集合
     */
    public BannerImageAdapter(List<T> mData) {
        super(mData);
    }

    /**
     * 创建BannerImageHolder
     * @param parent 父布局
     * @param viewType 视图类型
     * @return BannerImageHolder实例
     */
    @Override
    public BannerImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerImageHolder(imageView);
    }

}
