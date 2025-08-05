package com.youth.banner.transformer;

import android.view.View;

import androidx.viewpager2.widget.ViewPager2;


/**
 * 缩放退出页面变换器，继承自BasePageTransformer
 * 通过改变页面的缩放和透明度来实现页面切换动画效果
 */
public class ZoomOutPageTransformer extends BasePageTransformer {
    /**
     * 默认最小缩放值
     */
    private static final float DEFAULT_MIN_SCALE = 0.85f;
    
    /**
     * 默认最小透明度值
     */
    private static final float DEFAULT_MIN_ALPHA = 0.5f;
    
    /**
     * 最小缩放值
     */
    private float mMinScale = DEFAULT_MIN_SCALE;
    
    /**
     * 最小透明度值
     */
    private float mMinAlpha = DEFAULT_MIN_ALPHA;

    /**
     * 构造方法，使用默认最小缩放值和透明度
     */
    public ZoomOutPageTransformer() {
    }

    /**
     * 构造方法
     * @param minScale 最小缩放值
     * @param minAlpha 最小透明度值
     */
    public ZoomOutPageTransformer(float minScale,float minAlpha ) {
        this.mMinScale = minScale;
        this.mMinAlpha = minAlpha;
    }

    /**
     * 变换页面
     * @param view 页面视图
     * @param position 位置
     */
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // 这个页面在屏幕左侧很远的位置
            view.setAlpha(0f);

        } else if (position <= 1) { // [-1,1]
            // 修改默认的滑动过渡以同时缩小页面
            float scaleFactor = Math.max(mMinScale, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                view.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                view.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // 缩放页面 (在MIN_SCALE和1之间)
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

            // 根据页面大小调整透明度
            view.setAlpha(mMinAlpha +
                    (scaleFactor - mMinScale) /
                            (1 - mMinScale) * (1 - mMinAlpha));

        } else { // (1,+Infinity]
            // 这个页面在屏幕右侧很远的位置
            view.setAlpha(0f);
        }
    }
}
