package com.youth.banner.transformer;

import android.view.View;

import androidx.annotation.NonNull;

/**
 * 向上旋转页面变换器，继承自BasePageTransformer
 * 通过围绕页面顶部中心点旋转来实现页面切换动画效果
 */
public class RotateUpPageTransformer extends BasePageTransformer {
    /**
     * 默认最大旋转角度
     */
    private static final float DEFAULT_MAX_ROTATE = 15.0f;
    
    /**
     * 最大旋转角度
     */
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    /**
     * 构造方法，使用默认最大旋转角度
     */
    public RotateUpPageTransformer() {
    }

    /**
     * 构造方法
     * @param maxRotate 最大旋转角度
     */
    public RotateUpPageTransformer(float maxRotate) {
        mMaxRotate = maxRotate;
    }

    /**
     * 变换页面
     * @param view 页面视图
     * @param position 位置
     */
    @Override
    public void transformPage(@NonNull View view, float position) {
        if (position < -1) { // [-Infinity,-1)
            // 这个页面在屏幕左侧很远的位置
            view.setRotation(mMaxRotate);
            view.setPivotX(view.getWidth());
            view.setPivotY(0);
        } else if (position <= 1) {  // a页滑动至b页 ； a页从 0.0 ~ -1 ；b页从1 ~ 0.0
            // [-1,1]
            // 修改默认的滑动过渡以同时缩小页面
            if (position < 0) {//[0，-1]
                view.setPivotX(view.getWidth() * (0.5f + 0.5f * (-position)));
                view.setPivotY(0);
                view.setRotation(-mMaxRotate * position);
            } else {//[1,0]
                view.setPivotX(view.getWidth() * 0.5f * (1 - position));
                view.setPivotY(0);
                view.setRotation(-mMaxRotate * position);
            }
        } else { // (1,+Infinity]
            // 这个页面在屏幕右侧很远的位置
            // ViewHelper.setRotation(view, ROT_MAX);
            view.setRotation(-mMaxRotate);
            view.setPivotX(0);
            view.setPivotY(0);
        }
    }
}
