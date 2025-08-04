package com.test.banner.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.test.banner.R;
import com.test.banner.adapter.MyRecyclerViewAdapter;
import com.test.banner.databinding.ActivityRecyclerviewBannerBinding;

public class RecyclerViewBannerActivity extends AppCompatActivity {
    private ActivityRecyclerviewBannerBinding binding;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerviewBannerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 初始化视图
        recyclerView = binding.netRv;

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerViewAdapter(this));
    }

}
