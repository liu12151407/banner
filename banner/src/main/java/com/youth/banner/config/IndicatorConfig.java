package com.youth.banner.config;

import androidx.annotation.ColorInt;
import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 指示器配置类
 * 用于配置轮播图指示器的各种属性，如颜色、大小、位置等
 */
public class IndicatorConfig {

    // 指示器数量
    private int indicatorSize;
    // 当前位置
    private int currentPosition;
    // 指示器对齐方式
    private int gravity = Direction.CENTER;
    // 指示器间距
    private int indicatorSpace = BannerConfig.INDICATOR_SPACE;
    // 指示器正常宽度
    private int normalWidth = BannerConfig.INDICATOR_NORMAL_WIDTH;
    // 指示器选中宽度
    private int selectedWidth = BannerConfig.INDICATOR_SELECTED_WIDTH;
    // 指示器正常颜色
    @ColorInt
    private int normalColor = BannerConfig.INDICATOR_NORMAL_COLOR;
    // 指示器选中颜色
    @ColorInt
    private int selectedColor = BannerConfig.INDICATOR_SELECTED_COLOR;

    // 指示器圆角半径
    private int radius = BannerConfig.INDICATOR_RADIUS;
    // 指示器高度
    private int height = BannerConfig.INDICATOR_HEIGHT;

    // 指示器边距
    private Margins margins;

    // 是否将指示器添加到banner上
    private boolean attachToBanner = true;

    /**
     * 指示器对齐方向枚举
     * 定义了指示器可以放置的三个位置：左、中、右
     */
    @IntDef({Direction.LEFT, Direction.CENTER, Direction.RIGHT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        // 左对齐
        int LEFT = 0;
        // 居中对齐
        int CENTER = 1;
        // 右对齐
        int RIGHT = 2;
    }

    /**
     * 边距配置类
     * 用于设置指示器四个方向的边距
     */
    public static class Margins {
        // 左边距
        public int leftMargin;
        // 上边距
        public int topMargin;
        // 右边距
        public int rightMargin;
        // 下边距
        public int bottomMargin;

        /**
         * 默认构造函数
         * 使用BannerConfig中定义的默认边距
         */
        public Margins() {
            this(BannerConfig.INDICATOR_MARGIN);
        }

        /**
         * 构造函数
         * 四个方向使用相同的边距值
         *
         * @param marginSize 边距大小
         */
        public Margins(int marginSize) {
            this(marginSize, marginSize, marginSize, marginSize);
        }

        /**
         * 构造函数
         * 分别设置四个方向的边距
         *
         * @param leftMargin   左边距
         * @param topMargin    上边距
         * @param rightMargin  右边距
         * @param bottomMargin 下边距
         */
        public Margins(int leftMargin, int topMargin, int rightMargin, int bottomMargin) {
            this.leftMargin = leftMargin;
            this.topMargin = topMargin;
            this.rightMargin = rightMargin;
            this.bottomMargin = bottomMargin;
        }
    }

    /**
     * 获取边距配置
     * 如果边距配置为空，则创建一个新的默认边距配置
     *
     * @return 边距配置对象
     */
    public Margins getMargins() {
        if (margins == null) {
            setMargins(new Margins());
        }
        return margins;
    }

    /**
     * 设置边距配置
     *
     * @param margins 边距配置对象
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setMargins(Margins margins) {
        this.margins = margins;
        return this;
    }

    /**
     * 获取指示器数量
     *
     * @return 指示器数量
     */
    public int getIndicatorSize() {
        return indicatorSize;
    }

    /**
     * 设置指示器数量
     *
     * @param indicatorSize 指示器数量
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setIndicatorSize(int indicatorSize) {
        this.indicatorSize = indicatorSize;
        return this;
    }

    /**
     * 获取指示器正常颜色
     *
     * @return 指示器正常颜色值
     */
    public int getNormalColor() {
        return normalColor;
    }

    /**
     * 设置指示器正常颜色
     *
     * @param normalColor 指示器正常颜色值
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setNormalColor(int normalColor) {
        this.normalColor = normalColor;
        return this;
    }

    /**
     * 获取指示器选中颜色
     *
     * @return 指示器选中颜色值
     */
    public int getSelectedColor() {
        return selectedColor;
    }

    /**
     * 设置指示器选中颜色
     *
     * @param selectedColor 指示器选中颜色值
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setSelectedColor(int selectedColor) {
        this.selectedColor = selectedColor;
        return this;
    }

    /**
     * 获取指示器间距
     *
     * @return 指示器间距值
     */
    public int getIndicatorSpace() {
        return indicatorSpace;
    }

    /**
     * 设置指示器间距
     *
     * @param indicatorSpace 指示器间距值
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setIndicatorSpace(int indicatorSpace) {
        this.indicatorSpace = indicatorSpace;
        return this;
    }

    /**
     * 获取当前位置
     *
     * @return 当前位置索引
     */
    public int getCurrentPosition() {
        return currentPosition;
    }

    /**
     * 设置当前位置
     *
     * @param currentPosition 当前位置索引
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
        return this;
    }

    /**
     * 获取指示器正常宽度
     *
     * @return 指示器正常宽度值
     */
    public int getNormalWidth() {
        return normalWidth;
    }

    /**
     * 设置指示器正常宽度
     *
     * @param normalWidth 指示器正常宽度值
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setNormalWidth(int normalWidth) {
        this.normalWidth = normalWidth;
        return this;
    }

    /**
     * 获取指示器选中宽度
     *
     * @return 指示器选中宽度值
     */
    public int getSelectedWidth() {
        return selectedWidth;
    }

    /**
     * 设置指示器选中宽度
     *
     * @param selectedWidth 指示器选中宽度值
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setSelectedWidth(int selectedWidth) {
        this.selectedWidth = selectedWidth;
        return this;
    }

    /**
     * 获取指示器对齐方式
     *
     * @return 指示器对齐方式
     */
    public int getGravity() {
        return gravity;
    }

    /**
     * 设置指示器对齐方式
     *
     * @param gravity 指示器对齐方式
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setGravity(@Direction int gravity) {
        this.gravity = gravity;
        return this;
    }

    /**
     * 是否将指示器添加到banner上
     *
     * @return true表示添加到banner上，false表示不添加
     */
    public boolean isAttachToBanner() {
        return attachToBanner;
    }

    /**
     * 设置是否将指示器添加到banner上
     *
     * @param attachToBanner true表示添加到banner上，false表示不添加
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setAttachToBanner(boolean attachToBanner) {
        this.attachToBanner = attachToBanner;
        return this;
    }

    /**
     * 获取指示器圆角半径
     *
     * @return 指示器圆角半径值
     */
    public int getRadius() {
        return radius;
    }

    /**
     * 设置指示器圆角半径
     *
     * @param radius 指示器圆角半径值
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setRadius(int radius) {
        this.radius = radius;
        return this;
    }

    /**
     * 获取指示器高度
     *
     * @return 指示器高度值
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置指示器高度
     *
     * @param height 指示器高度值
     * @return 当前指示器配置实例
     */
    public IndicatorConfig setHeight(int height) {
        this.height = height;
        return this;
    }
}
