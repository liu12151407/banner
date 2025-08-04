package com.test.banner.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.banner.R;
import com.test.banner.adapter.MyRecyclerViewAdapter;
import com.test.banner.databinding.ActivityRecyclerviewBannerBinding;
import com.test.banner.util.ParentRecyclerView;

public class BannerListFragment extends Fragment {
    private static int index;
    private ActivityRecyclerviewBannerBinding binding;
    private RecyclerView recyclerView;
    private TextView text;

    public static Fragment newInstance(int i) {
        index = i;
        return new BannerListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ActivityRecyclerviewBannerBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // 初始化视图
        recyclerView = binding.netRv;
        text = binding.text;

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text.setText("当前页:"+index);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyRecyclerViewAdapter(getActivity()));
    }

}
