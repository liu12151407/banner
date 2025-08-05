package com.youth.banner.util;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.youth.banner.Banner;

import java.lang.reflect.Field;


/**
 * 轮播图滚动速度管理器
 * 用于控制ViewPager2中页面切换的滚动速度
 */
public class ScrollSpeedManger extends LinearLayoutManager {
    // 关联的Banner实例
    private Banner banner;

    /**
     * 构造函数
     * 
     * @param banner 关联的Banner实例
     * @param linearLayoutManager 原始的LinearLayoutManager
     */
    public ScrollSpeedManger(Banner banner, LinearLayoutManager linearLayoutManager) {
        super(banner.getContext(), linearLayoutManager.getOrientation(), false);
        this.banner = banner;
    }

    /**
     * 平滑滚动到指定位置
     * 重写此方法来自定义滚动速度
     * 
     * @param recyclerView RecyclerView实例
     * @param state RecyclerView状态
     * @param position 目标位置
     */
    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) {
            /**
             * 计算减速阶段的时间
             * 通过Banner的滚动时间来控制滚动速度
             * 
             * @param dx 滚动距离
             * @return 滚动时间
             */
            @Override
            protected int calculateTimeForDeceleration(int dx) {
                return banner.getScrollTime();
            }
        };
        linearSmoothScroller.setTargetPosition(position);
        startSmoothScroll(linearSmoothScroller);
    }

    /**
     * 通过反射修改ViewPager2的布局管理器
     * 用于应用自定义的滚动速度管理器
     * 
     * @param banner 关联的Banner实例
     */
    public static void reflectLayoutManager(Banner banner) {
        // 如果滚动时间小于100ms，则不应用自定义滚动速度
        if (banner.getScrollTime() < 100) return;
        try {
            ViewPager2 viewPager2 = banner.getViewPager2();
            RecyclerView recyclerView = (RecyclerView) viewPager2.getChildAt(0);
            // 设置不显示过度滚动效果
            recyclerView.setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

            // 创建并设置自定义的滚动速度管理器
            ScrollSpeedManger speedManger = new ScrollSpeedManger(banner, (LinearLayoutManager) recyclerView.getLayoutManager());
            recyclerView.setLayoutManager(speedManger);


            // 通过反射修改ViewPager2的布局管理器
            Field LayoutMangerField = ViewPager2.class.getDeclaredField("mLayoutManager");
            LayoutMangerField.setAccessible(true);
            LayoutMangerField.set(viewPager2, speedManger);

            // 修改页面转换适配器的布局管理器
            Field pageTransformerAdapterField = ViewPager2.class.getDeclaredField("mPageTransformerAdapter");
            pageTransformerAdapterField.setAccessible(true);
            Object mPageTransformerAdapter = pageTransformerAdapterField.get(viewPager2);
            if (mPageTransformerAdapter != null) {
                Class<?> aClass = mPageTransformerAdapter.getClass();
                Field layoutManager = aClass.getDeclaredField("mLayoutManager");
                layoutManager.setAccessible(true);
                layoutManager.set(mPageTransformerAdapter, speedManger);
            }
            
            // 修改滚动事件适配器的布局管理器
            Field scrollEventAdapterField = ViewPager2.class.getDeclaredField("mScrollEventAdapter");
            scrollEventAdapterField.setAccessible(true);
            Object mScrollEventAdapter = scrollEventAdapterField.get(viewPager2);
            if (mScrollEventAdapter != null) {
                Class<?> aClass = mScrollEventAdapter.getClass();
                Field layoutManager = aClass.getDeclaredField("mLayoutManager");
                layoutManager.setAccessible(true);
                layoutManager.set(mScrollEventAdapter, speedManger);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
