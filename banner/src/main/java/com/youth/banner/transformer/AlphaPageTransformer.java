package com.youth.banner.transformer;

import android.view.View;

import androidx.annotation.NonNull;

/**
 * 透明度页面变换器，继承自BasePageTransformer
 * 通过改变页面的透明度来实现页面切换动画效果
 */
public class AlphaPageTransformer extends BasePageTransformer {
    /**
     * 默认最小透明度值
     */
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    
    /**
     * 最小透明度
     */
    private float mMinAlpha = DEFAULT_MIN_ALPHA;

    /**
     * 构造方法，使用默认最小透明度
     */
    public AlphaPageTransformer() {
    }

    /**
     * 构造方法
     * @param minAlpha 最小透明度值
     */
    public AlphaPageTransformer(float minAlpha) {
        mMinAlpha = minAlpha;
    }

    /**
     * 变换页面
     * @param view 页面视图
     * @param position 位置
     */
    @Override
    public void transformPage(@NonNull View view, float position) {
        view.setScaleX(0.999f);//hack

        if (position < -1) { // [-Infinity,-1)
            view.setAlpha(mMinAlpha);
        } else if (position <= 1) { // [-1,1]
            //[0，-1]
            if (position < 0) {
                //[1,min]
                float factor = mMinAlpha + (1 - mMinAlpha) * (1 + position);
                view.setAlpha(factor);
            } else {//[1，0]
                //[min,1]
                float factor = mMinAlpha + (1 - mMinAlpha) * (1 - position);
                view.setAlpha(factor);
            }
        } else { // (1,+Infinity]
            view.setAlpha(mMinAlpha);
        }
    }
}
