package com.youth.banner.transformer;

import android.view.View;

import androidx.annotation.NonNull;

/**
 * 向下旋转页面变换器，继承自BasePageTransformer
 * 通过围绕页面底部中心点旋转来实现页面切换动画效果
 */
public class RotateDownPageTransformer extends BasePageTransformer {
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
    public RotateDownPageTransformer() {
    }

    /**
     * 构造方法
     * @param maxRotate 最大旋转角度
     */
    public RotateDownPageTransformer(float maxRotate) {
        mMaxRotate = maxRotate;
    }

    /**
     * 变换页面
     * @param view 页面视图
     * @param position 位置
     */
    @Override
    public void transformPage(@NonNull View view, float position) {
        if (position < -1) {
            // [-Infinity,-1)
            // 这个页面在屏幕左侧很远的位置
            view.setRotation(mMaxRotate * -1);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());

        } else if (position <= 1) { // [-1,1]
            if (position < 0) {//[0，-1]
                view.setPivotX(view.getWidth() * (DEFAULT_CENTER + DEFAULT_CENTER * (-position)));
                view.setPivotY(view.getHeight());
                view.setRotation(mMaxRotate * position);
            } else {//[1,0]
                view.setPivotX(view.getWidth() * DEFAULT_CENTER * (1 - position));
                view.setPivotY(view.getHeight());
                view.setRotation(mMaxRotate * position);
            }
        } else {
            // (1,+Infinity]
            // 这个页面在屏幕右侧很远的位置
            view.setRotation(mMaxRotate);
            view.setPivotX(view.getWidth() * 0);
            view.setPivotY(view.getHeight());
        }
    }
}
