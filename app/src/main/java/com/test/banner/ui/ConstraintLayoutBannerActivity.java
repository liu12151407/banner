package com.test.banner.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.test.banner.R;
import com.test.banner.adapter.ImageAdapter;
import com.test.banner.adapter.ImageNetAdapter;
import com.test.banner.adapter.ImageTitleAdapter;
import com.test.banner.bean.DataBean;
import com.test.banner.databinding.ActivityConstraintLayoutBannerBinding;
import com.youth.banner.Banner;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.util.BannerUtils;

public class ConstraintLayoutBannerActivity extends AppCompatActivity {
    private static final String TAG = "banner_log";
    private ActivityConstraintLayoutBannerBinding binding;
    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConstraintLayoutBannerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化视图
        banner = binding.banner;

        banner.setAdapter(new ImageTitleAdapter(DataBean.getTestData()));
        banner.setIndicator(new CircleIndicator(this));
        banner.setIndicatorSelectedColorRes(R.color.main_color);
        banner.setIndicatorGravity(IndicatorConfig.Direction.RIGHT);
        banner.setIndicatorMargins(new IndicatorConfig.Margins(0, 0,
                BannerConfig.INDICATOR_MARGIN, (int) BannerUtils.dp2px(12)));
        banner.addBannerLifecycleObserver(this);
    }

}
