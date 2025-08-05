package com.youth.banner.transformer;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

/**
 * 深度页面变换器，继承自BasePageTransformer
 * 通过改变页面的透明度和缩放来实现深度切换动画效果
 */
public class DepthPageTransformer extends BasePageTransformer {
    /**
     * 默认最小缩放值
     */
    private static final float DEFAULT_MIN_SCALE = 0.75f;
    
    /**
     * 最小缩放值
     */
    private float mMinScale = DEFAULT_MIN_SCALE;

    /**
     * 构造方法，使用默认最小缩放值
     */
    public DepthPageTransformer() {
    }

    /**
     * 构造方法
     * @param minScale 最小缩放值
     */
    public DepthPageTransformer(float minScale) {
        this.mMinScale = minScale;
    }

    /**
     * 变换页面
     * @param view 页面视图
     * @param position 位置
     */
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();

        if (position < -1) { // [-Infinity,-1)
            // 这个页面在屏幕左侧很远的位置
            view.setAlpha(0f);

        } else if (position <= 0) { // [-1,0]
            // 向左移动时使用默认的滑动过渡
            view.setAlpha(1f);
            view.setTranslationX(0f);
            view.setScaleX(1f);
            view.setScaleY(1f);

        } else if (position <= 1) { // (0,1]
            // 进入页面时
            view.setVisibility(View.VISIBLE);
            // 页面淡出
            view.setAlpha(1 - position);

            // 抵消默认的滑动过渡
            view.setTranslationX(pageWidth * -position);

            // 缩放页面 (在MIN_SCALE和1之间)
            float scaleFactor = mMinScale
                    + (1 - mMinScale) * (1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            // 退出页面时
            if(position ==1){
                view.setVisibility(View.INVISIBLE);
            }

        } else { // (1,+Infinity]
            // 这个页面在屏幕右侧很远的位置
            view.setAlpha(0f);
        }
    }
}
