package com.test.banner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.test.banner.R;
import com.test.banner.adapter.ImageNetAdapter;
import com.test.banner.bean.DataBean;
import com.test.banner.databinding.BannerBinding;
import com.youth.banner.Banner;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.util.BannerUtils;

public class BannerFragment extends Fragment {

    private BannerBinding binding;
    private Banner banner;

    public static Fragment newInstance() {
        return new BannerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BannerBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // 初始化视图
        banner = binding.banner;

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        banner.setAdapter(new ImageNetAdapter(DataBean.getTestData3()));
        banner.setIndicator(new RectangleIndicator(getActivity()));
        banner.setIndicatorSpace((int) BannerUtils.dp2px(4));
        banner.setIndicatorRadius(0);
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stop();
    }
}
