package com.youth.banner.transformer;

import androidx.viewpager2.widget.ViewPager2;

/**
 * 页面变换器基类，实现ViewPager2.PageTransformer接口
 * 为自定义页面切换动画提供基础支持
 */
public abstract class BasePageTransformer implements ViewPager2.PageTransformer {
    /**
     * 默认中心位置
     */
    public static final float DEFAULT_CENTER = 0.5f;


}
