package com.youth.banner.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.youth.banner.util.BannerUtils;

/**
 * 圆角线条指示器，继承自BaseIndicator
 * 通过绘制圆角矩形来实现指示器效果
 */
public class RoundLinesIndicator extends BaseIndicator {

    /**
     * 构造方法
     * @param context 上下文
     */
    public RoundLinesIndicator(Context context) {
        this(context, null);
    }

    /**
     * 构造方法
     * @param context 上下文
     * @param attrs 属性集合
     */
    public RoundLinesIndicator(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 构造方法
     * @param context 上下文
     * @param attrs 属性集合
     * @param defStyleAttr 默认样式属性
     */
    public RoundLinesIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setStyle(Paint.Style.FILL);
    }

    /**
     * 测量指示器尺寸
     * @param widthMeasureSpec 宽度测量规格
     * @param heightMeasureSpec 高度测量规格
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = config.getIndicatorSize();
        if (count <= 1) return;
        setMeasuredDimension((int) (config.getSelectedWidth() * count), config.getHeight());
    }

    /**
     * 绘制指示器
     * @param canvas 画布
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = config.getIndicatorSize();
        if (count <= 1) return;

        mPaint.setColor(config.getNormalColor());
        RectF oval = new RectF(0, 0, canvas.getWidth(), config.getHeight());
        canvas.drawRoundRect(oval, config.getRadius(), config.getRadius(), mPaint);

        mPaint.setColor(config.getSelectedColor());
        int left = config.getCurrentPosition() * config.getSelectedWidth();
        RectF rectF = new RectF(left, 0, left + config.getSelectedWidth(), config.getHeight());
        canvas.drawRoundRect(rectF, config.getRadius(), config.getRadius(), mPaint);
    }
}
