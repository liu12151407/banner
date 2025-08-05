package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.util.LogUtils;

/**
 * 指示器基类
 * 所有自定义指示器的基类，提供了指示器的基本功能和配置
 */
public class BaseIndicator extends View implements Indicator {
    /**
     * 指示器配置
     */
    protected IndicatorConfig config;
    
    /**
     * 绘图画笔
     */
    protected Paint mPaint;
    
    /**
     * 偏移量
     */
    protected float offset;

    /**
     * 构造函数
     * 
     * @param context 上下文
     */
    public BaseIndicator(Context context) {
        this(context, null);
    }

    /**
     * 构造函数
     * 
     * @param context 上下文
     * @param attrs 属性集合
     */
    public BaseIndicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 构造函数
     * 
     * @param context 上下文
     * @param attrs 属性集合
     * @param defStyleAttr 默认样式属性
     */
    public BaseIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        config = new IndicatorConfig();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.TRANSPARENT);
        mPaint.setColor(config.getNormalColor());
    }

    /**
     * 获取指示器视图
     * 
     * @return 指示器视图
     */
    @NonNull
    @Override
    public View getIndicatorView() {
        if (config.isAttachToBanner()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            switch (config.getGravity()) {
                case IndicatorConfig.Direction.LEFT:
                    layoutParams.gravity = Gravity.BOTTOM | Gravity.START;
                    break;
                case IndicatorConfig.Direction.CENTER:
                    layoutParams.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                    break;
                case IndicatorConfig.Direction.RIGHT:
                    layoutParams.gravity = Gravity.BOTTOM | Gravity.END;
                    break;
            }
            layoutParams.leftMargin = config.getMargins().leftMargin;
            layoutParams.rightMargin = config.getMargins().rightMargin;
            layoutParams.topMargin = config.getMargins().topMargin;
            layoutParams.bottomMargin = config.getMargins().bottomMargin;
            setLayoutParams(layoutParams);
        }
        return this;
    }

    /**
     * 获取指示器配置
     * 
     * @return 指示器配置对象
     */
    @Override
    public IndicatorConfig getIndicatorConfig() {
        return config;
    }

    /**
     * 页面改变时调用
     * 
     * @param count 页面总数
     * @param currentPosition 当前位置
     */
    @Override
    public void onPageChanged(int count, int currentPosition) {
        config.setIndicatorSize(count);
        config.setCurrentPosition(currentPosition);
        requestLayout();
    }

    /**
     * 页面滚动时调用
     * 
     * @param position 当前位置
     * @param positionOffset 偏移比例
     * @param positionOffsetPixels 偏移像素
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        offset = positionOffset;
        invalidate();

    }

    /**
     * 页面选中时调用
     * 
     * @param position 选中的位置
     */
    @Override
    public void onPageSelected(int position) {
        config.setCurrentPosition(position);
        invalidate();
    }

    /**
     * 页面滚动状态改变时调用
     * 
     * @param state 滚动状态
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
