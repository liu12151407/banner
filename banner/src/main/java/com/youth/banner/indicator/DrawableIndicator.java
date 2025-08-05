package com.youth.banner.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;

import com.youth.banner.R;


/**
 * Drawable指示器，继承自BaseIndicator
 * 通过使用Bitmap图片来实现指示器效果
 */
public class DrawableIndicator extends BaseIndicator {
    /**
     * 默认状态下的Bitmap
     */
    private Bitmap normalBitmap;
    
    /**
     * 选中状态下的Bitmap
     */
    private Bitmap selectedBitmap;

    /**
     * 实例化Drawable指示器 ，也可以通过自定义属性设置
     * @param context 上下文
     * @param normalResId 默认状态下的图片资源ID
     * @param selectedResId 选中状态下的图片资源ID
     */
    public DrawableIndicator(Context context, @DrawableRes int normalResId, @DrawableRes int selectedResId) {
        super(context);
        normalBitmap = BitmapFactory.decodeResource(getResources(), normalResId);
        selectedBitmap = BitmapFactory.decodeResource(getResources(), selectedResId);
    }

    /**
     * 构造方法
     * @param context 上下文
     */
    public DrawableIndicator(Context context) {
        this(context, null);
    }

    /**
     * 构造方法
     * @param context 上下文
     * @param attrs 属性集合
     */
    public DrawableIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 构造方法
     * @param context 上下文
     * @param attrs 属性集合
     * @param defStyleAttr 默认样式属性
     */
    public DrawableIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DrawableIndicator);
        if (a != null) {
            BitmapDrawable normal = (BitmapDrawable) a.getDrawable(R.styleable.DrawableIndicator_normal_drawable);
            BitmapDrawable selected = (BitmapDrawable) a.getDrawable(R.styleable.DrawableIndicator_selected_drawable);
            normalBitmap = normal.getBitmap();
            selectedBitmap = selected.getBitmap();
        }
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
        if (count <= 1) {
            return;
        }
        setMeasuredDimension(selectedBitmap.getWidth() * (count - 1) + selectedBitmap.getWidth() + config.getIndicatorSpace() * (count - 1),
                Math.max(normalBitmap.getHeight(), selectedBitmap.getHeight()));
    }

    /**
     * 绘制指示器
     * @param canvas 画布
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int count = config.getIndicatorSize();
        if (count <= 1 || normalBitmap == null || selectedBitmap == null) {
            return;
        }

        float left = 0;
        for (int i = 0; i < count; i++) {
            canvas.drawBitmap(config.getCurrentPosition() == i ? selectedBitmap : normalBitmap, left, 0, mPaint);
            left += normalBitmap.getWidth() + config.getIndicatorSpace();
        }
    }


}
