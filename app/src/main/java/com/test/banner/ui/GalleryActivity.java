package com.test.banner.ui;

import android.os.Bundle;
import android.view.View;

import com.test.banner.R;
import com.test.banner.adapter.ImageAdapter;
import com.test.banner.adapter.ImageNetAdapter;
import com.test.banner.bean.DataBean;
import com.test.banner.databinding.ActivityGalleryBinding;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.indicator.DrawableIndicator;
import com.youth.banner.transformer.AlphaPageTransformer;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {

    private ActivityGalleryBinding binding;
    private Banner mBanner1;
    private Banner mBanner2;
    private DrawableIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGalleryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化视图
        mBanner1 = binding.banner1;
        mBanner2 = binding.banner2;
        indicator = binding.indicator;

        /**
         * 画廊效果
         */
        mBanner1.setAdapter(new ImageAdapter(DataBean.getTestData2()));
        mBanner1.setIndicator(new CircleIndicator(this));
        //添加画廊效果
        mBanner1.setBannerGalleryEffect(50, 10);
        //(可以和其他PageTransformer组合使用，比如AlphaPageTransformer，注意但和其他带有缩放的PageTransformer会显示冲突)
        //添加透明效果(画廊配合透明效果更棒)
        //mBanner1.addPageTransformer(new AlphaPageTransformer());


        /**
         * 魅族效果
         */
        mBanner2.setAdapter(new ImageAdapter(DataBean.getTestData()));
        mBanner2.setIndicator(indicator,false);
        //添加魅族效果
        mBanner2.setBannerGalleryMZ(20);



    }


}