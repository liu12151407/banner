package com.youth.banner.transformer;

import android.view.View;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/**
 * 缩放页面变换器，继承自BasePageTransformer
 * 通过改变页面的缩放来实现页面切换动画效果
 */
public class ScaleInTransformer extends BasePageTransformer {
    /**
     * 默认最小缩放值
     */
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    
    /**
     * 最小缩放值
     */
    private float mMinScale = DEFAULT_MIN_SCALE;

    /**
     * 构造方法，使用默认最小缩放值
     */
    public ScaleInTransformer() {
    }

    /**
     * 构造方法
     * @param minScale 最小缩放值
     */
    public ScaleInTransformer(float minScale) {
        this.mMinScale = minScale;
    }

    /**
     * 变换页面
     * @param view 页面视图
     * @param position 位置
     */
    @Override
    public void transformPage(@NonNull View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        view.setPivotY(pageHeight / 2);
        view.setPivotX(pageWidth / 2);
        if (position < -1) { // [-Infinity,-1)
            // 这个页面在屏幕左侧很远的位置
            view.setScaleX(mMinScale);
            view.setScaleY(mMinScale);
            view.setPivotX(pageWidth);
        } else if (position <= 1) { // [-1,1]
            // 修改默认的滑动过渡以同时缩小页面
            if (position < 0) //1-2:1[0,-1] ;2-1:1[-1,0]
            {

                float scaleFactor = (1 + position) * (1 - mMinScale) + mMinScale;
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                view.setPivotX(pageWidth * (DEFAULT_CENTER + (DEFAULT_CENTER * -position)));

            } else //1-2:2[1,0] ;2-1:2[0,1]
            {
                float scaleFactor = (1 - position) * (1 - mMinScale) + mMinScale;
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
                view.setPivotX(pageWidth * ((1 - position) * DEFAULT_CENTER));
            }


        } else { // (1,+Infinity]
            view.setPivotX(0);
            view.setScaleX(mMinScale);
            view.setScaleY(mMinScale);
        }
    }
}
