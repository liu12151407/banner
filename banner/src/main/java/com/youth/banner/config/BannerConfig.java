package com.youth.banner.config;

import com.youth.banner.util.BannerUtils;

/**
 * 不忘初心
 *
 * ┌───┐   ┌───┬───┬───┬───┐ ┌───┬───┬───┬───┐ ┌───┬───┬───┬───┐ ┌───┬───┬───┐  ┌┐    ┌┐    ┌┐
 * │Esc│   │ F1│ F2│ F3│ F4│ │ F5│ F6│ F7│ F8│ │ F9│F10│F11│F12│ │P/S│S L│P/B│  └┘    └┘    └┘
 * └───┘   └───┴───┴───┴───┘ └───┴───┴───┴───┘ └───┴───┴───┴───┘ └───┴───┴───┘
 * ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───────┐ ┌───┬───┬───┐ ┌───┬───┬───┬───┐
 * │~ `│! 1│@ 2│# 3│$ 4│% 5│^ 6│& 7│* 8│( 9│) 0│_ -│+ =│ BacSp │ │Ins│Hom│PUp│ │N L│ / │ * │ - │
 * ├───┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─────┤ ├───┼───┼───┤ ├───┼───┼───┼───┤
 * │ Tab │ Q │ W │ E │ R │ T │ Y │ U │ I │ O │ P │{ [│} ]│ | \ │ │Del│End│PDn│ │ 7 │ 8 │ 9 │   │
 * ├─────┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴┬──┴─────┤ └───┴───┴───┘ ├───┼───┼───┤ + │
 * │ Caps │ A │ S │ D │ F │ G │ H │ J │ K │ L │: ;│" '│ Enter  │               │ 4 │ 5 │ 6 │   │
 * ├──────┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴─┬─┴────────┤     ┌───┐     ├───┼───┼───┼───┤
 * │ Shift  │ Z │ X │ C │ V │ B │ N │ M │< ,│> .│? /│  Shift   │     │ ↑ │     │ 1 │ 2 │ 3 │   │
 * ├─────┬──┴─┬─┴──┬┴───┴───┴───┴───┴───┴──┬┴───┼───┴┬────┬────┤ ┌───┼───┼───┐ ├───┴───┼───┤ E││
 * │ Ctrl│    │Alt │         Space         │ Alt│    │    │Ctrl│ │ ← │ ↓ │ → │ │   0   │ . │←─┘│
 * └─────┴────┴────┴───────────────────────┴────┴────┴────┴────┘ └───┴───┴───┘ └───────┴───┴───┘
 *
 *  @author youth5201314/spring
 *  @date 2020/1/24
 *  banner 配置参数
 */
public class BannerConfig {
    // 是否自动轮播
    public static final boolean IS_AUTO_LOOP = true;
    // 是否无限循环
    public static final boolean IS_INFINITE_LOOP = true;
    // 轮播间隔时间(毫秒)
    public static final int LOOP_TIME = 3000;
    // 滚动动画时间(毫秒)
    public static final int SCROLL_TIME = 600;
    // 增加的数量
    public static final int INCREASE_COUNT = 2;
    // 指示器正常颜色
    public static final int INDICATOR_NORMAL_COLOR = 0x88ffffff;
    // 指示器选中颜色
    public static final int INDICATOR_SELECTED_COLOR = 0x88000000;
    // 指示器正常宽度
    public static final int INDICATOR_NORMAL_WIDTH = (int) BannerUtils.dp2px(5);
    // 指示器选中宽度
    public static final int INDICATOR_SELECTED_WIDTH = (int) BannerUtils.dp2px(7);
    // 指示器间距
    public static final int INDICATOR_SPACE = (int) BannerUtils.dp2px(5);
    // 指示器边距
    public static final int INDICATOR_MARGIN = (int) BannerUtils.dp2px(5);
    // 指示器高度
    public static final int INDICATOR_HEIGHT = (int) BannerUtils.dp2px(3);
    // 指示器圆角半径
    public static final int INDICATOR_RADIUS = (int) BannerUtils.dp2px(3);

}
