package com.youth.banner.transformer;

import android.view.View;
import android.view.ViewParent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/**
 * 魅族风格缩放页面变换器，继承自BasePageTransformer
 * 实现类似魅族手机应用商店Banner的切换效果
 * 注意：单独使用效果可能不理想，推荐使用ScaleInTransformer
 */
public class MZScaleInTransformer extends BasePageTransformer {
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
    public MZScaleInTransformer() {
    }

    /**
     * 构造方法
     * @param minScale 最小缩放值
     */
    public MZScaleInTransformer(float minScale) {
        this.mMinScale = minScale;
    }

    /**
     * 变换页面
     * @param view 页面视图
     * @param position 位置
     */
    @Override
    public void transformPage(@NonNull View view, float position) {
        ViewPager2 viewPager = requireViewPager(view);
        float paddingLeft = viewPager.getPaddingLeft();
        float paddingRight = viewPager.getPaddingRight();
        float width = viewPager.getMeasuredWidth();
        float offsetPosition = paddingLeft / (width - paddingLeft - paddingRight);
        float currentPos = position - offsetPosition;
        float reduceX = 0;
        float itemWidth = view.getWidth();
        //由于左右边的缩小而减小的x的大小的一半
        reduceX = (1.0f - mMinScale) * itemWidth / 2.0f;
        if (currentPos <= -1.0f) {
            view.setTranslationX(reduceX);
            view.setScaleX(mMinScale);
            view.setScaleY(mMinScale);
        } else if (currentPos <= 1.0) {
            float scale = (1.0f - mMinScale) * Math.abs(1.0f - Math.abs(currentPos));
            float translationX = currentPos * -reduceX;
            if (currentPos <= -0.5) {//两个view中间的临界，这时两个view在同一层，左侧View需要往X轴正方向移动覆盖的值()
                view.setTranslationX(translationX + Math.abs(Math.abs(currentPos) - 0.5f) / 0.5f);
            } else if (currentPos <= 0.0f) {
                view.setTranslationX(translationX);
            } else if (currentPos >= 0.5) {//两个view中间的临界，这时两个view在同一层
                view.setTranslationX(translationX - Math.abs(Math.abs(currentPos) - 0.5f) / 0.5f);
            } else {
                view.setTranslationX(translationX);
            }
            view.setScaleX(scale + mMinScale);
            view.setScaleY(scale + mMinScale);
        } else {
            view.setScaleX(mMinScale);
            view.setScaleY(mMinScale);
            view.setTranslationX(-reduceX);
        }

    }

    /**
     * 获取ViewPager2实例
     * @param page 页面视图
     * @return ViewPager2实例
     */
    private ViewPager2 requireViewPager(@NonNull View page) {
        ViewParent parent = page.getParent();
        ViewParent parentParent = parent.getParent();

        if (parent instanceof RecyclerView && parentParent instanceof ViewPager2) {
            return (ViewPager2) parentParent;
        }

        throw new IllegalStateException(
                "Expected the page view to be managed by a ViewPager2 instance.");
    }
}
