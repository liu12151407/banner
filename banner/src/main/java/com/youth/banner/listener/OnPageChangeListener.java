package com.youth.banner.listener;

import androidx.annotation.Px;
import androidx.viewpager2.widget.ViewPager2;


/**
 * 页面变化监听器接口
 * 定义了页面滚动、选中和滚动状态变化的回调方法
 */
public interface OnPageChangeListener {
    /**
     * 当页面滚动时调用此方法
     * 无论是程序启动的平滑滚动还是用户触摸滚动都会触发
     *
     * @param position             当前显示第一页的位置索引
     *                             如果positionOffset不为零，则position+1页将可见
     * @param positionOffset       从[0, 1)的值，表示从position位置的偏移量
     * @param positionOffsetPixels 以像素为单位的值，表示从position的偏移量
     */
    void onPageScrolled(int position, float positionOffset, @Px int positionOffsetPixels);

    /**
     * 当新页面被选中时调用此方法
     * 动画不一定完成
     *
     * @param position 新选中页面的位置索引
     */
    void onPageSelected(int position);

    /**
     * 当滚动状态改变时调用
     * 用于发现用户何时开始拖拽、何时启动模拟拖拽、
     * 何时自动停靠到当前页面，或何时完全停止/空闲
     * 
     * {@code state} 可以是以下之一:
     * {@link ViewPager2.SCROLL_STATE_IDLE},
     * {@link ViewPager2.SCROLL_STATE_DRAGGING},
     * {@link ViewPager2.SCROLL_STATE_SETTLING}.
     */
    void onPageScrollStateChanged(@ViewPager2.ScrollState int state);
}
