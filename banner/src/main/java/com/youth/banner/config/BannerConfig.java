package com.youth.banner.config;

import com.youth.banner.util.BannerUtils;

/**
 * Banner配置参数类
 * 包含轮播图的各种配置参数
 */
public class BannerConfig {
    /**
     * 是否自动轮播
     */
    public static final boolean IS_AUTO_LOOP = true;
    
    /**
     * 是否无限循环
     */
    public static final boolean IS_INFINITE_LOOP = true;
    
    /**
     * 轮播间隔时间(毫秒)
     */
    public static final int LOOP_TIME = 3000;
    
    /**
     * 滚动动画时间(毫秒)
     */
    public static final int SCROLL_TIME = 600;
    
    /**
     * 增加的数量
     */
    public static final int INCREASE_COUNT = 2;
    
    /**
     * 指示器正常颜色
     */
    public static final int INDICATOR_NORMAL_COLOR = 0x88ffffff;
    
    /**
     * 指示器选中颜色
     */
    public static final int INDICATOR_SELECTED_COLOR = 0x88000000;
    
    /**
     * 指示器正常宽度
     */
    public static final int INDICATOR_NORMAL_WIDTH = (int) BannerUtils.dp2px(5);
    
    /**
     * 指示器选中宽度
     */
    public static final int INDICATOR_SELECTED_WIDTH = (int) BannerUtils.dp2px(7);
    
    /**
     * 指示器间距
     */
    public static final int INDICATOR_SPACE = (int) BannerUtils.dp2px(5);
    
    /**
     * 指示器边距
     */
    public static final int INDICATOR_MARGIN = (int) BannerUtils.dp2px(5);
    
    /**
     * 指示器高度
     */
    public static final int INDICATOR_HEIGHT = (int) BannerUtils.dp2px(3);
    
    /**
     * 指示器圆角半径
     */
    public static final int INDICATOR_RADIUS = (int) BannerUtils.dp2px(3);

}
