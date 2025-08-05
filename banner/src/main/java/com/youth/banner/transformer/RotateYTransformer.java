package com.youth.banner.transformer;

import android.view.View;

import androidx.annotation.NonNull;

/**
 * Y轴旋转页面变换器，继承自BasePageTransformer
 * 通过围绕Y轴旋转来实现页面切换动画效果
 */
public class RotateYTransformer extends BasePageTransformer {
    /**
     * 默认最大旋转角度
     */
    private static final float DEFAULT_MAX_ROTATE = 35f;
    
    /**
     * 最大旋转角度
     */
    private float mMaxRotate = DEFAULT_MAX_ROTATE;

    /**
     * 构造方法，使用默认最大旋转角度
     */
    public RotateYTransformer() {
    }

    /**
     * 构造方法
     * @param maxRotate 最大旋转角度
     */
    public RotateYTransformer(float maxRotate) {
        mMaxRotate = maxRotate;
    }

    /**
     * 变换页面
     * @param view 页面视图
     * @param position 位置
     */
    @Override
    public void transformPage(@NonNull View view, float position) {
        view.setPivotY(view.getHeight()/2);

        if (position < -1) { // [-Infinity,-1)
            // 这个页面在屏幕左侧很远的位置
            view.setRotationY(-1 * mMaxRotate);
            view.setPivotX(view.getWidth());
        } else if (position <= 1) { // [-1,1]
            // 修改默认的滑动过渡以同时缩小页面
            view.setRotationY(position * mMaxRotate);

            //[0,-1]
            if (position < 0) {
                view.setPivotX(view.getWidth() * (DEFAULT_CENTER + DEFAULT_CENTER * (-position)));
                view.setPivotX(view.getWidth());
            } else {//[1,0]
                view.setPivotX(view.getWidth() * DEFAULT_CENTER * (1 - position));
                view.setPivotX(0);
            }

            // 缩放页面 (在MIN_SCALE和1之间)
        } else {
            // (1,+Infinity]
            // 这个页面在屏幕右侧很远的位置
            view.setRotationY(1 * mMaxRotate);
            view.setPivotX(0);
        }
    }
}
